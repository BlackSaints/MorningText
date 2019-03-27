package com.example.sh.morningtext.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * 通用Adapter
 *
 * @author sunhao
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private LinkedList<T> mData;
    private int mLayoutRes;

    public CommonAdapter(LinkedList<T> mData, int mLayoutRes) {
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
        ViewHolder viewHolder = ViewHolder.bind(parent.getContext(), convertView, parent, mLayoutRes, position);
        bindView(viewHolder, getItem(position));
        return viewHolder.getItemView();
    }

    public abstract void bindView(ViewHolder viewHolder, T item);

    /**
     * 添加item
     *
     * @param t
     */
    public void add(T t) {
        if (mData == null) {
            mData = new LinkedList<T>();
        }
        mData.add(t);
        notifyDataSetChanged();
    }

    public void add(T t, int position) {
        if (mData == null) {
            mData = new LinkedList<T>();
        }

        mData.add(position, t);
        notifyDataSetChanged();
    }

    public void remove(T t) {
        if (mData != null) {
            mData.remove(t);
        }
        notifyDataSetChanged();
    }


    public void remove(int position) {
        if (mData != null) {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }


    public static class ViewHolder {
        private SparseArray<View> mViews;
        private static ViewHolder viewHolder;
        private static View item;

        public ViewHolder(Context context, ViewGroup parent, int mLayoutRes) {
            mViews = new SparseArray<View>();
            View convertView = LayoutInflater.from(context).inflate(mLayoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }

        public static ViewHolder bind(Context context, View convertView,
                                      ViewGroup parent, int mLayoutRes, int position) {
            if (convertView == null) {
                viewHolder = new ViewHolder(context, parent, mLayoutRes);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                item = convertView;
            }
            return viewHolder;
        }

        public View getItemView() {
            return item;
        }

        public <T extends View> T getView(int id) {
            T t = (T) mViews.get(id);
            if (t == null) {
                t = item.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }

        public ViewHolder setText(String text, int id) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }
    }
}
