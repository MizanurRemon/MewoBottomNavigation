package com.example.mewobottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import meow.bottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = findViewById(R.id.navigation);

        bottomNavigationBar.add(new MeowBottomNavigation.Model(1, R.drawable.home_24));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(2, R.drawable.notifications_24));
        bottomNavigationBar.add(new MeowBottomNavigation.Model(3, R.drawable.person_24));

        bottomNavigationBar.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                Toast.makeText(MainActivity.this, String.valueOf(model.getId())+" clicked", Toast.LENGTH_SHORT).show();
                return null;
            }
        });

        bottomNavigationBar.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                Fragment fragment = null;

                switch (model.getId()){
                    case 1:
                        fragment = new Fragment_one();
                        break;
                    case 2:
                        fragment = new Fragment_two();
                        break;
                    case 3:
                        fragment = new Fragment_three();
                        break;
                }
                
                load_fragment(fragment);
                return null;
            }

           
        });

        //bottomNavigationBar.setCount(2, "8");
        bottomNavigationBar.show(1, true);

    }

    private void load_fragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }


}