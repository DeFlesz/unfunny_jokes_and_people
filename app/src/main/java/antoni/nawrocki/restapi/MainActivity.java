package antoni.nawrocki.restapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

import antoni.nawrocki.restapi.fragments.chuck_norris;
import antoni.nawrocki.restapi.fragments.document_list;
import antoni.nawrocki.restapi.model.DocumentModel;
import antoni.nawrocki.restapi.model.DocumentModelBuilder;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    public ArrayList<DocumentModel> documentArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.chuck_norris:
                    fragmentManager.popBackStack();
                    fragmentManager.popBackStack();
                    fragmentTransaction
                            .replace(R.id.fragment_container_view, new chuck_norris())
                            .setReorderingAllowed(true)
                            .commit();
                    return true;
                case R.id.random_user_list:
                    fragmentManager.popBackStack();
                    fragmentTransaction
                            .replace(R.id.fragment_container_view, new document_list())
                            .setReorderingAllowed(true)
                            .commit();
                    return true;
                default:
                    return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        getSupportFragmentManager().popBackStack();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        inflater.inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//
//        switch (item.getItemId()){
//            case R.id.chuck_norris:
//                fragmentManager.popBackStack();
//                fragmentTransaction
//                        .replace(R.id.fragment_container_view, new chuck_norris())
//                        .addToBackStack(null)
//                        .setReorderingAllowed(true)
//                        .commit();
//                return true;
//            case R.id.random_user_list:
//                fragmentManager.popBackStack();
//                fragmentTransaction
//                        .replace(R.id.fragment_container_view, new document_list())
//                        .addToBackStack(null)
//                        .setReorderingAllowed(true)
//                        .commit();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}