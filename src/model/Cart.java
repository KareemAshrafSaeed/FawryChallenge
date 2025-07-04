package model;

import java.util.Vector;

public class Cart {
    private Vector<CartItem> items;
    double totalPrice;

    public  Cart(Vector<CartItem> items) {
        this.items = items;
        for (CartItem item : items) {
            totalPrice += item.getTotalPrice();
        }
    }
    public Cart() {
        items = new Vector<CartItem>();
        totalPrice = 0;
    }
    public void addItem(CartItem item) {
        items.add(item);
        totalPrice+=item.getTotalPrice();
    }
    public void removeItem(CartItem item) {
        items.remove(item);
        totalPrice-=item.getTotalPrice();
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public int getItemsCount() {
        return items.size();
    }
    public Vector<CartItem> getItems() {
        return items;
    }

    public Vector<Shippable> getShippableItems() {
        Vector<Shippable> shippables = new Vector<Shippable>();
        for(CartItem item: this.getItems()) {
            if(item.getProduct() instanceof Shippable shippable) {
                shippables.add(shippable);
            }
        }
        return shippables;
    }
}
