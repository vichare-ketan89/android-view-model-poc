package com.example.mvvmsample.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import com.example.mvvmsample.viewmodel.IModelCallback;

import java.util.Random;

/**
 * Created by ketan on 29/12/18.
 */

public class FeatureModel {

    private IModelCallback modelCallback;

    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            modelCallback.notifyCountChange(msg.arg1);
            return false;
        }
    });

    public void registerModelCallback(IModelCallback modelCallback){
        this.modelCallback = modelCallback;
    }

    public void getCounts(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                    Random random = new Random();
                    int count = random.nextInt(10);
                    Message message = handler.obtainMessage();
                    message.arg1 = count;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendMessage(message);
                }
            }
        }).start();
    }


}
