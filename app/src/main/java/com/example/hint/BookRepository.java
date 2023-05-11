package com.example.hint;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {
    private BookDAO dao;
    private LiveData<List<Book>> allBooks;
    private Book book;

    public BookRepository(Application application) {
        BookDatabase bookDatabase = BookDatabase.getInstance(application);
        dao = bookDatabase.bookDao();
        allBooks = dao.getAll();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }

    public void insert(final Book book) {
//        dao.insert(book);
        BookDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(book);
            }
        });
    }
}