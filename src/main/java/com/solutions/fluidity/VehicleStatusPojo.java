package com.solutions.fluidity;

/**
 * This is a Pojo with status info to display about vehicle
 *
 * @author nickm
 */
public class VehicleStatusPojo {
    private boolean vehicleIsOverloaded =false;
    private boolean vehicleIsIdle = true;
    private boolean oilChanged = false;
    private boolean filledUpWithPetrol =false;
    private int cargoKgs = 0;
    private String fuelType = null;
    private String typeOfVehicle = null;

    public boolean isVehicleIsOverloaded() {
        return vehicleIsOverloaded;
    }

    public void setVehicleIsOverloaded(boolean vehicleIsOverloaded) {
        this.vehicleIsOverloaded = vehicleIsOverloaded;
    }

    public boolean isVehicleIsIdle() {
        return vehicleIsIdle;
    }

    public void setVehicleIsIdle(boolean vehicleIsIdle) {
        this.vehicleIsIdle = vehicleIsIdle;
    }

    public boolean isOilChanged() {
        return oilChanged;
    }

    public void setOilChanged(boolean oilChanged) {
        this.oilChanged = oilChanged;
    }

    public boolean isFilledUpWithPetrol() {
        return filledUpWithPetrol;
    }

    public void setFilledUpWithPetrol(boolean filledUpWithPetrol) {
        this.filledUpWithPetrol = filledUpWithPetrol;
    }

    public int getCargoKgs() {
        return cargoKgs;
    }

    public void setCargoKgs(int cargoKgs) {
        this.cargoKgs = cargoKgs;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }
    
}
