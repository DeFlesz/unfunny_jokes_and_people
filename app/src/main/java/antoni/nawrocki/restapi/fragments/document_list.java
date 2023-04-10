package antoni.nawrocki.restapi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import antoni.nawrocki.restapi.MainActivity;
import antoni.nawrocki.restapi.R;
import antoni.nawrocki.restapi.adapter.DocumentAdapter;
import antoni.nawrocki.restapi.model.DocumentModelBuilder;
import antoni.nawrocki.restapi.task.NewPersonRunnable;

public class document_list extends Fragment {
    MainActivity mainActivity;
    RecyclerView recyclerView;
    FloatingActionButton newDocumentButton;

    public document_list() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainActivity = (MainActivity) getActivity();

        recyclerView = view.findViewById(R.id.recycler_view);
        newDocumentButton = view.findViewById(R.id.new_document_button);

        DocumentAdapter documentAdapter = new DocumentAdapter(mainActivity.documentArray, mainActivity);
        recyclerView.setAdapter(documentAdapter);

        Executor executor = Executors.newSingleThreadExecutor();

        newDocumentButton.setOnClickListener(l -> {
            executor.execute(
                    new NewPersonRunnable(mainActivity, "https://randomuser.me/api", documentAdapter)
            );

        });

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiperefresh);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            mainActivity.documentArray.clear();
            documentAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);
        });
    }

}