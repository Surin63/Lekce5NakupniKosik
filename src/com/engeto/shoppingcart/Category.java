package com.engeto.shoppingcart;

public enum Category {
    FOOD("jidlo"), CONSUMABLES("spotrebni zbozi"), OTHERS("ostatni");

    private String description;

    Category(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
