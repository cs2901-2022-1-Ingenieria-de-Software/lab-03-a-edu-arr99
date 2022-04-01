package lab;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lab.demand.ManageDemand;
import lab.demand.Tax;
import lab.util.TestUtil;
import lab.demand.Order;

import java.util.Collections;
import java.util.List;

@Test
public class ManageDemandTest {

    private Tax tax;

    private ManageDemand demand;

    @BeforeClass
    public void setup() {
        tax = new Tax();
        demand =  new ManageDemand(tax);
    }
    
    public void test_AllOrdersFromPeru() {
        List<Order> ordersFromPeru = TestUtil.buildOrdersPeru();
        double result = demand.calculateTaxes(ordersFromPeru);
        Assert.assertEquals(Math.round(result), 7.0);
    }

    // Add Tests !!
    public void test_AllOrdersFromColombia() {
        List<Order> ordersFromColombia = TestUtil.buildOrdersColombia();
        double result = demand.calculateTaxes(ordersFromColombia);
        Assert.assertEquals(Math.round(result), 0.0);
    }

    public void test_AllOrdersFromBrazil() {
        List<Order> ordersFromBrazil = TestUtil.buildOrdersBrazil();
        double result = demand.calculateTaxes(ordersFromBrazil);
        Assert.assertEquals(Math.round(result), 5.0);
    }

    public void test_emptyList() {
        List<Order> emptyOrders = Collections.<Order>emptyList();
        double result = demand.calculateTaxes(emptyOrders);
        Assert.assertEquals(Math.round(result), 0.0);
    }
}
