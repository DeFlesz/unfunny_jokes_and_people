package antoni.nawrocki.restapi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import antoni.nawrocki.restapi.R;
import jp.wasabeef.picasso.transformations.BlurTransformation;

public class document_view extends Fragment {

    private static final String ARG_FIRST_NAME = "firstName";
    private static final String ARG_TITLE = "title";
    private static final String ARG_LAST_NAME = "lastName";
    private static final String ARG_IMAGE_URL = "imageURL";
    private static final String ARG_BIG_IMAGE_URL = "bigImageURL";

    private static final String ARG_PHONE = "phone";
    private static final String ARG_EMAIL = "email";
    private static final String ARG_ADDRESS = "address";
    private static final String ARG_BIRTHDAY = "birthday";


    // TODO: Rename and change types of parameters
    private String firstName;
    private String lastName;
    private String imageURL;
    private String bigImageURL;
    private String title;
    private String phone;
    private String email;
    private String address;
    private String birthday;

    public document_view() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firstName = getArguments().getString(ARG_FIRST_NAME);
            lastName = getArguments().getString(ARG_LAST_NAME);
            imageURL = getArguments().getString(ARG_IMAGE_URL);
            bigImageURL = getArguments().getString(ARG_BIG_IMAGE_URL);

            title = getArguments().getString(ARG_TITLE);
            imageURL = getArguments().getString(ARG_IMAGE_URL);
            phone = getArguments().getString(ARG_PHONE);
            email = getArguments().getString(ARG_EMAIL);
            address = getArguments().getString(ARG_ADDRESS);
            birthday = getArguments().getString(ARG_BIRTHDAY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView displayName = view.findViewById(R.id.name_display);
        displayName.setText(title + " " + firstName + " " + lastName);
        ImageView profileBackground = view.findViewById(R.id.view_profile_picture);
        ImageView profilePicture = view.findViewById(R.id.view_profile_center_picture);

        TextView birthdayView = view.findViewById(R.id.view_birthday);
        TextView addressView = view.findViewById(R.id.view_adress);
        TextView emailView = view.findViewById(R.id.view_email);
        TextView phoneView = view.findViewById(R.id.view_phone_number);

        birthdayView.setText(birthday);
        addressView.setText(address);
        emailView.setText(email);
        phoneView.setText(phone);

        Picasso.get().load(bigImageURL).transform(new BlurTransformation(getContext(), 5, 1)).into(profileBackground);
        Picasso.get().load(bigImageURL).into(profilePicture);
    }
}