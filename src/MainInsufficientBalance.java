import Services.*;
import model.*;
import java.time.LocalDate;

public class MainInsufficientBalance {
    public static void main(String[] args) {
        System.out.println("=== INSUFFICIENT BALANCE TEST ===");

        try {
            ShippableProduct laptop = new ShippableProduct("Laptop", 1200, 3, 2500, 3);
            Customer customer = new Customer("Kareem Ashraf", 500);
            Cart cart = new Cart();

            cart.addItem(new CartItem(laptop, 1));

            new CheckoutService(
                    new ShippingService(30),
                    new ReceiptService()
            ).checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("TEST PASSED: " + e.getMessage());
        }
    }
}