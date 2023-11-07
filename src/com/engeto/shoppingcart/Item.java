package com.engeto.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String description;
    private BigDecimal price;
    private Category category;

    public Item(String description, BigDecimal price, Category category) {
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Item(String description, BigDecimal price) {
        this(description, price, Category.OTHERS);
    }

    public Item() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws CartException {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new CartException("Cena vyrobku nesmi byt zaporna - zadana: "+price+" Kc.");
        }
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Polozka: " +
                 description +
                " " + price + " Kc" +
                " (" + category.getDescription() + ")";

    }
}
