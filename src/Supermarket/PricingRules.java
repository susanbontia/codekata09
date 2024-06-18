package Supermarket;

import java.util.Map;
import java.util.TreeMap;

public class PricingRules {

    private Map<String, ItemPriceRule> pricingRulesMap = new TreeMap<>();


    public PricingRules addItemPrice(ItemPriceRule itemPriceRule) {
        if (itemPriceRule == null || itemPriceRule.getItem() == null) {
            throw new IllegalArgumentException("itemPrice and itemPrice.getItem() cannot be null");
        }
        pricingRulesMap.put(itemPriceRule.getItem(), itemPriceRule);
        return this;
    }

    public ItemPriceRule getItemPrice(String item) {
        return this.pricingRulesMap.get(item);
    }
}
