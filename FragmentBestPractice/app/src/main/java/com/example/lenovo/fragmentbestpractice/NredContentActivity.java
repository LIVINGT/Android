package com.example.lenovo.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NredContentActivity extends AppCompatActivity {
    public static void actionStart(Context context, String newsTitle, String newsContent){
        Intent intent=new Intent(context,NredContentActivity.class);
        intent.putExtra("newstitle",newsTitle);
        intent.putExtra("newscontent",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String newsTitle = getIntent().getStringExtra("newstitle").toString();
        String newsContent=getIntent().getStringExtra("newscontent").toString();

        NewsContentFragment newsContentFragment =(NewsContentFragment)getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);
    }
}
