package com.example.mvvmsample.model;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;


import com.example.mvvmsample.database.DetailsDAO;
import com.example.mvvmsample.database.DetailsDatabase;
import com.example.mvvmsample.database.DetailsEntity;
import com.example.mvvmsample.viewmodel.IModelCallback;

import java.util.List;
import java.util.Random;

/**
 * Created by ketan on 29/12/18.
 */

public class FeatureModel {

    private IModelCallback modelCallback;
    private DetailsDAO detailsDAO;

    public FeatureModel(Application application){
        DetailsDatabase detailsDatabase = DetailsDatabase.getInstance(application);
//        detailsDAO = detailsDatabase.detailsDAO();
    }

    private Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            DataModel dataModel = new DataModel();
            dataModel.setArg1(msg.arg1);
            modelCallback.notifyCountChange(dataModel);
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

    public void getDetails(int[] id){
        List<DetailsEntity> detailsEntityList = detailsDAO.getDetailsById(id);
        DataModel dataModel = new DataModel();
        dataModel.setDetailsEntityList(detailsEntityList);
        modelCallback.notifyCountChange(dataModel);
    }


}
