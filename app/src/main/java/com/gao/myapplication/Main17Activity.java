package com.gao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.view.LayoutInflater;
import android.widget.EditText;
public class Main17Activity extends AppCompatActivity {
    Socket socket = null;//定义socket
    private OutputStream outputStream=null;//定义输出流
    TextView setTime1;
    TextView setTime2;
    TextView setTime3;
    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;

    String time1String = null;
    String time2String = null;
    String time3String = null;
    String defalutString = "目前无设置";

    Calendar c=Calendar.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        socket = ((MySocket)getApplication()).getSocket();
        Button button20=(Button) findViewById(R.id.button18);
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        //取得活动的Preferences对象
        SharedPreferences settings = getPreferences(Activity.MODE_PRIVATE);
        time1String = settings.getString("TIME1", defalutString);
        time2String = settings.getString("TIME2", defalutString);
        time3String = settings.getString("TIME3", defalutString);

        InitButton1();
        InitButton2();
        InitButton3();
        InitButton4();
        InitButton5();

        setTime1.setText(time1String);
        setTime3.setText(time2String);
        setTime2.setText(time3String);
    }

    public void InitButton1()
    {
        setTime1=(TextView) findViewById(R.id.setTime1);
        mButton1=(Button)findViewById(R.id.mButton1);
        mButton1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                c.setTimeInMillis(System.currentTimeMillis());
                int mHour=c.get(Calendar.HOUR_OF_DAY);
                int mMinute=c.get(Calendar.MINUTE);


                new TimePickerDialog(Main17Activity.this,
                        new TimePickerDialog.OnTimeSetListener()
                        {
                            public void onTimeSet(TimePicker view,int hourOfDay,
                                                  int minute)
                            {
                                c.setTimeInMillis(System.currentTimeMillis());
                                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                c.set(Calendar.MINUTE,minute);
                                c.set(Calendar.SECOND,0);
                                c.set(Calendar.MILLISECOND,0);

                                String tmpS=format(hourOfDay)+"："+format(minute);
                                setTime1.setText(tmpS);

                                //SharedPreferences保存数据，并提交
                                SharedPreferences time1Share = getPreferences(0);
                                SharedPreferences.Editor editor = time1Share.edit();
                                editor.putString("TIME1", tmpS);
                                editor.commit();

                                Toast.makeText(Main17Activity.this,"设置闹钟时间为"+tmpS,
                                        Toast.LENGTH_SHORT)
                                        .show();
                                char a[]=format(hourOfDay).toCharArray();
                                char b[]=format(minute).toCharArray();
                                try
                                {
//获取输出流
                                    outputStream = socket.getOutputStream();
//发送数据
                                    outputStream.write(' ');
                                    outputStream.write('f');
                                    for(int i=0;i<a.length;i++)
                                    {
                                        outputStream.write(a[i]);
                                    }
                                    for(int j=0;j<b.length;j++)
                                    {
                                        outputStream.write(b[j]);
                                    }
                                        outputStream.write('1');

                                }
                                catch (Exception e)
                                {
// TODO Auto-generated catch block
                                    e.printStackTrace();
                                }


                            }
                        },mHour,mMinute,true).show();
            }
        });
    }

    public void InitButton2()
    {
        mButton2=(Button) findViewById(R.id.mButton2);
        mButton2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write('g');
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Toast.makeText(Main17Activity.this,"闹钟时间删除",
                        Toast.LENGTH_SHORT).show();
                setTime1.setText("目前无设置");

                SharedPreferences time1Share = getPreferences(0);
                SharedPreferences.Editor editor = time1Share.edit();
                editor.putString("TIME1", "目前无设置");
                editor.commit();
            }
        });
    }

    public void InitButton3()
    {
        setTime3=(TextView) findViewById(R.id.setTime5);
        mButton3=(Button)findViewById(R.id.mButton5);
        mButton3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                c.setTimeInMillis(System.currentTimeMillis());
                int mHour=c.get(Calendar.HOUR_OF_DAY);
                int mMinute=c.get(Calendar.MINUTE);


                new TimePickerDialog(Main17Activity.this,
                        new TimePickerDialog.OnTimeSetListener()
                        {
                            public void onTimeSet(TimePicker view,int hourOfDay,
                                                  int minute)
                            {
                                c.setTimeInMillis(System.currentTimeMillis());
                                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                c.set(Calendar.MINUTE,minute);
                                c.set(Calendar.SECOND,0);
                                c.set(Calendar.MILLISECOND,0);

                                String tmpS=format(hourOfDay)+"："+format(minute);
                                setTime3.setText(tmpS);

                                //SharedPreferences保存数据，并提交
                                SharedPreferences time2Share = getPreferences(1);
                                SharedPreferences.Editor editor = time2Share.edit();
                                editor.putString("TIME2", tmpS);
                                editor.commit();

                                Toast.makeText(Main17Activity.this,"设置闹钟时间为"+tmpS,
                                        Toast.LENGTH_SHORT)
                                        .show();
                                char a[]=format(hourOfDay).toCharArray();
                                char b[]=format(minute).toCharArray();
                                try
                                {
//获取输出流
                                    outputStream = socket.getOutputStream();
//发送数据
                                    outputStream.write(' ');
                                    outputStream.write('f');
                                    for(int i=0;i<a.length;i++)
                                    {
                                        outputStream.write(a[i]);
                                    }
                                    for(int j=0;j<b.length;j++)
                                    {
                                        outputStream.write(b[j]);
                                    }
                                    outputStream.write('0');

                                }
                                catch (Exception e)
                                {
// TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                            }
                        },mHour,mMinute,true).show();
            }
        });
    }

    public void InitButton4()
    {
        mButton4=(Button) findViewById(R.id.mButton6);
        mButton4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                try
                {
//获取输出流
                    outputStream = socket.getOutputStream();
//发送数据
                    outputStream.write('g');
                }
                catch (Exception e)
                {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Toast.makeText(Main17Activity.this,"闹钟时间删除",
                        Toast.LENGTH_SHORT).show();
                setTime3.setText("目前无设置");

                //SharedPreferences保存数据，并提交
                SharedPreferences time2Share = getPreferences(1);
                SharedPreferences.Editor editor = time2Share.edit();
                editor.putString("TIME2", "目前无设置");
                editor.commit();
            }
        });
    }

    public void InitButton5()
    {
        setTime2=(TextView) findViewById(R.id.setTime2);
        LayoutInflater factory = LayoutInflater.from(this);
        final View setView = factory.inflate(R.layout.timeset,null);
        final TimePicker tPicker=(TimePicker)setView
                .findViewById(R.id.tPicker);
        tPicker.setIs24HourView(true);

        final AlertDialog di=new AlertDialog.Builder(Main17Activity.this)
                .setIcon(R.drawable.icon)
                .setTitle("设置")
                .setView(setView)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                EditText ed=(EditText)setView.findViewById(R.id.mEdit);
                                int times=Integer.parseInt(ed.getText().toString())
                                        *1000;
                                c.setTimeInMillis(System.currentTimeMillis());
                                c.set(Calendar.HOUR_OF_DAY,tPicker.getCurrentHour());
                                c.set(Calendar.MINUTE,tPicker.getCurrentMinute());
                                c.set(Calendar.SECOND,0);
                                c.set(Calendar.MILLISECOND,0);

                                String tmpS=format(tPicker.getCurrentHour())+"："+
                                        format(tPicker.getCurrentMinute());
                                String subStr = "设置闹钟时间为"+tmpS+
                                        "开始，重复间隔为"+times/1000+"秒";
                                setTime2.setText("设置闹钟时间为"+tmpS+
                                        "开始，重复间隔为"+times/1000+"秒");

                                //SharedPreferences保存数据，并提交
                                SharedPreferences time3Share = getPreferences(2);
                                SharedPreferences.Editor editor = time3Share.edit();
                                editor.putString("TIME3", subStr);
                                editor.commit();


                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                            }
                        }).create();


    }




    private String format(int x)
    {
        String s=""+x;
        if(s.length()==1) s="0"+s;
        return s;
    }
}