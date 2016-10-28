package com.zecovery.android.mascotas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.firebase.crash.FirebaseCrash;
import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.adapter.PetCardViewAdapter;
import com.zecovery.android.mascotas.app.Mascota;
import com.zecovery.android.mascotas.com.CustomJsonRequest;
import com.zecovery.android.mascotas.com.PetDataRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RutActivity extends BaseActivity implements View.OnClickListener {

    private EditText editTextRut;
    private FloatingActionButton fab;
    private List<Mascota> list;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut);

        FirebaseCrash.log("RutActivity created");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextRut = (EditText) findViewById(R.id.editTextRut);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getResult(){
        if (editTextRut != null) {

            final String rutCompleto = editTextRut.getText().toString();

            String[] splitRut = rutCompleto.split("-");
            String rut = splitRut[0];

            CustomJsonRequest request = new CustomJsonRequest(
                    Request.Method.GET,
                    URL_REQUEST_RUT + rut,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            list = new ArrayList<>();

                            PetDataRequest dataRequest = new PetDataRequest(response);
                            list = dataRequest.getData();
                            recyclerView.setAdapter(new PetCardViewAdapter(list));

                            //log.setText(response.toString());
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(LOG_TAG, "onErrorResponse: " + error);
                            Toast.makeText(RutActivity.this, R.string.no_data, Toast.LENGTH_SHORT).show();
                        }
                    });
            request.setPriority(Request.Priority.HIGH);
            Volley.newRequestQueue(this).add(request);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
getResult();
        }
    }
}
