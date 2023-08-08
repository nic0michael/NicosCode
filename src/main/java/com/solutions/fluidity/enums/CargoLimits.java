package com.solutions.fluidity.enums;

/**
 *
 * @author nickm
 */
public enum CargoLimits {
    SMALL_VEHICLE_CARGO(500),
    LARGE_VEHICLE_CARGO(18000);
        
    private int cargoLimit;
        
    CargoLimits(int cargoLimit){
        this.cargoLimit = cargoLimit;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    
    
}
