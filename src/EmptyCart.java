import Services.*;
import model.*;

public class EmptyCart {
    public static void main(String[] args) {
        System.out.println("=== EMPTY CART TEST ===");

        try {
            Customer customer = new Customer("Kareem Ashraf", 1000);
            Cart cart = new Cart();

            new CheckoutService(
                    new ShippingService(30),
                    new ReceiptService()
            ).checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("TEST PASSED: " + e.getMessage());
        }
    }
}