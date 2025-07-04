package model;

import java.time.LocalDate;

public class CartItem implements Shippable{
    private Product product;
    private int quantity;
    private double totalPrice;
    public CartItem(Product product, int quantity) {
        this.product = product;
        if(product instanceof PerishableProduct perishable)
        {
            if(perishable.isExpired(LocalDate.now())) {
                throw new IllegalArgumentException("Product is expired");
            }
        }
        if(product instanceof PerishableShippableProduct perishableShippable)
        {
            if(perishableShippable.isExpired(LocalDate.now())) {
                throw new IllegalArgumentException("Product will be expired");
            }
        }

        if(quantity<=0)
            throw new IllegalArgumentException("Quantity must be positive");
        if(product.getQuantity()<quantity)
            throw new IllegalArgumentException("There is no enough quantity");
        this.quantity = quantity;
        product.decreaseQuantity(this.quantity);
    }

    public void increaseQuantity() {
        if(quantity+1 <= product.getQuantity()) {
            product.decreaseQuantity(1);
            quantity+=1;
        }
        else {
            throw new IllegalArgumentException("There is no enough quantity");
        }
    }

    public void decreaseQuantity() {
        if (quantity - 1 >= 0) {
            product.increaseQuantity(1);
            quantity -= 1;
        } else {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
    }

    public Product getProduct() {
        return product;
    }
    public double getTotalPrice() {
        return quantity * product.getPrice();
    }

    @Override
    public double getWeight() {
        if(product instanceof Shippable shippable)
            return shippable.getWeight() * quantity;
        return 0;
    }
    @Override
    public String getName() {
        return  product.getName();
    }

    public int getQuantity() {
        return quantity;
    }
}
