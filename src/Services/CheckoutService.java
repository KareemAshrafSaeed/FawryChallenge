package Services;

import Exceptions.InsufficientBalanceException;
import model.Cart;
import model.Customer;
import model.Shippable;

import java.util.Vector;
import java.util.concurrent.CancellationException;

public class CheckoutService {
    ShippingService shippingService;
    ReceiptService receiptService;
    public CheckoutService(ShippingService shippingService, ReceiptService receiptService) {
        this.shippingService = shippingService;
        this.receiptService = receiptService;
    }

    public void checkout(Customer customer, Cart cart) {
        double shipping = cart.getShippableItems().isEmpty()? 0: shippingService.getShippingPrice();

        if(customer.getBalance() - cart.getTotalPrice() - shipping < 0)
            throw new InsufficientBalanceException("Balance is not sufficient");

        if(cart.getItemsCount()<= 0)
            throw new CancellationException("Cart is empty");


        if(!cart.getShippableItems().isEmpty())
            shippingService.shipItems(cart.getShippableItems());
        customer.setBalance(customer.getBalance() - cart.getTotalPrice() - shipping);
        receiptService.printReceipt(customer, cart, shipping);

    }

}
