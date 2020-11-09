package com.university.lab3.model;

import com.university.lab3.model.ad.Ad;
import com.university.lab3.model.item.Item;

public class AbstractContent {
    private String title;
    private int type;
    private String link;
    private String message;
    private String date;

    public Content getContent() {
        switch (this.type) {
            case 1:
                return new Item(this.title, this.message, this.date);
            case 2:
                return new Ad(this.title, this.link);
        }
        return null;
    }
}
