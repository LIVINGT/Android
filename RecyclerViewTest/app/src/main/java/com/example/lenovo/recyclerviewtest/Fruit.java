package com.example.lenovo.recyclerviewtest;

/**
 * Created by lenovo on 2017/11/12.
 */

public class Fruit {
    private String name;
    private int ImageId;

    public Fruit(String name,int ImageId){
        this.name=name;
        this.ImageId=ImageId;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.ImageId;
    }
}
