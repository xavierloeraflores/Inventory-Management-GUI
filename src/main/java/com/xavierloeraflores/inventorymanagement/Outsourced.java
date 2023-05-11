package com.xavierloeraflores.inventorymanagement;

/**
 * A class representing outsourced parts in
 * which inherits from the part class.
 * @author xavierloeraflores
 */
public class Outsourced extends Part{
    /**
     * The [String] value companyName of the outsourced company than can develop this part.
     */
    private String companyName;
    /**
     * Constructor initializing this.id to id, this.name to name, this.price to price,
     * this.stock to stock, this.min to min, this.max to max, this.companyName to companyName
     * @param id The [int] value id identifying this part.
     * @param name The [String] value name of this part.
     * @param price The [double] value name of this part.
     * @param stock The [int] value stock representing the total stock left of this part.
     * @param min The [int] value min representing the minimum order quantity of this part.
     * @param max The [int] value max representing the maximum order quantity of this part.
     * @param companyName  The [String] value companyName of the outsourced company than can develop this part.
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
    //Getters
    /**
     * Returns the companyName of the outsourced company than can develop this part.
     * @return [String] value companyName of this outsourced part.
     */
    public String getCompanyName(){
        return this.companyName;
    }
    //Setters
    /**
     * Sets the companyName of the outsourced company than can develop this part.
     * @param companyName The [String] value companyName of this outsourced part.
     */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
}
