package com.example.fragments_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnchat , btnstatus , btncalls ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnchat = findViewById(R.id.chats);
        btnstatus = findViewById(R.id.status);
        btncalls = findViewById(R.id.calls);

        //by default fragment
        loadFragment(new feed());

        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             loadFragment(new feed());
            }
        });


        btncalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             loadFragment(new calls());
            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             loadFragment(new companies());
            }
        });

    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container , fragment);
        ft.commit();
    }
}