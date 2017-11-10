package com.example.lenovo.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        /**
         * back键返回时传递数据方式
         */
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity!");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        /**
         * 接受上一个活动传来的数据
         */
        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("hello ",data);
        Button back=(Button)findViewById(R.id.second_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 点击按钮返回信息给上一个活动
                 */
                //String data="Hello Firstactivity";
                Intent intent=new Intent();
                intent.putExtra("data_return","Hello Firstactivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        Button button=(Button) findViewById(R.id.button_1);
        /**
         * 显示传递
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
        /**
         * 隐式调用
         */
        Button button2=(Button)findViewById(R.id.button_6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.lenovo.activitytest.ACTION_START2");
                startActivity(intent);
            }
        });
    }

    /**
     * 接收上一个活动传来的信息并打印
     */
    /**private void getData(){
        Intent intent =getIntent();
        String data=intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
    }*/
}
