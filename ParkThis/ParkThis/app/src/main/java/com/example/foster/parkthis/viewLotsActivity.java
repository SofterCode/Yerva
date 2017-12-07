package com.example.foster.parkthis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class viewLotsActivity extends AppCompatActivity {

    private ArrayList<ParkingLotSample> pls2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lots);


        int count = Ipsum.FacilitiesPLots.size();
        for(int i=0;i<count; i++){


try {
    pls2.add(i, Ipsum.FacilitiesPLots.get(i));      //having a problem here getting the pls2 listView to populate
}catch(Exception e){e.printStackTrace();}

        }

        ListView lotsParks = (ListView) findViewById(R.id.listView);
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_list_item_1, pls2);
        lotsParks.setAdapter(ar);

        lotsParks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent send = new Intent(getApplicationContext(), LocationsActivity.class);
                send.putExtra("name", pls2.get(position).getSampleId());
                startActivity(send);
            }
        });

    }
}
