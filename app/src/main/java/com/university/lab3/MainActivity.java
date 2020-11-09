package com.university.lab3;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.university.lab3.api.ApiContentService;
import com.university.lab3.model.Content;
import com.university.lab3.model.AbstractContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Content> contents = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContentAdapter(contents));

        initItems();
    }

    private void initItems() {

        ApiContentService.get().getContent(new Callback<List<AbstractContent>>() {
            @Override
            public void onResponse(@NonNull Call<List<AbstractContent>> call, @NonNull Response<List<AbstractContent>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        for (AbstractContent abstractContent : response.body()) {
                            contents.add(abstractContent.getContent());
                        }
                    }
                    Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<AbstractContent>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

//        return Arrays.asList(
//                new Item("Title1", "Message1", "01.10"),
//                new Item("Title2", "Message2", "02.10"),
//                new Ad("Ad1", "http://annoying1.ad.com"),
//                new Item("Title3", "Message3", "03.10"),
//                new Item("Title4", "Message4", "04.10"),
//                new Ad("Ad2", "http://annoying2.ad.com"),
//                new Item("Title5", "Message5", "05.10"),
//                new Item("Title6", "Message6", "06.10"),
//                new Ad("Ad3", "http://annoying3.ad.com"),
//                new Item("Title7", "Message7", "07.10"),
//                new Item("Title8", "Message8", "08.10")
//        );
    }
}