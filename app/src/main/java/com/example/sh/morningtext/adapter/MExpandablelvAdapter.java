package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.GroupBean;
import com.example.sh.morningtext.bean.ItemBean;

import java.util.List;

public class MExpandablelvAdapter extends BaseExpandableListAdapter {

    List<GroupBean> groupBeans;
    List<List<ItemBean>> itemBeans;
    Context context;
    public MExpandablelvAdapter(List<GroupBean> groupBeans, List<List<ItemBean>> itemBeans, Context context){
        this.context = context;
        this.groupBeans = groupBeans;
        this.itemBeans = itemBeans;
    }

    @Override
    public int getGroupCount() {
        return groupBeans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return itemBeans.size();
    }

    @Override
    public GroupBean getGroup(int groupPosition) {
        return groupBeans.get(groupPosition);
    }

    @Override
    public ItemBean getChild(int groupPosition, int childPosition) {
        return itemBeans.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        GroupViewHolder groupViewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_group,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.mGroupTitle = convertView.findViewById(R.id.tv_group);
            convertView.setTag(groupViewHolder);
        }else{
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.mGroupTitle.setText(groupBeans.get(groupPosition).getGroupName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ItemViewHolder itemViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_item,parent,false);
            itemViewHolder = new ItemViewHolder();
            itemViewHolder.mItemIcon = convertView.findViewById(R.id.item_icon);
            itemViewHolder.mItemText = convertView.findViewById(R.id.item_text);
            convertView.setTag(itemViewHolder);
        }else{
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }

        itemViewHolder.mItemIcon.setImageResource(itemBeans.get(groupPosition).get(childPosition).getIcon());
        itemViewHolder.mItemText.setText(itemBeans.get(groupPosition).get(childPosition).getItemName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    class GroupViewHolder{

        public TextView mGroupTitle;
    }

    class ItemViewHolder{

        public ImageView mItemIcon;
        public TextView mItemText;
    }
}
