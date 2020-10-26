package com.university.lab3.annoying_ad;

import com.university.lab3.Content;

public class Ad implements Content {
    private String title;
    private String link;

    public Ad(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public int getType() {
        return 2;
    }
}
