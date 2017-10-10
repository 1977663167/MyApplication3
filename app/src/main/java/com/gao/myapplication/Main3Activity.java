package com.gao.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.OutputStream;
import java.net.Socket;

public class Main3Activity extends AppCompatActivity {
    Socket socket = null;//定义socket
    private OutputStream outputStream=null;//定义输出流

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        socket = ((MySocket)getApplication()).getSocket();
        Button button2=(Button) findViewById(R.id.button16);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(Main3Activity.this,"你按了自定义",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        Button button20=(Button) findViewById(R.id.button17);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        Button button=(Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('d');
                    outputStream.write(48);
                    outputStream.write(48);
                    outputStream.write('e');
                    outputStream.write(48);
                    outputStream.write(48);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        Button button3=(Button) findViewById(R.id.button11);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(48);
                    outputStream.write(48);
                    outputStream.write('d');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('e');
                    outputStream.write(48);
                    outputStream.write(48);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Button button7=(Button) findViewById(R.id.button12);
        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(48);
                    outputStream.write(48);
                    outputStream.write('d');
                    outputStream.write(48);
                    outputStream.write(48);
                    outputStream.write('e');
                    outputStream.write(57);
                    outputStream.write(57);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Button button4=(Button) findViewById(R.id.button13);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('d');
                    outputStream.write(48);
                    outputStream.write(48);
                    outputStream.write('e');
                    outputStream.write(57);
                    outputStream.write(57);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Button button5=(Button) findViewById(R.id.button14);
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('d');
                    outputStream.write(54);
                    outputStream.write(48);
                    outputStream.write('e');
                    outputStream.write(48);
                    outputStream.write(48);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Button button6=(Button) findViewById(R.id.button15);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('c');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('d');
                    outputStream.write(57);
                    outputStream.write(57);
                    outputStream.write('e');
                    outputStream.write(57);
                    outputStream.write(57);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
