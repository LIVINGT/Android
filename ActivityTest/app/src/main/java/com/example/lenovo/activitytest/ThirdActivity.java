package com.example.lenovo.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 在mainxml中注册时候可以在<intent-filter></intent-filter>
 * 中指定：
 * android:scheme 用于指定数据的协议部分，如http
 * android:host 用于指定数据的主机名部分，如www.baidu.com
 * android:port 用于指定数据的端口部分，一般紧随主机名之后
 * android:path 用于指定主机名和端口之后的部分，如一段网址跟在域名之后的内容
 * android:mimeType 用于指定可以处理的数据类型，允许使用通配符的方式进行指定
 */

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Button button1=(Button) findViewById(R.id.button_5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }
}
