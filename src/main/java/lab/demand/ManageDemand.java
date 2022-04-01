package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;
    private double defaultAdditionalColombia = 0.10;
    private double defaultAdditionalPeru = 0.20;
    private double defaultAdditionalBrazil = 0.30;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }
    public double calculateQuantities(List<Order> orders){
        // Calculate Quantities
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }

        return quantities;
    }

    public double calculateTaxes(List<Order> orders) {
        // Calculate Taxes
        double taxes = 0.0;
        for (Order order : orders) {
            double tax = this.tax.calculateTax(order.getCountry());
            taxes += tax;
        }
        return taxes * calculateQuantities(orders);
    }


    public double calculateTotalForWithAdditionalByCountry(List<Order> orders) {
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            if (order.getCountry().equals("PE")) {
                taxes += defaultAdditionalPeru;
            } else if (order.getCountry().equals("BR")) {
                taxes += defaultAdditionalBrazil;
            } else {
                taxes += defaultAdditionalColombia;
            }
        }
        return taxes * calculateQuantities(orders);
    }

}
