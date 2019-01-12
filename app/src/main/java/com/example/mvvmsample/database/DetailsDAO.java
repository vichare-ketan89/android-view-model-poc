package com.example.mvvmsample.database;

import com.example.mvvmsample.util.Constants;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by ketan on 30/12/18.
 */

@Dao
public interface DetailsDAO {

    @Query(Constants.QUERY_GET_ALL)
    LiveData<List<DetailsEntity>> getAllDetails();

    @Query(Constants.QUERY_GET_BY_ID)
    LiveData<List<DetailsEntity>> getDetailsById(int[] ids);

    @Insert
    void insertDetail(DetailsEntity detailsEntity);

    @Delete
    void deleteDetail(DetailsEntity detailsEntity);
}
