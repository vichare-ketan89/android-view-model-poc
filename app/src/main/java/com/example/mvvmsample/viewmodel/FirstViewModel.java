package com.example.mvvmsample.viewmodel;

import android.app.Application;


import com.example.mvvmsample.model.DataModel;
import com.example.mvvmsample.model.FeatureModel;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by ketan on 29/12/18.
 */

public class FirstViewModel extends AndroidViewModel implements IModelCallback{

    private MutableLiveData<DataModel> mutableLiveDataModel = new MutableLiveData<>();
    private FeatureModel featureModel = new FeatureModel();

    public FirstViewModel(Application application){
        super(application);
    }

    @Override
    public void notifyCountChange(int count) {
        DataModel dataModel = new DataModel();
        dataModel.setArg1(count);
        mutableLiveDataModel.setValue(dataModel);
    }

    public MutableLiveData<DataModel> getMutableLiveDataModel() {
        return mutableLiveDataModel;
    }

    public FeatureModel getFeatureModel() {
        return featureModel;
    }
}
