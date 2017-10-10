package com.gao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        Button button2=(Button) findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main11Activity.this,"你按了颜色",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main11Activity.this,Main12Activity.class);
                startActivity(intent);
            }
        });
        Button button1=(Button) findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main11Activity.this,"你按了模式",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main11Activity.this,Main13Activity.class);
                startActivity(intent);
            }
        });
        Button button=(Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main11Activity.this,"你按了定时",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main11Activity.this,Main14Activity.class);
                startActivity(intent);
            }
        });
        Button button20=(Button) findViewById(R.id.button9);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}
