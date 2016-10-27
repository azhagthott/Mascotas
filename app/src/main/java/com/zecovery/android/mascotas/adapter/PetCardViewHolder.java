package com.zecovery.android.mascotas.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zecovery.android.mascotas.R;

/**
 * Created by moe on 27-10-16.
 */

public class PetCardViewHolder extends RecyclerView.ViewHolder{

    public CardView cardViewResult;
    public TextView tvNombreMascota;
    public TextView tvNombreResponsable;
    public TextView tvTelefonoFijo;
    public TextView tvTelefonoMovil;
    public TextView tvEmail;
    public TextView tvDireccion;
    public TextView tvComuna;
    public TextView tvEspecie;
    public TextView tvSexo;
    public TextView tvColor;

    public PetCardViewHolder(View view) {
        super(view);


        cardViewResult = (CardView) view;

        // datos de la mascota
        tvNombreMascota = (TextView) view.findViewById(R.id.tvNombreMascota);
        tvEspecie = (TextView) view.findViewById(R.id.tvEspecie);
        tvSexo = (TextView) view.findViewById(R.id.tvSexo);
        tvColor = (TextView) view.findViewById(R.id.tvColor);

        // datos del responsable
        tvNombreResponsable = (TextView) view.findViewById(R.id.tvNombreResponsable);
        tvTelefonoMovil = (TextView) view.findViewById(R.id.tvTelefonoMovil);
        tvTelefonoFijo = (TextView) view.findViewById(R.id.tvTelefonoFijo);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvDireccion = (TextView) view.findViewById(R.id.tvDireccion);
        tvComuna = (TextView) view.findViewById(R.id.tvComuna);

    }
}
