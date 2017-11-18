package com.hedo.mytroopers.util;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hedo.mytroopers.domain.Trooper;

import java.util.ArrayList;

/**
 * Criado por hedo.junior em 16/11/2017.
 */

public class SharedPreferencesUtil {

    private SharedPreferences sharedPreferences;
    private Gson gson;


    public SharedPreferencesUtil(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.gson = new Gson();
    }

    public ArrayList<Trooper> getTroopers() {
        String troopersJson = sharedPreferences.getString(Constants.TROOPERS, "");
        ArrayList<Trooper> parsedTroopers = new ArrayList<>();

        if (!troopersJson.isEmpty()) {
            parsedTroopers = gson.fromJson(troopersJson, new TypeToken<ArrayList<Trooper>>() {
            }.getType());
        }

        return parsedTroopers;
    }

    public void updateTroopers(ArrayList<Trooper> troopers) {
        String troopersJson = gson.toJson(troopers);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Constants.TROOPERS, troopersJson);
        editor.apply();
    }

    public boolean hasSavedTroopers() {
        return !sharedPreferences.getString(Constants.TROOPERS, "").isEmpty();
    }
}
