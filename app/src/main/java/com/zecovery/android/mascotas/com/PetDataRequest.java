package com.zecovery.android.mascotas.com;

import android.util.Log;

import com.zecovery.android.mascotas.activity.BaseActivity;
import com.zecovery.android.mascotas.app.Mascota;

import org.json.JSONObject;

/**
 * Created by francisco on 24-08-16.
 */

public class PetDataRequest extends BaseActivity {

    private JSONObject jsonObject;

    public PetDataRequest(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Mascota getData() {

        Mascota mascota = new Mascota();

        try {
            String status = jsonObject.getString(RESPONSE_STATUS);

            if (status.equals("OK")) {

                JSONObject response = jsonObject.getJSONObject("response");
                mascota.setNombrePropietario(response.getString("NOMBRE"));
                mascota.setPaciente(response.getString("PACIENTE"));


            } else {
                Log.d(LOG_TAG, "NOT FOUND - 404");
                // 404
            }
        } catch (Exception e) {
            Log.d(LOG_TAG, "getDataFromRut: " + e);
        }

        return mascota;
    }
}