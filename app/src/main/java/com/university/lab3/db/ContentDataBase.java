package com.university.lab3.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.university.lab3.dao.ContentDAO;
import com.university.lab3.model.ad.Ad;
import com.university.lab3.model.item.Item;

@Database(entities = {Item.class, Ad.class}, version = 2, exportSchema = false)
public abstract class ContentDataBase extends RoomDatabase {

    private static final String CONTENT_DB_NAME = "content_db";

    private static ContentDataBase instance;

    public abstract ContentDAO contentDAO();

    public static ContentDataBase getDB(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, ContentDataBase.class, CONTENT_DB_NAME)
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}