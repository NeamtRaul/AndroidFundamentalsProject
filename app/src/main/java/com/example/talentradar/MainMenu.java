package com.example.talentradar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {
    private BottomNavigationView mBottomNavMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        mBottomNavMenu = findViewById(R.id.myMainMenuBottomNav);
        mBottomNavMenu.setSelectedItemId(R.id.myMainPage);

        mBottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.myMainPage:
                        startActivity(new Intent (MainMenu.this,SecondActivity.class));
                        return true;
                    case R.id.myShortlist:
                        Intent intent = new Intent (MainMenu.this,Shortlist.class);
                        startActivity(intent);
                        return true;

                }
                return false;
            }
        });
    }
}
