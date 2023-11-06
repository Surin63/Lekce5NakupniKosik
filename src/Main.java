import com.engeto.shoppingcart.Cart;
import com.engeto.shoppingcart.CartException;
import com.engeto.shoppingcart.Category;
import com.engeto.shoppingcart.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Cart shoppingCart = new Cart();
       // fillItems(shoppingCart);
        Cart shoppingCart;
        try {
            shoppingCart = Cart.loadFromFile("cart.txt");
            System.out.println(shoppingCart.getListOfItems());
        } catch (CartException e) {
            System.err.println("Chyba pri cteni ze souboru: "+e.getLocalizedMessage());
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
        //Prevod: cele cislo: Integer.parseInt(blocks[0]);
        //Prevod: datum: LocalDAte.parse(blocks[0]);
        Item newItem = new Item(description, price, category);
        cart.addItem(newItem);
    }
}