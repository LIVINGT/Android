package com.example.lenovo.uicustomviews;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.FitWindowsFrameLayout;
import android.view.View;
import android.widget.Button;

import static android.R.attr.action;
import static android.R.attr.defaultHeight;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        /**
         * 将系统自带的标题栏隐藏掉
         */
        ActionBar actionbar=getSupportActionBar();
        if(actionbar !=null) actionbar.hide();
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);

    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
