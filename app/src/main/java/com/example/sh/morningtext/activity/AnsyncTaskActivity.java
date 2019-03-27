package com.example.sh.morningtext.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sh.morningtext.R;

public class AnsyncTaskActivity extends MBaseActivity {

    private static final String MTAG = "ansync";
    private TextView tv_download;
    private ProgressBar progressBar;
    private TextView proText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ansynctask);

        tv_download = (TextView) find(R.id.tv_download);
        find(R.id.btn_download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              download();
            }
        });

        initHor();

    }

    private void initHor() {
        progressBar = (ProgressBar) find(R.id.progressbar);
        final ProAnsyncTask task = new ProAnsyncTask();

        proText = (TextView) find(R.id.tv_pro);
        find(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    task.execute("100");
            }
        });

        find(R.id.btn_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
            }
        });
    }

    class ProAnsyncTask extends AsyncTask<String,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            proText.setText("开始更新...");

        }

        @Override
        protected String doInBackground(String... strings) {
            Log.e(MTAG,"参数strings="+strings[0]);
            int count = 0;
            int length = 1;
            while (count < 99){
                count += length;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(count);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            proText.setText("已经更新"+values[0]+"%");
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            proText.setText("更新完毕...");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            proText.setText("更新取消...");
        }


    }

    private void download() {
        new MAsyncTask().execute();
    }

    class MAsyncTask extends AsyncTask<Void,Integer,Void>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e(MTAG,"onPreExecute========="+Thread.currentThread().getName());
            tv_download.setText("开始下载");
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            Log.e(MTAG,"doInBackground========="+Thread.currentThread().getName());
            int i = 0;
            for (i = 0;i<=100;i+=10){
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.e(MTAG,"onProgressUpdate========="+Thread.currentThread().getName());
            tv_download.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            Log.e(MTAG,"onPostExecute========="+Thread.currentThread().getName());
        }
    }



}
