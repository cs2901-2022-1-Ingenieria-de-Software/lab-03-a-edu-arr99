package lab.util;

import java.util.List;
import java.util.ArrayList;

import lab.demand.Order;

public class TestUtil {

    public static List<Order> buildOrdersPeru() {
        List<Order> ordersPeru = new ArrayList<Order>();
        ordersPeru.add(new Order("PE", 10L));
        ordersPeru.add(new Order("PE", 10L));
        return ordersPeru;
    }

    public static List<Order> buildOrdersColombia() {
        List<Order> ordersColombia = new ArrayList<Order>();
        ordersColombia.add(new Order("CO", 10L));
        ordersColombia.add(new Order("CO", 10L));
        return ordersColombia;
    }

    public static List<Order> buildOrdersBrazil() {
        List<Order> ordersBrazil = new ArrayList<Order>();
        ordersBrazil.add(new Order("BR", 10L));
        ordersBrazil.add(new Order("BR", 10L));
        return ordersBrazil;
    }
}