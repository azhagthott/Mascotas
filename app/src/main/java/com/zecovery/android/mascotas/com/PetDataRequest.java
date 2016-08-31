package com.zecovery.android.mascotas.com;

import android.util.Log;

import com.zecovery.android.mascotas.activity.BaseActivity;
import com.zecovery.android.mascotas.pet.Pet;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by francisco on 24-08-16.
 */

public class PetDataRequest extends BaseActivity {

    private JSONObject jsonObject;

    public PetDataRequest(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Pet getData() {

        Pet pet = new Pet();

        try {
            String status = jsonObject.getString(RESPONSE_STATUS);

            if (status.equals("OK")) {
                String json = jsonObject.getString("response");
                Log.d(LOG_TAG, "getDataFromRut: " + json);
            } else {
                Log.d(LOG_TAG, "NOT FOUND - 404");
                // 404
            }
        } catch (Exception e) {
            Log.d(LOG_TAG, "getDataFromRut: " + e);
        }

        return pet;
    }
}