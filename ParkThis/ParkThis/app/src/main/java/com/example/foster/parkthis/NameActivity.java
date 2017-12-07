package com.example.foster.parkthis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    private String[] details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        //get the name of the lot wanted
        final int pSampNum = getIntent().getIntExtra("name",-1);

        //grab the details about the lot with the name
        ParkingLotSample pls = getParkingLot(pSampNum);
        details[0] = pls.getParkName();
        details[1] = pls.getNumSpaces().toString();
        details[2] = pls.getNumHSpaces().toString();

        setContentView(R.layout.activity_name);

        TextView titleChange = (TextView) findViewById(R.id.titlePark);
        titleChange.setText(pls.getParkName().toString());

        String[] lotDetails = getResources().getStringArray(R.array.pLottypes_array);
        ListView listView = (ListView) findViewById(R.id.listView2);
        CustomAdapter custAdapter = new CustomAdapter(this,lotDetails,details);
        listView.setAdapter(custAdapter);

        Button goToMap = (Button)findViewById(R.id.vLocation);
        goToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(getApplicationContext(), MapsActivity.class);
                send.putExtra("Name", pSampNum); //might as well use the number of the park passed in
                startActivity(send);
            }
        });




    }

    public ParkingLotSample getParkingLot(int lotNum){
        if(lotNum!=-1){
        ParkingLotSample newLot = new ParkingLotSample();

            newLot = Ipsum.FacilitiesPLots.elementAt(lotNum);

            return newLot;
        }else{return null;}

    }
}
