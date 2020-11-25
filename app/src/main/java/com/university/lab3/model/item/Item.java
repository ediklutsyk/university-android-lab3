package com.university.lab3.model.item;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import com.university.lab3.model.Content;

@Entity(tableName = "item", primaryKeys = {"title", "message", "date"})
public class Item implements Content {
    @NonNull
    private String title;
    @NonNull
    private String message;
    @NonNull
    private String date;

    public Item(@NonNull String title, @NonNull String message, @NonNull String date) {
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public @NonNull
    String getTitle() {
        return title;
    }

    public @NonNull
    String getMessage() {
        return message;
    }

    public @NonNull
    String getDate() {
        return date;
    }

    @Override
    public int getType() {
        return 1;
    }
}
