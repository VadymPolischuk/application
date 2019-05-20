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
    TextView tv1;
    TextView tv2;
    TextView tv3;
    String[] bb;
    String string;
    static int i = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadButton = findViewById(R.id.saveButton);
        loadButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        string = getIntent().getStringExtra("t1")+"|"+getIntent().getStringExtra("t2")+"|"+
        getIntent().getStringExtra("t3");
        i++;
        if(i==9 || i<0)
        {
            onPause();
        }
        bb[i]+=string;
        ListView Lists = findViewById(R.id.Lists);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, bb);
        Lists.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.loadButton:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
        }

    }
}
