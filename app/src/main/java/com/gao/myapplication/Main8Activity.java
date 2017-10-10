package com.gao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        Button button2=(Button) findViewById(R.id.button16);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main8Activity.this,"你按了自定义",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main8Activity.this,Main16Activity.class);
                startActivity(intent);
            }
        });
        Button button20=(Button) findViewById(R.id.button17);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}
