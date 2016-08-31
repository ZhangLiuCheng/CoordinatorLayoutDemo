package com.innotect.coordinatorlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        setupListview();
    }

    private void setupListview() {
        SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.adapter_main_item, new String[] { "title", "brief" },
                new int[] { R.id.title, R.id.brief });

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if (0 == i) {
                    intent = new Intent(MainActivity.this, ScrollingActivity.class);
                } else if (1 == i) {
                    intent = new Intent(MainActivity.this, ViewPageActivity.class);
                } else {
                    intent = new Intent(MainActivity.this, CollapsingActivity.class);
                }
                startActivity(intent);
            }
        });
    }

    private List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("title", "Scrollview");
        map.put("brief", "向上滑动的时候直接隐藏Toolbar。");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "ViewPage");
        map.put("brief", "上下滑动隐藏Toolbar,左右滑动关联TabLayout。");
        list.add(map);

        map = new HashMap<>();
        map.put("title", "CollapsingToolbarLayout");
        map.put("brief", "适合用在个人资料等地方。");
        list.add(map);
        return list;
    }
}
