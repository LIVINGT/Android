package com.example.lenovo.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ServiceConfigurationError;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 接受返回值
         */
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("Firstactivity",returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * 此处给当前活动创建菜单
         */
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * 定义菜单相应事件
         */
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"添加按钮被点击！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"删除按钮被点击!",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById( R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "你点击了这个按钮!", Toast.LENGTH_SHORT).show();
                /**
                 * 调用系统浏览器
                 * setData()接收一个uri对象
                 */
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.button_2);
        /**
         * 通过按键销毁活动
         */
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button3=(Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 显示intent进行两个活动的信息传递
                 */
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                /**
                 * intent两个参数，第一个是上文，第二个是活动，即在FirstActivity这个活动
                 * 的基础上打开SecondActivity这个活动
                 */
                startActivity(intent);
            }
        });
        /**
         * 隐式传递活动信息，需配置
         * <activity android:name=".SecondActivity">
         <intent-filter>
         <action android:name="com.example.lenovo.activitytest.ACTION_START"/>
         <category android:name="android.intent.category.DEFAULT"/>
         </intent-filter>
         </activity>

         */
        Button button4=(Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent("com.example.lenovo.activitytest.ACTION_START");
                /**
                 * 添加我的category,需要在secondactivity中配置这个category，否则报错
                 * <activity android:name=".SecondActivity">
                 <intent-filter>
                 <action android:name="com.example.lenovo.activitytest.ACTION_START"/>
                 <category android:name="android.intent.category.DEFAULT"/>
                 <category android:name="com.example.lenovo.activitytest.MY_CATEGORY"/>
                 </intent-filter>
                 </activity>
                 */
                intent.addCategory("com.example.lenovo.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });
        Button button_inf=(Button)findViewById(R.id.first_inference);
        button_inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 将data数据传递给sencondActivity
                 */
                String data="Hello secondActivity!";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });

        Button button_back=(Button)findViewById(R.id.first_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
                /**
                 * startActivityForResult（）两个参数，第一个intent对象，第二个请求码（唯一值）
                 */
                startActivityForResult(intent,1);
            }
        });

    }
}
