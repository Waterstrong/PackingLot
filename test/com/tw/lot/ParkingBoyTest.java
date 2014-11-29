package com.tw.lot;

import org.junit.Before;
import org.junit.Test;

import static javafx.beans.binding.Bindings.when;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy();
    }

    @Test
    public void should_get_ticket_when_packing_car_successfully() throws Exception {
        parkingBoy.addPackingLot(new PackingLot(1));

        Ticket ticket = parkingBoy.packCar(new Car("SDFF"));

        assertNotNull(ticket);
    }

    @Test
    public void should_packing_at_first_avaliable_position_when_packing_successfully() throws Exception {
        PackingLot packingLotA = new PackingLot(1);

        parkingBoy.addPackingLot(packingLotA);
        parkingBoy.addPackingLot(new PackingLot(1));

        assertThat(parkingBoy.getFirstIdelPackingLot(), is(packingLotA));
    }

    @Test
    public void should_take_car_when_ticket_is_valid() throws Exception {
        parkingBoy.addPackingLot(new PackingLot(1));
        Car car = new Car("SDFF");
        Ticket ticket = parkingBoy.packCar(car);

        Car myCar = parkingBoy.takeCar(ticket);

        assertThat(myCar, is(car));
    }
}