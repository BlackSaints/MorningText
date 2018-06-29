package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.BookBean;
import com.example.sh.morningtext.bean.FruitBean;

import java.security.PublicKey;
import java.util.List;

public class ViewTypeAdapter extends BaseAdapter {

    public List<Object> mData;
    public Context context;

    public int TYPE_BOOK = 1;
    public int TYPE_FRUIT = 2;
    public ViewTypeAdapter(List<Object> mData, Context context) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(mData.get(position) instanceof BookBean){
            return TYPE_BOOK;
        }else if(mData.get(position) instanceof FruitBean){
            return TYPE_FRUIT;
        }else {
            return super.getItemViewType(position);
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            if(getItemViewType(position) == TYPE_BOOK){
                convertView = LayoutInflater.from(context).inflate(R.layout.adapter_book,null);
                ViewHolderBook holderBook = new ViewHolderBook();
                 
            }
        }


        return null;
    }

    class ViewHolderBook{
        TextView bookName;
        TextView bookTime;
    }

}
