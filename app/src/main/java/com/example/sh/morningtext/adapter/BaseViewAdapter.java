package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sh.morningtext.R;

public abstract class BaseViewAdapter<T> extends BaseAdapter{

    String[] mData;
    int mLayoutRes;
    public BaseViewAdapter(String[] mData, int mLayoutRes){
        this.mData = mData;
        this.mLayoutRes = mLayoutRes;
    }
    
    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder = BaseViewHolder.bind(position,convertView,parent,mLayoutRes);
        bindView(viewHolder,getItem(position));
        return viewHolder.getItemView();
    }

    public abstract void bindView(BaseViewHolder viewHolder, Object item) ;

    public static class  BaseViewHolder{

        public static View item;
        public BaseViewHolder(int position, View convertView, ViewGroup parent, int mLayoutRes) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(mLayoutRes,parent,false);
            convertView.setTag(this);
            item = convertView;
        }

        public static BaseViewHolder bind(int position, View convertView, ViewGroup parent, int mLayoutRes) {

            BaseViewHolder viewHolder = null;
            if(convertView == null){
                viewHolder = new BaseViewHolder(position,convertView,parent,mLayoutRes);
            }else {
                viewHolder = (BaseViewHolder) convertView.getTag();
                item = convertView;
            }
            return viewHolder;
        }

        public View getItemView(){
            return item;
        }

        public View getView(int id){
            View view = item.findViewById(id);
            return view;
        }


    }
}
