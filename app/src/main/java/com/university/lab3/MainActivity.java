package com.university.lab3;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.university.lab3.api.ApiContentService;
import com.university.lab3.db.ContentDataBase;
import com.university.lab3.model.AbstractContent;
import com.university.lab3.model.Content;
import com.university.lab3.model.ad.Ad;
import com.university.lab3.model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Content> contents = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearBtn = findViewById(R.id.clear_db_button);
        clearBtn.setOnClickListener(view -> {
            contents.clear();
            recyclerView.getAdapter().notifyDataSetChanged();
        });

        Button getFromDbBtn = findViewById(R.id.get_from_db);
        getFromDbBtn.setOnClickListener(view -> new Thread(() -> {
            List<Item> itemsFromDB = ContentDataBase.getDB(getApplicationContext()).contentDAO().getAllItemsFromBD();
            contents.addAll(itemsFromDB);
            List<Ad> adFromDB = ContentDataBase.getDB(getApplicationContext()).contentDAO().getAllAdsFromBD();
            contents.addAll(adFromDB);
            runOnUiThread(() -> recyclerView.getAdapter().notifyDataSetChanged());
        }).start());

        Button downloadFromApiBtn = findViewById(R.id.download_from_api);
        downloadFromApiBtn.setOnClickListener(view -> new Thread(this::downloadContentFromApi).start());


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContentAdapter(contents));

        downloadContentFromApi();
    }

    private void downloadContentFromApi() {

        new Thread(() -> {
            List<AbstractContent> response = ApiContentService.get().getContent(null);
            // ContentDataBase.getDB(getApplicationContext()).clearAllTables();
            for (AbstractContent abstractContent : response) {
                Content content = abstractContent.getContent();
                switch (content.getType()) {
                    case 1:
                        ContentDataBase.getDB(getApplicationContext()).contentDAO().insertItem((Item) content);
                        break;
                    case 2:
                        ContentDataBase.getDB(getApplicationContext()).contentDAO().insertAd((Ad) content);
                        break;
                }
                contents.add(abstractContent.getContent());
            }
            runOnUiThread(() -> recyclerView.getAdapter().notifyDataSetChanged());
        }).start();

//        ApiContentService.get().getContent(new Callback<List<AbstractContent>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<AbstractContent>> call, @NonNull Response<List<AbstractContent>> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        for (AbstractContent abstractContent : response.body()) {
//                            Content content = abstractContent.getContent();
//                            switch (content.getType()){
//                                case 1:
//                                    ContentDataBase.getDB(getApplicationContext()).contentDAO().insertItem((Item) content);
//                                    break;
//                                case 2:
//                                    ContentDataBase.getDB(getApplicationContext()).contentDAO().insertAd((Ad) content);
//                                    break;
//                            }
//                            contents.add(abstractContent.getContent());
//                        }
//                    }
//                    Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<AbstractContent>> call, @NonNull Throwable t) {
//                t.printStackTrace();
//            }
//        });

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