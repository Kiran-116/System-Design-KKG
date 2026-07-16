package blinkit.strategy.warehouseStrategy;

import blinkit.models.Warehouse;
import blinkit.strategy.WarehouseSelectionStrategy;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {

    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        if (warehouseList == null || warehouseList.isEmpty()) {
            System.out.println("❌ No warehouses available for selection!");
            return null;  // Return null to indicate failure
        }

        // 🏗️ Future Scope: Implement actual distance calculation logic here
        // 1️⃣ Get the user's location (latitude, longitude).
        // 2️⃣ Use Haversine Formula OR Google Maps API to calculate distance between user & warehouses.
        // 3️⃣ Select the warehouse with the shortest distance.
        Warehouse nearestWarehouse = warehouseList.get(0);  // Dummy selection for now

        System.out.println("📦 Nearest warehouse selected: " + nearestWarehouse.getAddress().getPinCode());
        return nearestWarehouse;
    }
}