import Services.*;
import model.*;
import java.time.LocalDate;

public class MixedProducts {
    public static void main(String[] args) {
        System.out.println("=== MIXED PRODUCTS TEST ===");

        PerishableProduct milk = new PerishableProduct(
                "Milk", 80, 10, LocalDate.now().plusDays(5));
        ShippableProduct book = new ShippableProduct("Book", 150, 5, 800, 3);
        Product giftCard = new Product("Gift Card", 100, 20);

        Customer customer = new Customer("Kareem Ashraf", 2000);
        Cart cart = new Cart();

        cart.addItem(new CartItem(milk, 3));
        cart.addItem(new CartItem(book, 2));
        cart.addItem(new CartItem(giftCard, 1));

        new CheckoutService(
                new ShippingService(30),
                new ReceiptService()
        ).checkout(customer, cart);
    }
}