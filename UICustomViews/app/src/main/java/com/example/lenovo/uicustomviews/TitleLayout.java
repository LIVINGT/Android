package com.example.lenovo.uicustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by lenovo on 2017/11/11.
 */

public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        //自定义控件，inflate一个对象，两个参数，一个布局文件id，一个父布局
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button button1=(Button)findViewById(R.id.back);
        Button button2=(Button)findViewById(R.id.edit);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"back is click",Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"eidt is click",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
