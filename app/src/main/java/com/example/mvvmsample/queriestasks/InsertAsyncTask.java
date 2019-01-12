package com.example.mvvmsample.queriestasks;

import android.os.AsyncTask;

import com.example.mvvmsample.database.DetailsDAO;
import com.example.mvvmsample.database.DetailsEntity;

/**
 * Created by ketan on 13/01/19.
 */

public class InsertAsyncTask extends AsyncTask<DetailsEntity, Void, Void> {

    private DetailsDAO myDAO;

    public InsertAsyncTask(DetailsDAO myDAO){
        this.myDAO = myDAO;
    }

    @Override
    protected Void doInBackground(DetailsEntity... myEntities) {
        myDAO.insertDetail(myEntities[0]);
        return null;
    }
}
