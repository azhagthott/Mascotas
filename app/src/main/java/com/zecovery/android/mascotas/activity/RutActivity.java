package com.zecovery.android.mascotas.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zecovery.android.mascotas.R;
import com.zecovery.android.mascotas.com.CustomJsonRequest;
import com.zecovery.android.mascotas.com.PetDataRequest;
import com.zecovery.android.mascotas.pet.Pet;

import org.json.JSONObject;

public class RutActivity extends BaseActivity implements View.OnClickListener {

    private EditText editTextRut;
    private FloatingActionButton fab;
    private TextView log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextRut = (EditText) findViewById(R.id.editTextRut);

        log = (TextView) findViewById(R.id.log);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //exitActivityTransition.exit(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.fab) {
            if (editTextRut != null) {
                final String rut = editTextRut.getText().toString();
                Log.d(LOG_TAG, "onResume: " + rut);

                final Pet pet = new Pet();

                CustomJsonRequest request = new CustomJsonRequest(
                        Request.Method.GET,
                        URL_REQUEST + rut,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                PetDataRequest dataRequest = new PetDataRequest(response);
                                dataRequest.getData();

                                log.setText(response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(LOG_TAG, "onErrorResponse: " + error);
                                log.setText(error.toString());
                            }
                        });
                request.setPriority(Request.Priority.HIGH);
                Volley.newRequestQueue(this).add(request);
            }
        }
    }
}
