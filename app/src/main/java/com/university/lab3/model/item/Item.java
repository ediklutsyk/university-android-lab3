package com.university.lab3.model.item;

import com.university.lab3.model.Content;

public class Item implements Content {
    private String title;
    private String message;
    private String date;

    public Item(String title, String message, String date) {
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int getType() {
        return 1;
    }
}
