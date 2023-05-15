package com.xavierloeraflores.inventorymanagement;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * A class representing products in
 * which may or may not have associated parts
 * @author xavierloeraflores
 */
@SuppressWarnings("serial")
public class Product {
    /**
     * The [observableArrayList] of parts associated with this product.
     */
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    /**
     * The [int] value id identifying this product.
     */
    private int id;
    /**
     * The [String] value name of this product.
     */
    private String name;
    /**
     * The [double] value name of this product.
     */
    private double price;
    /**
     * The [int] value stock representing the total stock left of this product.
     */
    private int stock;
    /**
     * The [int] value min representing the minimum order quantity of this product.
     */
    private int min;
    /**
     * The [int] value max representing the maximum order quantity of this product.
     */
    private int max;

    //Constructor
    /**
     * Constructor initializing this.id to id, this.name to name, this.price to price,
     * this.stock to stock, this.min to min, this.max to max
     * @param id The [int] value id identifying this product.
     * @param name The [String] value name of this product.
     * @param price The [double] value name of this product.
     * @param stock The [int] value stock representing the total stock left of this product.
     * @param min The [int] value min representing the minimum order quantity of this product.
     * @param max The [int] value max representing the maximum order quantity of this product.
     */
    public Product(int id, String name, double price, int stock, int min, int max ){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    //Getters
    /**
     * Returns the associated parts list of the product.
     * @return [ObservableList] value associated parts of this product.
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return this.associatedParts;
    }
    /**
     * Returns the id number of the product.
     * @return [int] value id of this product.
     */
    public int getId(){
        return this.id;
    }
    /**
     * Returns the name of the product.
     * @return [String] value name of this product.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the cost price of the product.
     * @return [double] value price of this product.
     */
    public double getPrice(){
        return this.price;
    }
    /**
     * Returns the total remaining stock of the product.
     * @return [int] value stock of this product.
     */
    public int getStock(){
        return this.stock;
    }
    /**
     * Returns the minimum order quantity of the product.
     * @return [int] value min of this product.
     */
    public int getMin(){
        return this.min;
    }
    /**
     * Returns the maximum order quantity of the product.
     * @return [int] value max of this product.
     */
    public int getMax(){
        return this.max;
    }

    //Setters
    /**
     * Sets the product id number for this product
     * @param id The [int] value id of this product.
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * Sets the product name for this product.
     * @param name The [String] value name of this product.
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Sets the price cost of the product.
     * @param price The [double] value name of this product.
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * Sets the total amount of stock left for this product.
     * @param stock The [int] value stock representing the total stock left of this product.
     */
    public void setStock(int stock){
        this.stock = stock;
    }
    /**
     * Sets the minimum order quantity of the product.
     * @param min The [int] value min representing the minimum order quantity of this product.
     */
    public void setMin(int min){
        this.min = min;
    }
    /**
     * Sets the maximum order quantity of the product.
     * @param max The [int] value max representing the maximum order quantity of this product.
     */
    public void setMax(int max){
        this.max = max;
    }


    // associatedParts mutation functions
    /**
     * Adds a part to the associatedParts list of the product.
     * @param part The [Part] object part to be added to the associatedParts of this product.
     */
    public void addAssociatedPart(Part part){
        this.associatedParts.add(part);
    }
    /**
     * Deletes a part from the associatedParts list of the product.
     * @param selectedAssociatedPart The [Part] object part to be deleted to the associatedParts of this product.
     * @return A [boolean] value: true if the part was successfully deleted or false if no part was deleted.
     */
    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        return this.associatedParts.remove(selectedAssociatedPart);
    }

}
