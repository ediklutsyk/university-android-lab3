package com.university.lab3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.university.lab3.annoying_ad.Ad;
import com.university.lab3.item.Item;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContentAdapter(initItems()));
    }

    private List<Content> initItems() {
        return Arrays.asList(
                new Item("Title1", "Message1", "01.10"),
                new Item("Title2", "Message2", "02.10"),
                new Ad("Ad1", "http://annoying1.ad.com"),
                new Item("Title3", "Message3", "03.10"),
                new Item("Title4", "Message4", "04.10"),
                new Ad("Ad2", "http://annoying2.ad.com"),
                new Item("Title5", "Message5", "05.10"),
                new Item("Title6", "Message6", "06.10"),
                new Ad("Ad3", "http://annoying3.ad.com"),
                new Item("Title7", "Message7", "07.10"),
                new Item("Title8", "Message8", "08.10")
        );
    }
}