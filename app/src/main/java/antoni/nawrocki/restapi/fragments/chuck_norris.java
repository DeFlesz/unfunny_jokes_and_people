package antoni.nawrocki.restapi.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import antoni.nawrocki.restapi.R;
import antoni.nawrocki.restapi.task.ChuckNorrisRunnable;
import antoni.nawrocki.restapi.task.NewPersonRunnable;

public class chuck_norris extends Fragment {

    public chuck_norris() {
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
        return inflater.inflate(R.layout.fragment_chuck_norris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(
                new ChuckNorrisRunnable(this, view.findViewById(R.id.joke_conatiner))
        );

        SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiperefreshnorris);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            executor.execute(
                    new ChuckNorrisRunnable(chuck_norris.this, view.findViewById(R.id.joke_conatiner))
            );

            swipeRefreshLayout.setRefreshing(false);
        });
    }
}