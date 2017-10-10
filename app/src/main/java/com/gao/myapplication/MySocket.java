package com.gao.myapplication;


import android.app.Application;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/31.
 */

public class MySocket extends Application {
    Socket socket = null;
    public Socket getSocket(){
        return socket;
    }
    public void setSocket(Socket socket){
        this.socket = socket;
    }
}