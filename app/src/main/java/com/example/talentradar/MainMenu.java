package com.example.talentradar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {
    private BottomNavigationView mBottomNavMenu;
    private Button mButtonU19, mButtonU17, mButtonU15, mButtonU13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        mBottomNavMenu = findViewById(R.id.myMainMenuBottomNav);
        mBottomNavMenu.setSelectedItemId(R.id.myMainPage);
        mButtonU19 = findViewById(R.id.myU19Button);
        mButtonU17 = findViewById(R.id.myU17Button);
        mButtonU15 = findViewById(R.id.myU15Button);
        mButtonU13 = findViewById(R.id.myU13Button);
        mButtonU19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,teams.class);
                startActivity(intent);
            }
        });
        mButtonU17.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,teams.class);
                startActivity(intent);
            }
        });
        mButtonU15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,teams.class);
                startActivity(intent);
            }
        });
        mButtonU13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this,teams.class);
                startActivity(intent);
            }
        });
        mBottomNavMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.myMainPage:
                        return true;
                    case R.id.myShortlist:
                        startActivity(new Intent (MainMenu.this,Shortlist.class));
                        return true;

                }
                return false;
            }
        });
    }
}
