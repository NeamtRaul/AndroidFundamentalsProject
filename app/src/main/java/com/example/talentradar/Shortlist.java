package com.example.talentradar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Shortlist extends AppCompatActivity {
    private BottomNavigationView mBottomNavMenu;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortlist);

        mBottomNavMenu = findViewById(R.id.myMainMenuBottomNav);
        mBottomNavMenu.setSelectedItemId(R.id.myShortlist);

        mBottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.myMainPage:
                        Intent intent = new Intent (Shortlist.this,MainMenu.class);
                        startActivity(intent);
                        return true;
                    case R.id.myShortlist:
                        return true;

                }
                return false;
            }
        });
    }
}
