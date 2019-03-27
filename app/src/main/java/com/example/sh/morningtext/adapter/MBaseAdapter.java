package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sh.morningtext.R;

import java.util.HashMap;
import java.util.List;

public abstract class MBaseAdapter<T> extends BaseAdapter {

    private List<T> mData;
    private int mLayoutRes;


    public MBaseAdapter(List<T> mData , int mLayoutRes){
        this.mData = mData;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.bind(position,convertView,parent,mLayoutRes);
        bindView(viewHolder,getItem(position));
        return viewHolder.getItemView();
    }

    public abstract void bindView(ViewHolder viewHolder, Object item) ;

    static class ViewHolder{

        private static View item;
        private HashMap<Integer,View> viewMap = new HashMap<>();
        private Context mContext;

        public ViewHolder(int position, View convertView, ViewGroup parent,int mLayoutRes) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(mLayoutRes,parent,false);
            convertView.setTag(this);
            item = convertView;
            mContext = parent.getContext();
        }


        public static ViewHolder bind(int position, View convertView, ViewGroup parent, int mLayoutRes) {
            if(convertView == null){
                return new ViewHolder(position,convertView,parent,mLayoutRes);
            }else{
                item = convertView;
                return (ViewHolder) convertView.getTag();
            }
        }


        public View getItemView(){
            return item;
        }

        public <T extends View> T  getView(int id){
            T t = (T) viewMap.get(id);
            if(t == null){
                t = item.findViewById(id);
                viewMap.put(id,t);
            }
            return t;
        }

        public void setText(int id,String text){
            if(getView(id) instanceof TextView){
                ((TextView) getView(id)).setText(text);
            }
        }
    }
}
