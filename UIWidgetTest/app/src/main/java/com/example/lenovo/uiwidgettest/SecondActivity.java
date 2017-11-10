package com.example.lenovo.uiwidgettest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * 以类来管理按钮逻辑
 */
public class SecondActivity extends ClickInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        intent=new Intent(SecondActivity.this,FirstActivity.class);
        editText=(EditText)findViewById(R.id.edit_text);
        data=editText.getText().toString();
        Button button=(Button)findViewById(R.id.button_2);
        button.setOnClickListener(this);
        Button button2=(Button)findViewById(R.id.button3);
        button2.setOnClickListener(this);
    }
}
