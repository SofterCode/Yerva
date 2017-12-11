package com.example.foster.parkthis;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

public class ParkingLotInfo implements Serializable {

   public static int indexForPLots;
   //public static Vector<String> finalStreetlist = new Vector<String>();
  // public static Vector<LatLng> latLngList = new Vector<LatLng>();
   public static Vector<ParkingLotSample>FacilitiesPLots = new Vector<ParkingLotSample>();
   public static Vector<LatLng>latLngList = new Vector<LatLng>();

   private static final ParkingLotInfo pliHold = new ParkingLotInfo();
   public static ParkingLotInfo getInstance(){return pliHold;};
   public static int getParkLotIndex(){return indexForPLots;}
   public ParkingLotSample getLotInfo(int inx){return FacilitiesPLots.get(inx);}
}

