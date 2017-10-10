package com.gao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.Socket;

public class Main2Activity extends AppCompatActivity {
    Socket socket = null;//定义socket
    private OutputStream outputStream=null;//定义输出流

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button2=(Button) findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main2Activity.this,"你按了颜色",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        Button button1=(Button) findViewById(R.id.button7);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main2Activity.this,"你按了模式",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
        Button button=(Button) findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main2Activity.this,"你按了定时",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main2Activity.this,Main17Activity.class);
                startActivity(intent);
            }
        });
        Button button20=(Button) findViewById(R.id.button9);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        socket = ((MySocket)getApplication()).getSocket();
    }
    public void Liang_onClick(View v) {
        try
        {
//获取输出流
            outputStream = socket.getOutputStream();
//发送数据
            outputStream.write('a');
        }
        catch (Exception e)
        {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void Mie_onClick(View v) {
        try
        {
//获取输出流
            outputStream = socket.getOutputStream();
//发送数据
            outputStream.write('b');
        }
        catch (Exception e)
        {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}