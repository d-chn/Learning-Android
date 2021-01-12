package com.example.recyclerviewpractice_sob;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpractice_sob.adapters.ListViewAdapter;
import com.example.recyclerviewpractice_sob.beans.ItemBean;
import com.example.recyclerviewpractice_sob.utils.Datas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mList = (RecyclerView) this.findViewById(R.id.recycler_view);
        //准备数据
        /*
         *一般情况下，这里的数据是从网络中获取的
         * 这里只是模拟数据。在现实开发中，如果后台没有准备好，也是需要模拟数据的。
         * */
        initData();
    }

    /*
     * 这个方法用于模拟数据的生成
     * */
    private void initData() {
        //List<DataBean>--->setAdapter--->显示数据
        //创建数据集合
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            //创建数据对象
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第" + i + "条";
            //添加到集合里头
            mData.add(data);
        }
        //RecyclerView需要设置样式，其实就是设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mList.setLayoutManager(layoutManager);
        //创建适配器
        ListViewAdapter adapter = new ListViewAdapter(mData);
        //设置到RecyclerView里去
        mList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {

            //ListView的部分
            case R.id.list_view_vertical_standard:
                break;
            case R.id.list_view_vertical_opposite:
                break;
            case R.id.list_view_horizontal_standard:
                break;
            case R.id.list_view_horizontal_opposite:
                break;

            //GridView的部分
            case R.id.grid_view_vertical_standard:
                break;
            case R.id.grid_view_vertical_opposite:
                break;
            case R.id.grid_view_horizontal_standard:
                break;
            case R.id.grid_view_horizontal_opposite:
                break;

            //StaggerView的部分
            case R.id.stagger_view_vertical_standard:
                break;
            case R.id.stagger_view_vertical_opposite:
                break;
            case R.id.stagger_view_horizontal_standard:
                break;
            case R.id.stagger_view_horizontal_opposite:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}