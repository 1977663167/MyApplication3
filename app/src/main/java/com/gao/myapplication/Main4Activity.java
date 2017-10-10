package com.gao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.OutputStream;
import java.net.Socket;

public class Main4Activity extends AppCompatActivity {
    private SeekBar seekBar;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    Socket socket = null;//定义socket
    private OutputStream outputStream=null;//定义输出流

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button button20=(Button) findViewById(R.id.button19);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
        socket = ((MySocket)getApplication()).getSocket();
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * 拖动条停止拖动的时候调用
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条开始拖动的时候调用
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条进度改变的时候调用
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                int a=(progress-1)/10;
                char ch1 = (char) (a + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write('c');
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch1);
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int b=(progress-1)%10;
                char ch2 = (char) (b + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch2);

                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });
        seekBar2=(SeekBar)findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * 拖动条停止拖动的时候调用
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条开始拖动的时候调用
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条进度改变的时候调用
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write('e');
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int a=(progress-1)/10;
                char ch1 = (char) (a + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch1);
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int b=(progress-1)%10;
                char ch2 = (char) (b + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch2);
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }
        });
        seekBar3=(SeekBar)findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * 拖动条停止拖动的时候调用
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条开始拖动的时候调用
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            /**
             * 拖动条进度改变的时候调用
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write('d');
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }

                int a=(progress-1)/10;
                char ch1 = (char) (a + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch1);
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int b=(progress-1)%10;
                char ch2 = (char) (b + 48);
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write(ch2);
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
