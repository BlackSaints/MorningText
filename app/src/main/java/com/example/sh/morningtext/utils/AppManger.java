package com.example.sh.morningtext.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

public class AppManger {

    private static AppManger manger;
    private Stack<Activity> activityStack;
    private AppManger(){

    }

    public static AppManger getInstance() {
        if(manger == null){
            manger = new AppManger();
        }
        return manger;
    }

    /**
     * 添加Activity到Stack
     */
    public void addStack(Activity activity){
        getStack().add(activity);
        for (Activity activity1 : getStack()) {
            Log.e("AppManger","add="+activity.getClass().getName());
        }

    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity getCurrentActivity(){
        return (Activity) getStack().lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity(){
        Activity activity = getStack().lastElement();
        finishActivity(activity);
        for (Activity activity1 : getStack()) {
            Log.e("AppManger","finish="+activity.getClass().getName());
        }
    }

    private void finishActivity(Activity activity) {
        if(activity != null){
            getStack().remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls){
        for (int i = 0; i < getStack().size(); i++) {
            if(getStack().get(i).equals(cls)){
                finishActivity(getStack().get(i));
            }
        }
        for (Activity activity1 : getStack()) {
            Log.e("AppManger","finish="+cls.getName());
        }
    }

    /**
     * 结束所有Activity
     */

    public void finshAllActivity(){
        for (Activity activity:getStack()) {
            if(activity != null){
                finishActivity(activity);
            }
        }
        getStack().clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context){
        finishActivity();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.restartPackage(context.getPackageName());
        System.exit(0);
    }

    private Stack<Activity> getStack() {
        if(activityStack == null){
            activityStack = new Stack<Activity>();
        }
        return activityStack;
    }


}
