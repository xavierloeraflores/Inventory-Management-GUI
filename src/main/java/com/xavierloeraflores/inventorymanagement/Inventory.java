package com.xavierloeraflores.inventorymanagement;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
/**
 * A class representing the inventory
 * which contains all parts and products.
 * @author xavierloeraflores
 */
@SuppressWarnings("serial")
public class Inventory {
    /**
     * The [observableArrayList] of parts in the inventory.
     */
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    /**
     * The [observableArrayList] of products in the inventory.
     */
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();
    /**
     * Adds a part to the allParts list  of the inventory.
     * @param newPart The [Part] object part to be added to the allParts of the inventory.
     */
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    /**
     * Adds a product to the allProducts list  of the inventory.
     * @param newProduct The [Product] object part to be added to the allProducts of the inventory.
     */
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
    /**
     * Looks up a part given a partID and returns the result.
     * @param partId [int] partId value to be looked up
     * @return Part matching the given partId value or null if not found
     */
    public static Part lookupPart(int partId){
        for(int i = 0; i<allParts.size(); i++){
            if(allParts.get(i).getId() == partId){
                return allParts.get(i);
            }
        }
        return null;
    }
    /**
     * Looks up a product given a productId and returns the result.
     * @param productId [int] productId value to be looked up
     * @return Product matching the given productId value or null if not found
     */
    public static Product lookupProduct(int productId){
        for(int i = 0 ; i<allProducts.size(); i++){
            if(allProducts.get(i).getId()==productId){
                return allProducts.get(i);
            }
        }
        return null;
    }
    /**
     * Looks up parts given a partName and returns the result
     * @param partName [string] value partName to be looked up
     * @return ObservableList<Part> matching the given partName value or null if not found
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> parts = FXCollections.observableArrayList();
        for(int i =  0; i<allParts.size(); i++){
            if(allParts.get(i).getName().contains(partName)){
                parts.add(allParts.get(i));
            }
        }
        return parts;
    }
    /**
     * Looks up products given a productName and returns the result
     * @param productName [string] value productName to be looked up
     * @return ObservableList<Product> matching the given productName value or null if not found
     */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> products = FXCollections.observableArrayList();
        for(int i = 0; i<allProducts.size();i++){
            if(allProducts.get(i).getName().contains(productName)){
                products.add(allProducts.get(i));
            }
        }
        return products;
    }
    /**
     * Takes an index value pointing to a part in the inventory and updates it with the given newPart
     * @param index [int] index value pointing to the index of the part to be edited part in inventory
     * @param newPart [Part] newPart value which will replace the old part
     */
    public static void updatePart(int index, Part newPart){
        allParts.set(index, newPart);
    }
    /**
     * Takes an index value pointing to a product in the inventory and updates it with the given newProduct
     * @param index [int] index value pointing to the index of the product to be edited part in inventory
     * @param newProduct [Product] newProduct value which will replace the old product
     */
    public static void updateProduct(int index, Product newProduct){
        allProducts.set(index, newProduct);
    }
    /**
     * Takes an index value pointing to a part in the inventory to delete it and return true or false if successful
     * @param selectedPart [Part] newPart value which will be deleted
     * @return true if the part was successfully delete or false if no deletion was made
     */
    public static boolean deletePart(Part selectedPart){
        return allParts.remove(selectedPart);
    }
    /**
     * Takes an index value pointing to a product in the inventory to delete it and return true or false if successful
     * @param selectedProduct [Product] selectedProduct value which will be deleted
     * @return true if the product was successfully delete or false if no deletion was made
     */
    public static boolean deleteProduct(Product selectedProduct){
        return allProducts.remove(selectedProduct);
    }
    /**
     * Returns the full list of parts in the inventory
     * @return ObservableList<Part> list of parts in the inventory
     */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    /**
     * Returns the full list of product in the inventory
     * @return ObservableList<Product> list of product in the inventory
     */
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
}
