package com.zecovery.android.mascotas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.adapter.PetCardViewAdapter;
import com.zecovery.android.mascotas.pet.Pet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private View rootView;

    public PetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_pet, container, false);

        context = getActivity().getApplicationContext();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new PetCardViewAdapter(petList()));

        return rootView;
    }

    private ArrayList<Pet> petList() {

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Sauron", "Llico 959, San Miguel, Santiago", R.drawable.gato));
        pets.add(new Pet("Gandalf", "Tristan Matta 195, Santiago", R.drawable.perro));
        pets.add(new Pet("Smaug", "Centenario 100, San Miguel, Santiago", R.drawable.iguana));

        return pets;
    }
}
