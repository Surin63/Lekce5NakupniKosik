package com.engeto.shoppingcart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<Item> listOfItems = new ArrayList<>();
    private LocalDate dateOfPurchase = LocalDate.now();

    public Cart() {}

    public Cart(List<Item> listOfItems, LocalDate dateOfPurchase) {
        this.listOfItems.addAll(listOfItems);
        this.dateOfPurchase = dateOfPurchase;
    }
    public static Cart loadFromFile(String filename) throws CartException {
        Cart result = new Cart();
        int lineNumber=1;       //Pocitani radku v souboru aby sme nasli kde je chyba

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) { //Otevri soubor
            while (scanner.hasNextLine()) { //Dokud je k dispozici dalsi radek
                String line = scanner.nextLine(); // Nacti radek ze souboru
                //System.out.println(line);       //Vypis radek na obrazovku
                parseLine(line, result, lineNumber);
               lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new CartException("Nepodarilo se nalezt soubour " + filename + ": " + e.getLocalizedMessage());
        }

        return result;
    }

    private static void parseLine(String line, Cart cart, int lineNumber) throws CartException {
        String[] blocks = line.split(";");  //Rozdeli radek na bloky podle oddelovace
        int numOfBlocks = blocks.length;        // Zkontroluje spravny pocet bloku
        if(numOfBlocks != 3) {
            throw new CartException(
                    "Nespravny pocet polozek na radku: " +line+
                            "! Pocet polozek: "+numOfBlocks+".");
        }
        String description = blocks[0].trim();     //Preved textove polozky na objekty
        BigDecimal price;
        try {
            price = new BigDecimal(blocks[1].trim());
        }catch (NumberFormatException e) {
            throw new CartException("Chybne zadane cislo "+blocks[1]+" na radku c. "+lineNumber+": "+line+"!");
        }
        Category category = Category.valueOf(blocks[2].trim());
        //Prevod: cele cislo: Integer.parseInt(blocks[0].trim());
        //Prevod: datum: LocalDAte.parse(blocks[0].trim());
        Item newItem = new Item(description, price, category);  //Vytvor objekt Item
        cart.addItem(newItem);                              // Uloz vytvoreny objekt do kosiku
    }

    public void addItem(Item newItem) {listOfItems.add(newItem);}
    public void removeItem(int index) {
        listOfItems.remove(index);
    }
    public Item getItem(int index) {return listOfItems.get(index);}

    public List<Item> getListOfItems() {

        return new ArrayList<>(listOfItems);
    }
    public void addAllItem(List<Item> listOfNewItems) {
        this.listOfItems.addAll(listOfNewItems);
    }
    public void replaceAllItem(List<Item> listOfNewItems) {
        this.listOfItems = new ArrayList<>(listOfNewItems);
        }


    public Item get(int index) {
        return listOfItems.get(index);
    }


    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
