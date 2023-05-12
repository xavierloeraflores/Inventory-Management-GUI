package com.xavierloeraflores.inventorymanagement;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
/**
 * A class representing the inventory
 * which contains all parts and products.
 * @author xavierloeraflores
 */
public class Inventory {
    /**
     * The [observableArrayList] of parts in the inventory.
     */
    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * The [observableArrayList] of products in the inventory.
     */
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();
    /**
     * Adds a part to the allParts list  of the inventory.
     * @param newPart The [Part] object part to be added to the allParts of the inventory.
     */
    public void addPart(Part newPart){
        this.allParts.add(newPart);
    }
    /**
     * Adds a product to the allProducts list  of the inventory.
     * @param newProduct The [Product] object part to be added to the allProducts of the inventory.
     */
    public void newProduct(Product newProduct){
        this.allProducts.add(newProduct);
    }
    public Part lookupPart(int partId){
        for(int i = 0; i<this.allParts.size(); i++){
            if(allParts.get(i).getId() == partId){
                return allParts.get(i);
            }
        }
        return null;
    }
    public Product lookupProduct(int productId){
        for(int i = 0 ; i<this.allProducts.size(); i++){
            if(allProducts.get(i).getId()==productId){
                return allProducts.get(i);
            }
        }
        return null;
    }
    public ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> parts = FXCollections.observableArrayList();
        for(int i =  0; i<allParts.size(); i++){
            if(allParts.get(i).getName().contains(partName)){
                parts.add(allParts.get(i));
            }
        }
        return parts;
    }
    public ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> products = FXCollections.observableArrayList();
        for(int i = 0; i<allProducts.size();i++){
            if(allProducts.get(i).getName().contains(productName)){
                products.add(allProducts.get(i));
            }
        }
        return products;
    }


}
/**
 * TODO:DOCS
 + lookupPart(partId:int):Part
 + lookupProduct(productId:int):Product
 + lookupPart(partName:String):ObservableList<Part>
 + lookupProduct(productName:String):ObservableList<Product> + updatePart(index:int, selectedPart:Part):void
 * TODO:METHODS
 + updateProduct(index:int, newProduct:Product):void
 + deletePart(selectedPart:Part):boolean
 + deleteProduct(selectedProduct:Product):boolean
 + getAllParts():ObservableList<Part>
 + getAllProducts():ObservableList<Product>
 */