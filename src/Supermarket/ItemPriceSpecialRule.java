package Supermarket;

public class ItemPriceSpecialRule {

    private int numberOfItems;
    private double price;

    public ItemPriceSpecialRule() {

    }

    public ItemPriceSpecialRule(int numberOfItems, double price) {
        this.numberOfItems = numberOfItems;
        this.price = price;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public double getPrice() {
        return price;
    }

    public ItemPriceSpecialRule setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
        return  this;
    }

    public ItemPriceSpecialRule setPrice(double price) {
        this.price = price;
        return this;
    }



}
