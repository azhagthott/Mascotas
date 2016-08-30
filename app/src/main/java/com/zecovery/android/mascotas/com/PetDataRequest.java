package com.zecovery.android.mascotas.com;

import android.util.Log;

import com.zecovery.android.mascotas.activity.BaseActivity;
import com.zecovery.android.mascotas.pet.Pet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francisco on 24-08-16.
 */

public class PetDataRequest extends BaseActivity {

    private JSONObject jsonObject;
    private JSONArray response;
    private Pet pet;

    public PetDataRequest(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Pet getDataFromRut() {

        Pet pet = new Pet();

        try {
            String status = jsonObject.getString(RESPONSE_STATUS);
            if (status.equals("OK")) {
                String r = jsonObject.getString("response");
                Log.d(LOG_TAG, "getDataFromRut: " + r);
            } else {
                Log.d(LOG_TAG, "NOT FOUND - 404");
                // 404
            }
        } catch (Exception e) {
            Log.d(LOG_TAG, "getDataFromRut: " + e);
        }

        return pet;
    }

    public Pet getDataFromChip(int chipId) {
        Pet pet = new Pet();
        return pet;
    }

    public List<Pet> getDataFromAddress(String address) {
        List<Pet> list = new ArrayList<>();
        return list;
    }

}