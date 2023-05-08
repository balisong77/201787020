package com.example.hint;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDAO {
    @Query("SELECT * FROM Book")
    LiveData<List<Book>> getAll();

    @Query("SELECT * FROM Book WHERE name = :BookName LIMIT 1")
    Book findByName(int BookName);
    @Query("DELETE FROM Book")
    void deleteAll();
    @Insert
    void insert(Book book);
    @Delete
    void delete(Book book);
    @Update
    void updateBook(Book book);
}

