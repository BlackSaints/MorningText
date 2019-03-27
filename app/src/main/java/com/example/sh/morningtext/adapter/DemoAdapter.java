package com.example.sh.morningtext.adapter;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.BookBean;

import java.util.List;

public class DemoAdapter extends MBaseAdapter<BookBean> {


    public DemoAdapter(List<BookBean> mData, int mLayoutRes) {
        super(mData, mLayoutRes);
    }

    @Override
    public void bindView(ViewHolder viewHolder, Object item) {
        BookBean bookBean = (BookBean) item;
        viewHolder.setText(R.id.tv_book_name,((BookBean) item).getBookName());
        viewHolder.setText(R.id.tv_book_time,((BookBean) item).getBookTime());
    }

}
