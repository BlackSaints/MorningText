package com.example.sh.morningtext.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.weight.ToastManger;

public class SqliteActivity extends MBaseActivity {

    private MSQLiteOpenHelper helper;
    private String table = "person";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        helper = new MSQLiteOpenHelper(SqliteActivity.this, "new.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
    }

    public void alert(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values1 = new ContentValues();
        values1.put("name", "zhangsan");
        db.insert(table, null, values1);
        ToastManger.show("alert完成", SqliteActivity.this);
    }

    public void update(View view){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name","lisi");
        db.update(table,values,null,null);

    }
    public void query(View view){
        StringBuilder builder = new StringBuilder();
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(table,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            builder.append(name);
        }
        cursor.close();
        ToastManger.show(builder.toString(),SqliteActivity.this);
    }


    private class MSQLiteOpenHelper extends SQLiteOpenHelper {

        public MSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE person(personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

//        public MSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
//                                 int version) {
//            super(context, "my.db", null, 1);
//        }
//
//        @Override
//        //数据库第一次创建时被调用
//        public void onCreate(SQLiteDatabase db) {
//            db.execSQL("CREATE TABLE person(personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20))");
//
//        }
//
//        //软件版本号发生改变时调用
//        @Override
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
////            db.execSQL("ALTER TABLE person ADD phone VARCHAR(12) NULL");
//        }
    }
}
