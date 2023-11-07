package com.engeto.shoppingcart;

public enum Category {
    FOOD("jidlo"), CONSUMABLES("spotrebni zbozi"), OTHERS("ostatni");

    private String description;

    Category(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }

    // Pri cteni a zapisu do souboru neni vhodne prekryt metodu
    //toString(. Radeji si vytvorime metodu getDescription()
    //a tu budeme volat, kdyz chceme vystup formatovany pro uzivatele
   // @Override
   // public String toString() {
   //     return  description;
    //}
}
