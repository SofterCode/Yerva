package com.example.foster.parkthis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

import java.util.List;
import java.util.Vector;

public class Ipsum implements Serializable {

   public static Vector<String> excelStreetlist = new Vector<String>();
   public static Vector<String> finalStreetlist = new Vector<String>();
  // public static Vector<LatLng> latLngList = new Vector<LatLng>();
   public static Vector<ParkingLotSample>FacilitiesPLots = new Vector<ParkingLotSample>();
   public static Vector<LatLng>latLngList = new Vector<LatLng>();
}
