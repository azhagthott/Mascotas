package com.zecovery.android.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.app.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moe on 27-10-16.
 */

public class PetCardViewAdapter extends RecyclerView.Adapter<PetCardViewHolder> {

    private List<Mascota> mascotas;

    public PetCardViewAdapter(List<Mascota> mascotas) {
        this.mascotas = new ArrayList<>();
        this.mascotas = mascotas;
    }

    @Override
    public PetCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_result, viewGroup, false);
        return new PetCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetCardViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvEspecie.setText(mascota.getEspecie());
        holder.tvSexo.setText(mascota.getSexo());
        holder.tvColor.setText(mascota.getColor());
        holder.tvNombreResponsable.setText(mascota.getNombre());
        holder.tvDireccion.setText(mascota.getDireccion());
        holder.tvComuna.setText(mascota.getComuna());
        holder.tvTelefonoFijo.setText(mascota.getTelefonoFijo());
        holder.tvTelefonoMovil.setText(mascota.getTelefonoCelular());
        holder.tvEmail.setText(mascota.getCorreoElectronico());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
