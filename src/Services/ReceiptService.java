package Services;

import model.Cart;
import model.CartItem;
import model.Customer;
import model.Shippable;

import java.util.Vector;

public class ReceiptService {
    public void printReceipt(Customer customer, Cart cart, double shipping) {
        System.out.print("** Checkout receipt ** \n");
        Vector<CartItem> items = cart.getItems();
        for(CartItem item: items) {
            System.out.println(item.getQuantity()+ "x " +item.getName() + "\t" + item.getProduct().getPrice());
        }
        System.out.println("----------------------");
        double subtotal = cart.getTotalPrice();
        System.out.println("Subtotal \t" + subtotal);
        System.out.println("Shipping \t" + shipping);
        System.out.println("Amount \t" + (shipping + subtotal));
        System.out.println("Current balance \t" + customer.getBalance());
    }

}
