package Supermarket;

public interface Checkout {
    double price(String listOfItems);
    double scan(String item);
    double total();
}
