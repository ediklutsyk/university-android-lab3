package com.university.lab3.model.ad;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.university.lab3.R;

public class AdHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView link;

    public AdHolder(@NonNull View view) {
        super(view);
        this.title = view.findViewById(R.id.title);
        this.link = view.findViewById(R.id.link);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getLink() {
        return link;
    }
}
