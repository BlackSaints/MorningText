package com.example.sh.morningtext.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;

public class SPManger {


    private static final String SPNAME = "msp";

    /**
     * 保存数据
     */
    public static void save(Context context,String key,Object value){
        SharedPreferences sp = context.getSharedPreferences(SPNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(value instanceof String){
            editor.putString(key, (String) value);
        }else if(value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }
        editor.commit();
    }

    /**
     * 读取数据
     */
    public static Object read(Context context,String key,Object defValue){
        SharedPreferences sp = context.getSharedPreferences(SPNAME,Context.MODE_PRIVATE);
        if(defValue instanceof String){
            return sp.getString(key, (String) defValue);
        }else if(defValue instanceof Integer){
            return sp.getInt(key, (Integer) defValue);
        }else if(defValue instanceof Float){
            return sp.getFloat(key, (Float) defValue);
        }else if(defValue instanceof Long){
            return sp.getLong(key, (Long) defValue);
        }else if(defValue instanceof Boolean){
            return sp.getBoolean(key, (Boolean) defValue);
        }
        return null;
    }

    /**
     * 删除指定数据
     */
    public static void remove(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SPNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     *  检查key对应的数据是否存在
     */
    public static boolean contains(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(SPNAME,Context.MODE_PRIVATE);
        return sp.contains(key);
    }



}
