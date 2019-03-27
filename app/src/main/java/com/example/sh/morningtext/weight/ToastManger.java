package com.example.sh.morningtext.weight;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.morningtext.MApplication;
import com.example.sh.morningtext.R;

import org.w3c.dom.Text;

import java.net.ContentHandler;

public class ToastManger {

    public static void toast(String mes, Context context){
        Toast toast = Toast.makeText(context,mes,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
        TextView textView = toast.getView().findViewById(android.R.id.message);
        textView.setTextColor(Color.YELLOW);
        toast.show();
    }


    public static void toastIcon(String mes,int icon,Context context){
        Toast toast = Toast.makeText(context,mes,Toast.LENGTH_SHORT);

        LinearLayout layout = (LinearLayout) toast.getView();
        layout.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(icon);
        layout.addView(imageView);
        TextView textView = toast.getView().findViewById(android.R.id.message);
        textView.setTextColor(Color.YELLOW);
        toast.show();

    }

    public static void show(String mes,Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.toast_item,null);
        TextView mToastText = view.findViewById(R.id.tv_toast_mes);
        mToastText.setText(mes);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }

}
