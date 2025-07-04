package model;

import java.time.LocalDate;

public class PerishableShippableProduct extends Product implements Expirable, Shippable {
    private double weight;
    private LocalDate expiryDate;

    public PerishableShippableProduct(String name, double price, int quantity, double weight, int shippingDays, LocalDate expiryDate) {
        super(name, price, quantity);
        if(weight<=0)
            throw new IllegalArgumentException("Weight must be positive");
        this.weight = weight;
        if(expiryDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Product is already expired");
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expiryDate;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
