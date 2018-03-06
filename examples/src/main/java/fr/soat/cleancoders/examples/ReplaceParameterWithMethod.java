package fr.soat.cleancoders.examples;

class ReplaceParameterWithMethod {
    private int quantity;
    private int itemPrice;

    ReplaceParameterWithMethod(int quantity, int price) {
        this.quantity = quantity;
        this.itemPrice = price;
    }

    double getPrice(){
        int basePrice = quantity * itemPrice;
        double finalPrice = discountedPrice(basePrice);
        return finalPrice;
    }

    private int getDiscountLevel() {
        return quantity > 100 ? 2 : 1;
    }

    private double discountedPrice(int basePrice) {
        int discountLevel = getDiscountLevel();

        if (discountLevel == 2)
            return basePrice * 0.1;

       else  return basePrice * 0.05;
    }
}
