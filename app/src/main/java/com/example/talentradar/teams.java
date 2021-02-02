package com.example.talentradar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class teams extends AppCompatActivity {
    private ArrayList<String> nEchipe;
    private LinearLayoutManager mListLayoutManager;
    private RecyclerView nList;
    private RecyclerViewAdapter nAdapter;
    private Button mSeePlayersButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);

        nEchipe = new ArrayList<>();
        for(int i=1;i<100;i++) {
            nEchipe.add("Echipa "+i);
        }

        mSeePlayersButton = findViewById(R.id.mySeePlayersButton);
        mListLayoutManager = new LinearLayoutManager(this);
        nList = findViewById(R.id.actMain_listDemoRecycler);
        nAdapter = new RecyclerViewAdapter(this, nEchipe);
        nList.setLayoutManager(mListLayoutManager);
        nList.setAdapter(nAdapter);
//        mSeePlayersButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(teams.this,players.class);
//                startActivity(intent);
//            }
//        });
    }

}