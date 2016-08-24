package com.zecovery.android.mascotas.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zecovery.android.mascotas.R;

import static com.zecovery.android.mascotas.activity.BaseActivity.LOG_TAG;

/**
 * Created by fran on 24-08-16.
 */

public class PetCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textViewName;
    public TextView textViewAddress;
    public ImageView imageViewPet;
    public CardView cardViewPet;
    public Context context;

    public PetCardViewHolder(View view) {
        super(view);

        cardViewPet = (CardView) view;
        textViewName = (TextView) view.findViewById(R.id.textViewName);
        textViewAddress = (TextView) view.findViewById(R.id.textViewAddress);
        imageViewPet = (ImageView) view.findViewById(R.id.imageViewPet);
        context = view.getContext();
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Log.d(LOG_TAG, "onClick");

    }
}
