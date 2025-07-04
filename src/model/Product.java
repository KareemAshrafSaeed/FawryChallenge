package model;

public class Product {
    private int quantity;
    private String name;
    private double price;
    public Product(String name, double price, int quantity) {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name can't be empty");
        this.name = name;
        if(price <= 0)
            throw new IllegalArgumentException("Price must be positive");
        this.price = price;
        if(quantity < 0)
            throw new IllegalArgumentException("Quantity can't be negative");
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void decreaseQuantity(int quantity) {
        this.quantity-= quantity;
    }
    public void increaseQuantity(int quantity) {
        this.quantity+= quantity;
    }
    public boolean isQuantityAvailable(int quantity) {
        if(quantity > this.quantity)
            return false;
        return true;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
