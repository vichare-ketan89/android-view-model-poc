package com.example.mvvmsample.database;

import android.app.Application;

import com.example.mvvmsample.queriestasks.InsertAsyncTask;

import java.util.List;

/**
 * Created by ketan on 13/01/19.
 */

public class MyRepository {

    private DetailsDatabase myDatabase;
    private DetailsDAO myDAO;
    private List<DetailsEntity> myEntities;

    public MyRepository(Application application){
        myDatabase = DetailsDatabase.getInstance(application);
        myDAO = myDatabase.getDetailsDAO();
    }

    public List<DetailsEntity> getList(){
        return myEntities;
    }

    public void insertEntity(DetailsEntity myEntity){
        new InsertAsyncTask(myDAO).execute(myEntity);//new MyEntity("Ketan", "Vichare")
    }
}
