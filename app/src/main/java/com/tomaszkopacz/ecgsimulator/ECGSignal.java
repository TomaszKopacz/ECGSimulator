package com.tomaszkopacz.ecgsimulator;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ECGSignal {

    static List<Integer> getECGFromCSV(Context context) {
        List<Integer> records = new ArrayList<>();

        AssetManager am = context.getAssets();
        try {
            InputStream is = am.open("ecg_dataset.csv");

            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            for (String line; (line = r.readLine()) != null; ) {
                records.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            Log.i("SIMULATOR", "IO EXCEPTION");
        }

        return records;
    }
}
