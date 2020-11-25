package com.university.lab3.model.ad;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import com.university.lab3.model.Content;

@Entity(tableName = "ad", primaryKeys = {"title", "link"})
public class Ad implements Content {
    @NonNull
    private String title;
    @NonNull
    private String link;

    public Ad(@NonNull String title, @NonNull String link) {
        this.title = title;
        this.link = link;
    }

    public @NonNull String getTitle() {
        return title;
    }

    public @NonNull String getLink() {
        return link;
    }

    @Override
    public int getType() {
        return 2;
    }
}
