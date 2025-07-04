package model;

import java.time.LocalDate;

public class PerishableProduct extends Product implements Expirable  {
    private LocalDate expiryDate;
    public PerishableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        if(expiryDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Product is already expired");
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expiryDate;
    }
}
