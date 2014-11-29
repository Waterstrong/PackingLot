package com.tw.lot;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by water on 14-11-29.
 */
public class ParkingBoy {
    private List<PackingLot> packingLotList = new ArrayList<PackingLot>();

    public void addPackingLot(PackingLot packingLot) {
        packingLotList.add(packingLot);
    }
    public Ticket packCar(Car car) {
        PackingLot packingLot = findFirstAvaliablePackingLot();
        if (packingLot != null) return packingLot.pack(car);
        return null;
    }
    public Car takeCar(Ticket ticket) {
        Iterator<PackingLot> iter = packingLotList.iterator();
        while (iter.hasNext()) {
            PackingLot packingLot = iter.next();
            if (packingLot.hasTicket(ticket)) {
                return packingLot.take(ticket);
            }
        }
        return null;
    }
    public PackingLot getFirstIdelPackingLot() {
        Iterator<PackingLot> iter = packingLotList.iterator();
        while (iter.hasNext()) {
            PackingLot packingLot = iter.next();
            if (packingLot.hasPosition())
                return packingLot;
        }
        return null;
    }
    /*
    public PackingLot getPackingLotByTicket(Ticket ticket) {
        Iterator<PackingLot> iter = packingLotList.iterator();
        while (iter.hasNext()) {
            PackingLot packingLot = iter.next();
            if (packingLot.hasTicket(ticket)) {}
        }
    }*/

    private PackingLot findFirstAvaliablePackingLot() {
        Iterator<PackingLot> iter = packingLotList.iterator();
        while (iter.hasNext()) {
            PackingLot packingLot = iter.next();
            if (packingLot.hasPosition()) return packingLot;
        }
        return null;
    }
}
