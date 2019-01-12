package com.example.mvvmsample.viewmodel;

import com.example.mvvmsample.model.DataModel;

/**
 * Created by ketan on 29/12/18.
 */

public interface IModelCallback {

    void notifyCountChange(DataModel dataModel);
}
