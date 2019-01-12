package com.example.mvvmsample.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by ketan on 30/12/18.
 */

@Database(entities = {DetailsEntity.class}, version = 1)
public abstract class DetailsDatabase extends RoomDatabase{

    public abstract DetailsDAO getDetailsDAO();


    private static DetailsDatabase detailsDatabaseInstance;

    public static DetailsDatabase getInstance(Context context){
        if( detailsDatabaseInstance == null){
            synchronized(new Object()){
                if(detailsDatabaseInstance != null){
                    detailsDatabaseInstance = Room
                            .databaseBuilder(context.getApplicationContext(),
                                    DetailsDatabase.class,
                                    "details.db")
                            .build();
                }
            }
        }

        return detailsDatabaseInstance;
    }
}
