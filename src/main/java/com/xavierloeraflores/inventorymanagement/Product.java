package com.xavierloeraflores.inventorymanagement;
/**
 *
 * @author xavierloeraflores
 */
import javafx.collections.ObservableList;

public class Product {
    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    //Getters
    public ObservableList getAllAssociatedParts(){
        return associatedParts;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }



}
