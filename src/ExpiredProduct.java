import Services.*;
import model.*;
import java.time.LocalDate;

public class ExpiredProduct {
    public static void main(String[] args) {
        System.out.println("=== EXPIRED PRODUCT TEST ===");

        try {
            PerishableShippableProduct expiredYogurt = new PerishableShippableProduct(
                    "Yogurt", 80, 5, 300, 2, LocalDate.now().minusDays(1));

            Cart cart = new Cart();
            cart.addItem(new CartItem(expiredYogurt, 1));

            System.out.println("TEST FAILED: Shouldn't reach here");
        } catch (IllegalArgumentException e) {
            System.out.println("TEST PASSED: " + e.getMessage());
        }
    }
}