package com.university.lab3.api;

import com.university.lab3.model.AbstractContent;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiContentService {

    private static final String HOST = "https://android-test-data.s3.eu-north-1.amazonaws.com/";

    private static ApiContentService instance;

    private final ContentService contentService;

    private ApiContentService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        contentService = retrofit.create(ContentService.class);
    }

    public synchronized static ApiContentService get() {
        if (instance == null) {
            instance = new ApiContentService();
        }
        return instance;
    }

    public List<AbstractContent> getContent(Callback<List<AbstractContent>> callback) {
        if (null == callback) {
            try {
                return contentService.getContent().execute().body();
            } catch (IOException e) {
                return null;
            }
        } else {
            contentService.getContent().enqueue(callback);
            return null;
        }
    }
}