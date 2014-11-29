package com.tw.lot;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by water on 14-11-29.
 */
public class PackingLot {
    private Map<Ticket, Car> ticketCarMap = new HashMap<Ticket, Car>();
    private int maxSpace;
    public PackingLot(int maxSpace) {
        this.maxSpace = maxSpace;
    }
    public Ticket pack(Car car) {
        Ticket ticket = new Ticket(car.getId());
        if (ticketCarMap.size() < maxSpace) {
            ticket = new Ticket(car.getId());
            ticketCarMap.put(ticket, car);
        }
        return ticket;
    }
    public Car take(Ticket ticket) {
        Car car = null;
        if (ticketCarMap.containsKey(ticket))
        {
            car = ticketCarMap.get(ticket);
            ticketCarMap.remove(ticket);
        }
        return car;
    }
    public boolean hasPosition() {
        return  ticketCarMap.size() < maxSpace ? true : false;
    }
    public boolean hasTicket(Ticket ticket) {
        return ticketCarMap.containsKey(ticket) ? true : false;
    }
}
