package com.example.foster.parkthis;

import android.util.Log;

import static java.lang.Double.parseDouble;

/**
 * Created by Foster on 03/12/2017.
 */

class ParkingLotSample {

    //members that match the names of the columns
    //of parking lot data
    private Integer pAssetId;
    private String parkName;
    private Integer numSpaces;
    private Integer numHSpaces;
    private Double parkLat;
    private Double parkLong;
    private String access;

    /*private void setLatLng(String parkCds) {
        String[] tokens = parkCds.split(",");
        String latString = tokens[0];
        String longStr = tokens[1];



        longStr = longStr.substring(0,17);
        //tokens[1] = tokens[1].replace(")\"", "");
        //call the setters for park lattitude and longitude
        Log.d("latStringAfterReplace", latString);

    }*/


    //getters and setters
    public Integer getpAssetId() {
        return pAssetId;
    }
    public Integer getNumSpaces() {
        return numSpaces;
    }

    public String getParkName() {
        return parkName;
    }


    public void setpAssetId(Integer pAssetId) {
        this.pAssetId = pAssetId;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public void setNumSpaces(Integer numSpaces) {

        if(numSpaces!=0){
            this.numSpaces = numSpaces;
        }
        else{this.numSpaces = 0;}

    }
    public void setNumHSpaces(Integer numHSpaces) {

        if(numHSpaces !=0) {
            this.numHSpaces = numHSpaces;
        }else{
            this.numHSpaces = 0;
        }
    }
    public void setParkLat(String latNums ){

        String latitude = latNums.substring(2, 17);
        this.parkLat = Double.parseDouble(latitude);
    }
    public void setParkLong(String longNums){
        String Longitude = longNums.substring(0,16);
        this.parkLong = Double.parseDouble(Longitude);
    }




    public Double getParkLat(){
        return parkLat;
    }

    public Integer getNumHSpaces() {
        return numHSpaces;
    }

    public Double getParkLong(){
        return parkLong;
    }
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {

        if(access!=null){this.access = access;}
        else{access = "not stated";}

    }


    @Override
    public String toString() {
        return "ParkingLotSample{" +
                "pAssetId=" + pAssetId +
                ", parkName='" + parkName + '\'' +
                ", numSpaces=" + numSpaces +
                ", numHSpaces=" + numHSpaces +
                ", parkLat=" + parkLat +
                ", parkLong=" + parkLong +
                ", access='" + access + '\'' +
                '}';
    }

}
