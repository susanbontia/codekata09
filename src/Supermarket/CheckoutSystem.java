package Supermarket;

public class CheckoutSystem {
    public void doCheckout() {
        PricingRules pricingRules = new PricingRules();
        pricingRules.addItemPrice(new ItemPriceRule("A", 50, new ItemPriceSpecialRule(3, 130)));
        pricingRules.addItemPrice(new ItemPriceRule("B", 30, new ItemPriceSpecialRule(2, 45)));
        pricingRules.addItemPrice(new ItemPriceRule("C", 20, null));
        pricingRules.addItemPrice(new ItemPriceRule("D", 15, null));

        CheckoutImpl checkout = new CheckoutImpl(pricingRules);

        System.out.println("=======================================");
        purchasedItemsTotalAmount(checkout, "");
        purchasedItemsTotalAmount(checkout, "A");
        purchasedItemsTotalAmount(checkout, "AB");
        purchasedItemsTotalAmount(checkout, "CDBA");

        System.out.println("=======================================");
        System.out.println();
        purchasedItemsTotalAmount(checkout, "AA");
        purchasedItemsTotalAmount(checkout, "AAA");
        purchasedItemsTotalAmount(checkout, "AAAA");
        purchasedItemsTotalAmount(checkout, "AAAAA");
        purchasedItemsTotalAmount(checkout, "AAAAAA");

        System.out.println("=======================================");
        System.out.println();
        purchasedItemsTotalAmount(checkout, "AAAB");
        purchasedItemsTotalAmount(checkout, "AAABB");
        purchasedItemsTotalAmount(checkout, "AAABBD");
        purchasedItemsTotalAmount(checkout, "DABABA");

        System.out.println("=======================================");
        System.out.println();
        purchasedItemsTotalAmount(checkout, "ABAAB");
        purchasedItemsTotalAmount(checkout, "abaab");
        purchasedItemsTotalAmount(checkout, "AbaabCDCBa");

        System.out.println("=======================================");
        System.out.println();

        checkout = new CheckoutImpl(pricingRules);
        scanAndGetRunningTotal(checkout, "A");
        scanAndGetRunningTotal(checkout, "B");
        scanAndGetRunningTotal(checkout, "A");
        scanAndGetRunningTotal(checkout, "A");
        scanAndGetRunningTotal(checkout, "B");
        scanAndGetRunningTotal(checkout, "c");
        scanAndGetRunningTotal(checkout, "d");
        scanAndGetRunningTotal(checkout, "B");

    }

    public void scanAndGetRunningTotal(Checkout checkout, String item) {
        double itemsRunningPrice = checkout.scan(item.toUpperCase());
        double overAllRunningTotalPrice = checkout.total();

        System.out.println("Scan: " + item + "; Price: " + itemsRunningPrice + "; Running Total: " + overAllRunningTotalPrice);
    }

    public void purchasedItemsTotalAmount(Checkout checkout, String purchasedItems) {
        System.out.println("Items: " + purchasedItems + "; Total: " + checkout.price(purchasedItems.toUpperCase()));
    }
}
