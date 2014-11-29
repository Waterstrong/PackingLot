package com.tw.lot;

/**
 * Created by water on 14-11-29.
 */
public class Test {
    public static void main(String[] args) {
        PackingLot packingLot = new PackingLot(100);

        Car car = new Car("A550");
        Ticket ticket = packingLot.pack(car);
        if (ticket == null) {
            System.out.println("no lot");
        } else {
            System.out.println(ticket.getCarId());
        }
        Car myCar = packingLot.take(ticket);
        if (myCar == null) {
            System.out.println("no car");
        } else {
            System.out.println(myCar.getId());
        }

    }
}
