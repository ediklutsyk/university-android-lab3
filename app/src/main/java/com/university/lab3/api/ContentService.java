package com.university.lab3.api;

import com.university.lab3.model.AbstractContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContentService {

    @GET("data.json")
    Call<List<AbstractContent>> getContent();
}
