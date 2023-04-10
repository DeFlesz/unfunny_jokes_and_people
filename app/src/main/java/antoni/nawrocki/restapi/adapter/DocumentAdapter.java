package antoni.nawrocki.restapi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import antoni.nawrocki.restapi.MainActivity;
import antoni.nawrocki.restapi.R;
import antoni.nawrocki.restapi.fragments.document_view;
import antoni.nawrocki.restapi.model.DocumentModel;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
    ArrayList<DocumentModel> documentArray = new ArrayList<>();
    Context context;

    public DocumentAdapter(ArrayList<DocumentModel> documentArray, Context context){
        this.documentArray = documentArray;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.document_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DocumentModel document = documentArray.get(position);

        holder.name.setText(document.getFirstName() + " " + document.getLastName());
        holder.phone.setText(document.getPhoneNumber());
        Picasso.get().load(document.getPictureURL()).into(holder.profilePicture);

        holder.itemView.setOnClickListener(l -> {
//            Toast.makeText(l.getContext(), document.toString(), Toast.LENGTH_SHORT).show();

            Bundle bundle = new Bundle();
            bundle.putString("firstName", document.getFirstName());
            bundle.putString("lastName", document.getLastName());
            bundle.putString("bigImageURL", document.getBigPictureURL());
            bundle.putString("imageURL", document.getPictureURL());
            bundle.putString("phone", document.getPhoneNumber());
            bundle.putString("title", document.getTitle());
            bundle.putString("email", document.getEmail());
            bundle.putString("address", document.getAddress());
            bundle.putString("birthday", document.getBirthDate());
            document_view fragment = new document_view();
            fragment.setArguments(bundle);

//            ((MainActivity) context).getSupportActionBar().hide();

            FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .replace(R.id.fragment_container_view, fragment)
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return documentArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView profilePicture;
        TextView name;
        TextView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profilePicture = itemView.findViewById(R.id.item_profile_picture);
            name = itemView.findViewById(R.id.item_name);
            phone = itemView.findViewById(R.id.item_phone);
        }
    }
}
