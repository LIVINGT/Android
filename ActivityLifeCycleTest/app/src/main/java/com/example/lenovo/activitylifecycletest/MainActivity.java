package com.example.lenovo.activitylifecycletest;

/**
 * 活动的生存周期
 *
 * onCreate() 活动第一次创建的时候被调用，在这里完成初始化操作（加载布局，绑定事件等）
 * onStart() 活动由不可见变为可见的时候调用
 * onResume() 在准备和用户进行交互的时候调用，位于返回栈的栈顶，并且处于运行状态
 * onPause() 在系统准备去启动或者回复另一个活动的时候调用，通常在这里释放部分cpu资源
 * onStop() 在活动完全不可见的时候调用 如果启动的新活动是对话框式的活动，那么会执行onPause（）
 * onDestroy() 这个方法在活动被销毁之前调用，之后活动将变为销毁状态
 * onRestart() 在活动由停止变为运行状态之前调用，即重新启动活动
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            String temp=savedInstanceState.getString("data_key");
            Log.d(TAG,temp);
        }

        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"OnRestart");
    }

    /**
     * 活动回收时保存数据参数
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData="Something you just typed";
        outState.putString("data_key",tempData);
    }


}
