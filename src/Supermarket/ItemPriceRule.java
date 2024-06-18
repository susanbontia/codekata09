package Supermarket;

public class ItemPriceRule {

    private String item;
    private double unitPrice;
    ItemPriceSpecialRule itemPriceSpecialRule;

    public ItemPriceRule() {

    }

    public ItemPriceRule(String item, double unitPrice, ItemPriceSpecialRule itemPriceSpecialRule) {
        this.item = item;
        this.unitPrice = unitPrice;
        this.itemPriceSpecialRule = itemPriceSpecialRule;
    }

    public String getItem() {
        return item;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public ItemPriceSpecialRule getSpecialPrice() {
        return itemPriceSpecialRule;
    }

    public ItemPriceRule setItem(String item) {
        this.item = item;
        return this;
    }

    public ItemPriceRule setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public ItemPriceRule setSpecialPrice(ItemPriceSpecialRule itemPriceSpecialRule) {
        this.itemPriceSpecialRule = itemPriceSpecialRule;
        return this;
    }


}
