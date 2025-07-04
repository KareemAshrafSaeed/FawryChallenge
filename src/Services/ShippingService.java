package Services;

import model.Shippable;

import java.util.Vector;

public class ShippingService {
    private double shippingPrice;
    public ShippingService(double shippingPrice) {
        if (shippingPrice < 0)
            throw new IllegalArgumentException("Shipping price can't be negative");
        this.shippingPrice = shippingPrice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(double shippingPrice) {
        if(shippingPrice<0)
            throw new IllegalArgumentException("Shipping price can't be negative");
        this.shippingPrice = shippingPrice;
    }

    public void shipItems(Vector<Shippable> shippables) {
        if(shippables.isEmpty())
            return;
        System.out.print("** Shipment notice ** \n");
        double totalWeight = 0;
        for(Shippable item: shippables) {
            totalWeight+=item.getWeight();
            System.out.print(item.getName() + "\t" + item.getWeight() + "g\n");
        }
        System.out.print("Total package weight " + totalWeight/1000 + "Kg\n");
        System.out.println();
    }
}
