package com.daelim;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MyService";
    MyThread myThread;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
        myThread = new MyThread();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service가 중지되었습니다.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy()");
        myThread.setFlag(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service가 시작되었습니다.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart()");
        myThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    class MyThread extends Thread {
        boolean flag = true;

        @Override
        public void run() {
            super.run();
            while (flag) {
                try {
                    Thread.sleep(4000);
                    Log.d(TAG, "thread");
                } catch (Exception e) {

                }
            }
        }

        public void setFlag(boolean k) {
            flag = k;
        }
    }
}