package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     Button loadButton;
     String[] bb = new String[10];
     static String string;
    static int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton = this.<Button>findViewById(R.id.loadButton);
        loadButton.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().getStringExtra("t3") == null)
        {
            return;
        }

        else {
            string = getIntent().getStringExtra("tv1") + "|" + getIntent().getStringExtra("tv2") + "|" +
                    getIntent().getStringExtra("tv3");
            i = i + 1;
            if (i == 9 || i < 0) {
                i = 0;
                onPause();
            }
            bb[i] += string;
            ListView Lists = findViewById(R.id.Lists);
            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, bb);
            Lists.setAdapter(adapter);
        }


    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.loadButton:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
                default:
                    break;

        }

    }
}
