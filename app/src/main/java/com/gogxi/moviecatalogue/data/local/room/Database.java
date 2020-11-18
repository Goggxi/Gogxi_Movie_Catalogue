package com.gogxi.moviecatalogue.data.local.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.gogxi.moviecatalogue.data.local.entity.MovieEntity;
import com.gogxi.moviecatalogue.data.local.entity.TVEntity;

@androidx.room.Database(entities = {MovieEntity.class, TVEntity.class},
        version = 1,
        exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database INSTANCE;
    public abstract DatabaseDao databaseDao();
    private static final Object lock = new Object();
    public static RoomDatabase getINSTANCE(Context context) {
        synchronized (lock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        Database.class, "Database.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
