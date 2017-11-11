package com.example.lenovo.uicustomviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    /**private String[] data={"Apple","Banana","Orange","Watermelon","Pear",
    "Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Orange",
            "Watermelon","Pear", "Grape","Pineapple","Strawberry","Cherry","Mango"};**/

    private List<Fruit> fruitsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        /***string数组并不能直接传递给ListView，需要借助适配器
        //ArrayAdapter是一个适配器
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(
                SecondActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listview=(ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);*/
        initFruits();
        FruitAdapter adapter = new FruitAdapter(SecondActivity.this,R.layout.fruit,fruitsList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //当点击滑动事件的时候会出发操作
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit =fruitsList.get(position);
                Toast.makeText(SecondActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for(int i=0;i<20;i++){
            Fruit apple=new Fruit("apple",R.drawable.back);
            fruitsList.add(apple);
            //....依次添加
        }
    }
}
