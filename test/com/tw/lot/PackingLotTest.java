package com.tw.lot;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PackingLotTest {

    @Test
    public void should_get_ticket_when_packing_car_successfully() throws Exception {
        PackingLot packingLot = new PackingLot(5);
        Car car = new Car("asd");
        Ticket ticket = packingLot.pack(car);
        assertNotNull(ticket);

    }

}