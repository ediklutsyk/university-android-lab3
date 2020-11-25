package com.university.lab3.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.university.lab3.model.ad.Ad;
import com.university.lab3.model.item.Item;

import java.util.List;

@Dao
public interface ContentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAd(Ad ad);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(Item item);

    @Query("select * from ad")
    List<Ad> getAllAdsFromBD();

    @Query("select * from item")
    List<Item> getAllItemsFromBD();
}
