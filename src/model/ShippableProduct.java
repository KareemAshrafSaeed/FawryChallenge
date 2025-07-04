package model;

public class ShippableProduct extends Product implements Shippable {

    private double weight;
    public ShippableProduct(String name, double price, int quantity, double weight,int shippingDays) {
        super(name, price, quantity);
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be positive");
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
