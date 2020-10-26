package com.university.lab3.item;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.university.lab3.R;

public class ItemHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView message;
    private final TextView date;

    public ItemHolder(@NonNull View view) {
        super(view);
        this.title = view.findViewById(R.id.title);
        this.message = view.findViewById(R.id.message);
        this.date = view.findViewById(R.id.date);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getMessage() {
        return message;
    }

    public TextView getDate() {
        return date;
    }
}
