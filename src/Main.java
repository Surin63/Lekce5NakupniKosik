import com.engeto.shoppingcart.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        //Cart shoppingCart = new Cart();
       // fillItems(shoppingCart);
        Cart shoppingCart = new Cart();
        try {
            shoppingCart = Cart.loadFromFile(Settings.defaultFileName());
            System.out.println(shoppingCart.getListOfItems());
        } catch (CartException e) {
            System.err.println("Chyba pri cteni ze souboru: "+e.getLocalizedMessage());
        }
        shoppingCart.addItem(new Item("Pokus", BigDecimal.valueOf(156)));
        try {
            Cart.saveToFile(Settings.defaultFileName(), shoppingCart);
        } catch (CartException e) {
            System.err.println("Chyba pri zapisu ze souboru: "+e.getLocalizedMessage());;
        }


    }

    private static void fillItems(Cart shoppingCart) {
        Item pecivo = new Item("Pecivo", BigDecimal.valueOf(148.1), Category.FOOD);
        try {
            pecivo.setPrice(BigDecimal.valueOf(-48.1));
            pecivo.setPrice(BigDecimal.valueOf(48.1));
            System.out.println("Jsem tu!");
        } catch (CartException e) {
            System.err.println("Chyba pri zmene ceny polozky '"+pecivo.getDescription()+"': "+e.getLocalizedMessage());
        }
        shoppingCart.addItem(pecivo);
        shoppingCart.addItem(
                new Item("Tekute mydlo (250ml)", BigDecimal.valueOf(89.9),
                        Category.CONSUMABLES));
        System.out.println(shoppingCart.getItem(0));

    }
}