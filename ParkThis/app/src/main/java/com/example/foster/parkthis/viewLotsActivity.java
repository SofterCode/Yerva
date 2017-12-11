package com.example.foster.parkthis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class viewLotsActivity extends AppCompatActivity {

    private ArrayList<ParkingLotSample> pls2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> lotStrings = new ArrayList<String>();

        int lotIndex = ParkingLotInfo.getParkLotIndex();
        for(int i=0;i<lotIndex; i++){

        ParkingLotSample parkLots = ParkingLotInfo.getInstance().getLotInfo(i);
        lotStrings.add(i, parkLots.getParkName());

        //tried to make a data class getter to make a string of the vector, and use it
        try {

            pls2.add(i, parkLots);      //having a problem here getting the pls2 listView to populate
            }catch(Exception e){e.printStackTrace();}

        }

        setContentView(R.layout.activity_view_lots);

        ListView lotsParks = (ListView) findViewById(R.id.listView);
        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_list_item_1, lotStrings);
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
