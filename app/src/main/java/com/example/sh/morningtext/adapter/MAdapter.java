package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sh.morningtext.R;

import java.util.List;

public class MAdapter extends BaseAdapter{
    public List<String> strs;
    public Context context;
    private ViewHolder viewHolder;

    public MAdapter(List<String> strs, Context context){
        this.strs = strs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strs.size();
    }

    @Override
    public String getItem(int position) {
        return strs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_m,null);
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_title);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(strs.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView tvTitle;
    }
}
