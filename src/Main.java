import Services.CheckoutService;
import Services.ReceiptService;
import Services.ShippingService;
import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            PerishableShippableProduct cheese = new PerishableShippableProduct(
                    "Cheese", 100, 10, 200, 3, LocalDate.now().plusDays(7));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 5000, 5);
            Product scratchCard = new Product("Scratch Card", 50, 20);

            Customer customer = new Customer("Kareem Ashraf", 780);

            Cart cart = new Cart();
            cart.addItem(new CartItem(cheese, 2));
            cart.addItem(new CartItem(tv, 1));
            cart.addItem(new CartItem(scratchCard, 1));

            // Create services
            ShippingService shippingService = new ShippingService(30);
            ReceiptService receiptService = new ReceiptService();
            CheckoutService checkoutService = new CheckoutService(shippingService, receiptService);

            // Perform checkout
            checkoutService.checkout(customer, cart);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}