package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
     Button saveButton;
    EditText t1;
    EditText t2;
    EditText t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);

        switch(v.getId())
        {
            case R.id.saveButton:
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("tv1",t1.getText().toString());
                intent.putExtra("tv2",t2.getText().toString());
                intent.putExtra("tv3",t3.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
