package com.example.lenovo.uiwidgettest;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 2017/11/9.
 */

public class ClickInterface extends AppCompatActivity implements View.OnClickListener {
    protected EditText editText;
    protected Intent intent;

    String data;
    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("content",data);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_2:
                startActivity(intent);
                finish();
                break;
            case R.id.button3:
                intent.putExtra("content",data);
                setResult(RESULT_OK,intent);
                Toast.makeText(v.getContext(),"评论成功",Toast.LENGTH_SHORT).show();
        }
    }
}
