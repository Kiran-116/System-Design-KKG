package blinkit.models;

import java.util.Map;

//warehouse or store, which generally manages the inventory or act as Inventory controller
public class Warehouse {

    public Inventory inventory;
    Address address;

    public Warehouse(Address warehouseLocation, Inventory inventory) {
        this.address = warehouseLocation;
        this.inventory = inventory;
    }

    //update inventory
    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndCountMap){

        //it will update the items in the inventory based upon product category.
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){

        //it will update the items in the inventory based upon product category.
    }

    public Address getAddress() {
        return address;
    }
}