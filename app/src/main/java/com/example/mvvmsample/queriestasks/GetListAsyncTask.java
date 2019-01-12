package com.example.mvvmsample.queriestasks;

import android.os.AsyncTask;

import com.example.mvvmsample.database.DetailsDAO;
import com.example.mvvmsample.database.DetailsEntity;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Created by ketan on 13/01/19.
 */

public class GetListAsyncTask extends AsyncTask<Void, Void, LiveData<List<DetailsEntity>>> {

    private DetailsDAO myDAO;

    public GetListAsyncTask(DetailsDAO myDAO){
        this.myDAO = myDAO;
    }

    @Override
    protected LiveData<List<DetailsEntity>> doInBackground(Void... voids) {
        return myDAO.getAllDetails();
    }

    @Override
    protected void onPostExecute(LiveData<List<DetailsEntity>> listLiveData) {
        super.onPostExecute(listLiveData);


    }
}
