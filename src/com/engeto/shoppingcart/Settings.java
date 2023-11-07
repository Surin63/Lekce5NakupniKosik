package com.engeto.shoppingcart;

public class Settings {
    private static final String fileItemDelimiterValue = ";";
    private static final String defaultFileNameValue = "cart.txt";

    public static String fileItemDelimiter(){

        return fileItemDelimiterValue;
    }
    public static String defaultFileName(){
        return defaultFileNameValue;
    }
}
