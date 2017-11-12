package com.example.lenovo.uibestpractice;

/**
 * Created by lenovo on 2017/11/12.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;//接受的消息
    public static final int TYPE_SEND = 1;//发送的消息
    private String content;
    private int type;

    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }

    public String getContent(){
        return content;
    }

    public int getType(){
        return type;
    }
}
