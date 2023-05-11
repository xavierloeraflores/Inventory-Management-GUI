package com.xavierloeraflores.inventorymanagement;

/**
 * A class representing in house products in
 * which inherits from the part class.
 * @author xavierloeraflores
 */
public class InHouse extends Part{
    /**
     * The [int] value machineId of the machine than can develop this part in house.
     */
    private int machineId;
    /**
     * Constructor initializing this.id to id, this.name to name, this.price to price,
     * this.stock to stock, this.min to min, this.max to max, this.machineId to machineId
     * @param id The [int] value id identifying this part.
     * @param name The [String] value name of this part.
     * @param price The [double] value name of this part.
     * @param stock The [int] value stock representing the total stock left of this part.
     * @param min The [int] value min representing the minimum order quantity of this part.
     * @param max The [int] value max representing the maximum order quantity of this part.
     * @param machineId The [int] value machineId of the machine than can develop this part in house.
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    //Getters
    /**
     * Returns the id number of the product.
     * @return [int] value machineId of the machine that can develop this part.
     */
    public int getMachineId(){
        return this.machineId;
    }
    //Setters
    /**
     * Sets the machineId of the machine than can develop this part in house.
     * @param machineId The [int] value machineId of the machine than can develop this part in house.
     */
    public void setMachineId(int machineId){
        this.machineId = machineId;
    }
}
