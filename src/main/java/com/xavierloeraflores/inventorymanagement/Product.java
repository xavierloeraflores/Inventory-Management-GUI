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

}
