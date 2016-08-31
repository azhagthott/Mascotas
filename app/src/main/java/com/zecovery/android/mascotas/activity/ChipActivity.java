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

public class ChipActivity extends BaseActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private EditText editTextChip;

    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextChip = (EditText) findViewById(R.id.editTextChip);

        log =(TextView) findViewById(R.id.log);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.fab) {
            if (editTextChip != null) {
                final String chip = editTextChip.getText().toString();

                final Pet pet = new Pet();
                CustomJsonRequest request = new CustomJsonRequest(
                        Request.Method.GET,
                        URL_REQUEST + chip,
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
