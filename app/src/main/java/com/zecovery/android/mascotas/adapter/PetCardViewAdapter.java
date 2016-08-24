package com.zecovery.android.mascotas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.pet.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fran on 24-08-16.
 */

public class PetCardViewAdapter extends RecyclerView.Adapter<PetCardViewHolder> {

    private List<Pet> pets;

    public PetCardViewAdapter(List<Pet> areas) {
        this.pets = new ArrayList<>();
        this.pets.addAll(areas);
    }

    @Override
    public PetCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view, viewGroup, false);
        return new PetCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PetCardViewHolder holder, int i) {

        Context context = holder.imageViewPet.getContext();

        Pet pet = pets.get(i);

        holder.textViewName.setText(pet.getName());
        holder.textViewAddress.setText(pet.getAddress());
        Picasso.with(context).load(pet.getPhoto()).into(holder.imageViewPet);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

}
