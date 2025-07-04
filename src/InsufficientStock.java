import Services.*;
import model.*;
import java.time.LocalDate;

public class InsufficientStock {
    public static void main(String[] args) {
        System.out.println("=== INSUFFICIENT STOCK TEST ===");

        try {
            Product phone = new Product("Smartphone", 800, 2);
            Cart cart = new Cart();

            cart.addItem(new CartItem(phone, 3)); // Only 2 available

            System.out.println("TEST FAILED: Shouldn't reach here");
        } catch (IllegalArgumentException e) {
            System.out.println("TEST PASSED: " + e.getMessage());
        }
    }
}