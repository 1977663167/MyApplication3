package com.gao.myapplication;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {


    boolean isConnect=true;//连接还是断开
    Button ConnectButton;//定义连接按钮
    EditText IPEditText;//定义ip输入框
    EditText PortText;//定义端口输入框
    Socket socket = null;//定义socket

    private OutputStream outputStream=null;//定义输出流
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"你按了卧室灯",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        Button button=(Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"你按了客厅灯",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main7Activity.class);
                startActivity(intent);
            }
        });
        Button button2=(Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"你按了厨房灯",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main11Activity.class);
                startActivity(intent);
            }
        });
        Button button20=(Button) findViewById(R.id.button5);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        Button button21=(Button) findViewById(R.id.button29);
        button21.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Date date=new Date();
                DateFormat format=new SimpleDateFormat("yyMMddHHmmss");
                String time=format.format(date);
                char a[]=time.toCharArray();
                try
                {
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(' ');
                    outputStream.write('h');
                    int i;
                    for (i=0;i<a.length;i++)
                    {
                        outputStream.write(a[i]);
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }

        });


        ConnectButton = (Button) findViewById(R.id.Connect_Bt);//获得连接按钮对象
        IPEditText = (EditText) findViewById(R.id.ip_ET);//获得ip文本框对象
        PortText = (EditText) findViewById(R.id.Port_ET);//获得端口文本框按钮对象


    }

    public void Connect_onClick(View v) {
        if (isConnect == true) //标志位 = true表示连接
        {
            isConnect = false;//置为false
            ConnectButton.setText("断开");//按钮上显示--断开
//启动连接线程
            Connect_Thread connect_Thread = new Connect_Thread();
            connect_Thread.start();
        } else //标志位 = false表示退出连接
        {
            isConnect = true;//置为true
            ConnectButton.setText("连接");//按钮上显示连接
            try {

                socket.close();//关闭连接
                socket = null;
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    //连接线程
    class Connect_Thread extends Thread//继承Thread
    {
        public void run()//重写run方法
        {
            try
            {
                if (socket == null)
                {
//用InetAddress方法获取ip地址
                    InetAddress ipAddress = InetAddress.getByName(IPEditText.getText().toString());
                    int port =Integer.valueOf(PortText.getText().toString());//获取端口号
                    socket = new Socket(ipAddress, port);//创建连接地址和端口-------------------这样就好多了
                    ((MySocket)getApplication()).setSocket(socket);
                }

            }
            catch (Exception e)
            {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
