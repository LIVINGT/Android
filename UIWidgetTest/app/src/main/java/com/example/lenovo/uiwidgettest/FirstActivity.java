package com.example.lenovo.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 通过接口方式处理监听器
 */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private static int i=0;
    private EditText editText;
    private ImageView imageView;
    private String returnData;
    private TextView textView;
    private ProgressBar bar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    returnData=data.getStringExtra("content");
                    textView.setText(returnData);
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button=(Button)findViewById(R.id.Button_1);
        Button button2=(Button)findViewById(R.id.button_2);
        Button out=(Button)findViewById(R.id.out);
        Button Warn=(Button)findViewById(R.id.Warn);
        Button PDia=(Button)findViewById(R.id.Progress_dialog);
        editText=(EditText)findViewById(R.id.edit_text);
        imageView=(ImageView)findViewById(R.id.image_view);
        bar=(ProgressBar)findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        out.setOnClickListener(this);
        Warn.setOnClickListener(this);
        PDia.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Button_1:
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                if(bar.getVisibility()==View.GONE){
                    bar.setVisibility(View.VISIBLE);
                }else{
                    bar.setVisibility(View.GONE);
                }
                startActivityForResult(intent,1);

                break;
            case R.id.button_2:
                if (i==0) {
                    imageView.setImageResource(R.drawable.img_2);
                    i=1;
                }else{
                    imageView.setImageResource(R.drawable.img_1);
                    i=0;
                }
                break;
            case R.id.out:
                finish();
                break;
            case R.id.Warn:
                /**
                 * AlertDialog
                 * 弹出提示框，临驾一切页面之上
                 */
                AlertDialog.Builder dialog=new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("警告!");
                dialog.setMessage("此操作可能会对你造成损失，确定执行？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            case R.id.Progress_dialog:
                /**ProgressDialog
                 * 跟AlterDialog一样可以屏蔽掉其他控件的交互能力
                 * 一般用于表示当前操作比较耗时，请用户耐心等待
                 *
                 */
                ProgressDialog progressDialog=new ProgressDialog(FirstActivity.this);
                progressDialog.setTitle("请等待");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);//能否通过back键取消
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
