package Supermarket;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class CheckoutImpl implements Checkout {
    private Map<String, PurchasedItem> purchasedItemMap = new TreeMap<>();

    private PricingRules pricingRules;

    public  CheckoutImpl(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }


    @Override
    public double price(String listOfItems) {

        this.purchasedItemMap.clear();

        String[] items = listOfItems.split("");

        for (String item : items) {
            this.scan(item);
        }

        return this.total();

    }

    @Override
    public double scan(String item) {


        PurchasedItem purchasedItem = purchasedItemMap.get(item);


        if (Objects.nonNull(purchasedItem)) {

            purchasedItem.setQuantity(purchasedItem.getQuantity() + 1);
        } else {
            purchasedItem = new PurchasedItem().setItem(item).setQuantity(1).setTotalPrice(0.0);
            purchasedItemMap.put(purchasedItem.getItem(), purchasedItem);
        }

        ItemPriceRule itemPriceRule = this.pricingRules.getItemPrice(purchasedItem.getItem());

        this.calculateItemTotalPrice(purchasedItem, itemPriceRule);
        return purchasedItem.getTotalPrice();
    }

    public void calculateItemTotalPrice(PurchasedItem purchasedItem, ItemPriceRule itemPriceRule) {

        if (Objects.nonNull(itemPriceRule)) {
            int nonDiscountedQuantities = purchasedItem.getQuantity();
            double nonDiscountedItemsPrice = 0.0;
            int discountedQuantities = 0;
            double discountedItemsPrice = 0.0;

            if(Objects.nonNull(itemPriceRule.getSpecialPrice()) && purchasedItem.getQuantity() >= itemPriceRule.getSpecialPrice().getNumberOfItems()) {
                discountedQuantities = purchasedItem.getQuantity() / itemPriceRule.getSpecialPrice().getNumberOfItems();
                discountedItemsPrice = discountedQuantities * itemPriceRule.getSpecialPrice().getPrice();

                nonDiscountedQuantities = purchasedItem.getQuantity() % itemPriceRule.getSpecialPrice().getNumberOfItems();
            }

            nonDiscountedItemsPrice = nonDiscountedQuantities * itemPriceRule.getUnitPrice();
            purchasedItem.setTotalPrice(nonDiscountedItemsPrice + discountedItemsPrice);
        }
    }

    @Override
    public double total() {
        double runningTotalPrice = 0.0;

        for (PurchasedItem purchasedItem: purchasedItemMap.values()) {
            runningTotalPrice += purchasedItem.getTotalPrice();
        }

        return runningTotalPrice;
    }
}
