package com.example.foster.parkthis;

import android.content.Intent;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;


public class LoadingActivity extends AppCompatActivity {

    public String park_names[];
    private static String globalStreet = new String();



    protected void startup() {

        //load the parks for the list
        getAllParks();

Log.d("loading", "streets loaded");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(intent);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);




        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(1);
                    startup();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
    public void getAllParks()
    {
//        try
//        {
            InputStream is = getResources().openRawResource(R.raw.plotfac);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, Charset.forName("UTF-8"))
            );

            String line = "";
            int idx3=0;
            ParkingLotSample pls = new ParkingLotSample();
            try {
                while((line  = reader.readLine())!=null) {
                      pls.setSampleId(idx3);
                    //split by comma
                    String[] tokens = line.split(",");

                    //read and set the variables with the data

                    pls.setpAssetId(Integer.parseInt(tokens[0]));
                    pls.setParkName(tokens[1]);
                    pls.setNumSpaces(Integer.parseInt(tokens[2]));

                    pls.setNumHSpaces(Integer.parseInt(tokens[3]));
                    pls.setParkLat(tokens[4]);
                    pls.setParkLong(tokens[5]);
                   // pls.setAccess(tokens[6]);


                    //LatLng parkLatLng = new LatLng(pls.getParkLat(), pls.getParkLong());

                    Ipsum.FacilitiesPLots.add(pls);
                    idx3++;
                }
                park_names = new String[idx3];

                for (int r = 0; r < park_names.length; r++){
                    park_names[r]=Ipsum.FacilitiesPLots.get(r).getParkName();

                }

                    Log.d("LoadingActivity", "Just created park_name list: ");

            } catch (IOException e) {
                Log.wtf("LoadingActivity", "Error reading data file on line " + line, e);
            }


    }


}
