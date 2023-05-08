package com.example.hint;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Book.class}, version = 1, exportSchema =false)
public abstract class BookDatabase extends RoomDatabase {
    private static BookDatabase INSTANCE;

    public abstract BookDAO bookDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static synchronized BookDatabase getInstance(final Context context) {if (INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        BookDatabase.class, "BookDatabase").allowMainThreadQueries()
                .build();
    }
        return INSTANCE;
    }

    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
}
