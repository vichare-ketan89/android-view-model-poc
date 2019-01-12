package com.example.mvvmsample.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by ketan on 30/12/18.
 */

@Entity
public class DetailsEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "firstName")
    public String firstName;

    @ColumnInfo(name = "secondName")
    public String secondName;

}
