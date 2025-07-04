import Services.*;
import model.*;
import java.time.LocalDate;

public class EdgeCases {
    public static void main(String[] args) {
        System.out.println("=== EDGE CASES TEST ===");

        // Test 1: Minimum quantity (1)
        try {
            Product pencil = new Product("Pencil", 5, 100);
            Cart cart = new Cart();
            cart.addItem(new CartItem(pencil, 1));
            System.out.println("TEST 1 PASSED: Minimum quantity works");
        } catch (Exception e) {
            System.out.println("TEST 1 FAILED: " + e.getMessage());
        }

        // Test 2: Exact balance
        try {
            Product notebook = new Product("Notebook", 300, 5);
            Customer customer = new Customer("Kareem Ashraf", 330); // 300 + 30 shipping
            Cart cart = new Cart();
            cart.addItem(new CartItem(notebook, 1));

            new CheckoutService(
                    new ShippingService(30),
                    new ReceiptService()
            ).checkout(customer, cart);
            System.out.println("TEST 2 PASSED: Exact balance works");
        } catch (Exception e) {
            System.out.println("TEST 2 FAILED: " + e.getMessage());
        }
    }
}