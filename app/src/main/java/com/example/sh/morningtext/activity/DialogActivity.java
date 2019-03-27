package com.example.sh.morningtext.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.CommonAdapter;
import com.example.sh.morningtext.bean.BookBean;
import com.example.sh.morningtext.weight.ToastManger;

import java.util.LinkedList;

public class DialogActivity extends MBaseActivity {

    private LinkedList mData;

    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mListView = findViewById(R.id.listview_dialog);
        initData();
        CommonAdapter adapter = new CommonAdapter(mData,R.layout.item_listview_common) {
            @Override
            public void bindView(ViewHolder viewHolder, Object item) {
                String bean = (String) item;
                viewHolder.setText(bean,R.id.tv_mes);
            }
        };
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    showDialogDfu();
                }else if(position == 1){
                    showDialogList();
                }else if(position == 2){
                    showDialogSingle();
                }else if(position == 3){
                    showDialogMore();
                }else if(position == 4){
                     showDialogCustom();
                }else if(position == 5){
                    showProgressDialog();
                }else if(position == 6){
                    showDialogHorPro();
                }
            }
        });
    }

    /**
     * 显示popuwindow
     */
    private void showPopu() {
        View view = LayoutInflater.from(this).inflate(R.layout.popu_view,null,false);
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setContentView(view);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(mListView);
    }

    /**
     * 横向带进度的progessDialog
     */
    private void showDialogHorPro() {

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("正在加载中...");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(true);
        dialog.show();
    }

    /**
     * 进度Dialog
     */
    private void showProgressDialog() {
        ProgressDialog.show(this,".","正在加载中...",false,true);
    }

    /**
     * 自定义Dialog布局
     */
    private void showDialogCustom() {
        alertDialog = null;
        builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_view,null,false);
        alertDialog = builder.setView(view).create();
        alertDialog.show();

    }

    /**
     * 多选列表对话框
     */
    private void showDialogMore() {
        final String[] menu = {"小炒肉","宫保鸡丁","辣子鸡","羊肉汤"};
        final boolean[] checkItems = {false,false,false,false};
        alertDialog = null;
        builder = new AlertDialog.Builder(this);
        alertDialog = builder.setTitle("请选择喜欢的食物")
                .setMultiChoiceItems(menu, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkItems[which] = isChecked;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder result = new StringBuilder("您选择了");

                        for (int i = 0; i < checkItems.length; i++) {
                            if(checkItems[i]){
                                result.append(menu[i]);
                                result.append("  ");
                            }
                        }
                        ToastManger.show(result.toString(),DialogActivity.this);

                    }
                }).create();

        alertDialog.show();
    }

    /**
     * 单选列表对话框
     */
    private void showDialogSingle() {
        String[] fruits = {"苹果","香蕉","葡萄","西瓜"};
        alertDialog = null;
        builder = new AlertDialog.Builder(this);
        alertDialog = builder.setTitle("请选择喜欢的水果（单选）")
                .setSingleChoiceItems(fruits,0,null)
                .create();
        alertDialog.show();

    }

    /**
     * 带列表的Dialog
     */
    private void showDialogList() {

        String[] lesson = {"语文","数学","英语","地理"};
        alertDialog = null;
        builder = new AlertDialog.Builder(this);
        alertDialog = builder.setIcon(R.drawable.ic_home_black_24dp)
                .setTitle("科目")
                .setItems(lesson,null)
                .create();
        alertDialog.show();

    }

    /**
     * 普通的Dialog
     */
    private void showDialogDfu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title")
                .setMessage("这是一个普通的dialog")
                .setPositiveButton("确定",null)
                .setNegativeButton("取消",null)
                .setNeutralButton("中间",null)
                .create();
        builder.show();
    }

    private void initData() {
        mData = new LinkedList();
        mData.add("普通Dialog");
        mData.add("普通列表对话框");
        mData.add("单选列表对话框");
        mData.add("多选列表对话框");
        mData.add("自定义布局对话框");
        mData.add("普通ProgressDialog");
        mData.add("横向进度ProgressDialog");
    }
}
