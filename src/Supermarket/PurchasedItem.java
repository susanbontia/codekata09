package Supermarket;

public class PurchasedItem {
    private String item;
    private int quantity;
    private double totalPrice;

    public PurchasedItem() {

    }

    public PurchasedItem(String item, int quantity, double totalPrice) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public PurchasedItem setItem(String item) {
        this.item = item;
        return this;
    }

    public PurchasedItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public PurchasedItem setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }




}
