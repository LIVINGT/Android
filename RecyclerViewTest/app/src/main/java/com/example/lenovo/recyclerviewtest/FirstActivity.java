package com.example.lenovo.recyclerviewtest;
/**
 * 使用滚动组件RecyclerView
 * 需要在app/build.gradle的dependencies{}中添加
 * compile 'com.android.support:recyclerview-v7:24.2.1'
 */

/**
 *
 * RecyclerView中提供了LinearLayoutManager,GridLayoutManager(网格布局)
 * ,StaggeredGridLayoutManager(瀑布流布局)
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initFruits();
        //与ListView用法差不多，拿到RecyclerView实例
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        //LayoutManager用于指定RecyclerView的布局，LinearLayoutManager是线性布局的意思
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //需要变成横向滚动除了需要修改xml外还需要添加如下一行代码
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("apple",R.drawable.zhao);
            fruitList.add(apple);
        }
    }
}
