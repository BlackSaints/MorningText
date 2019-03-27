package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.CommonAdapter;
import com.example.sh.morningtext.adapter.DemoAdapter;
import com.example.sh.morningtext.adapter.MAdapter;
import com.example.sh.morningtext.adapter.ViewTypeAdapter;
import com.example.sh.morningtext.bean.BookBean;
import com.example.sh.morningtext.bean.FruitBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity{

    private ListView mListview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListview = findViewById(R.id.listview);
//        List<String> strs = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            strs.add("长江"+i+"号");
//        }
//
//        MAdapter adapter = new MAdapter(strs,this);
//        TextView headView = new TextView(this);
//        headView.setText("表头");
//        mListview.addHeaderView(headView);
//        mListview.setAdapter(adapter);
//
//        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(ListViewActivity.this, "长江"+position+"号", Toast.LENGTH_SHORT).show();
//            }
//        });
//         listview不同view布局
//        List<Object> data = new ArrayList<>();
//        BookBean b1 = new BookBean("红楼梦","1990-01-01");
//        FruitBean f1 = new FruitBean("香蕉","广西");
//        data.add(b1);
//        data.add(f1);
//
//        BookBean b2 = new BookBean("吞噬星空","2018-01-01");
//        FruitBean f2 = new FruitBean("苹果","烟台");
//        data.add(b2);
//        data.add(f2);
//
//        ViewTypeAdapter adapter = new ViewTypeAdapter(data,this);
//        mListview.setAdapter(adapter);
         //自定义通用adapter
//        LinkedList<BookBean> bookBeans = new LinkedList<>();
//        BookBean b1 = new BookBean("天龙八部","201818");
//        BookBean b2 = new BookBean("天龙八部1","201819");
//        bookBeans.add(b1);
//        bookBeans.add(b2);
//        CommonAdapter<BookBean> adapterBook = new CommonAdapter<BookBean>(bookBeans,R.layout.adapter_book) {
//            @Override
//            public void bindView(CommonAdapter.ViewHolder viewHolder, BookBean item) {
//                viewHolder.setText(item.getBookName(),R.id.tv_book_name);
//                viewHolder.setText(item.getBookTime(),R.id.tv_book_time);
//            }
//        };
//
//        mListview.setAdapter(adapterBook);
        List<BookBean> beans = new ArrayList<>();
        BookBean b1 = new BookBean("水浒传","201201");
        beans.add(b1);
        DemoAdapter adapter = new DemoAdapter(beans,R.layout.adapter_book);
        mListview.setAdapter(adapter);

    }


}
