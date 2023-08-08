package com.solutions.fluidity;

import com.solutions.fluidity.enums.CargoLimits;
import com.solutions.fluidity.enums.TypeOfVehicle;

/**
 * In this class we don't violate the Law of Demeter Also this class has a
 * Single Responsibility to provide "Electric Car" behaviour
 *
 * @author nickm
 */
public class DemetersElectricCar extends Vehicle {

    public DemetersElectricCar() {
        super(TypeOfVehicle.ELECTRIC_VEHICLE);
    }

    public void doEverything(int cargoKgs) {
        try {
            validateCargoValue(CargoLimits.SMALL_VEHICLE_CARGO.getCargoLimit(), cargoKgs);
            super.addCargo(cargoKgs);
            super.printStats();
            super.fillUpFuel();
            super.printStats();
            super.changeOil();
            super.printStats();
            super.drive();
            super.printStats();

        } catch (IllegalArgumentException iex) {
            super.setVehicleIsOverloadedState();
            super.addCargo(cargoKgs);
            super.printStats();
        }
    }

    private void validateCargoValue(int maximumCargo, int cargoKgs) throws IllegalArgumentException {
        if (cargoKgs > maximumCargo) {
            throw new IllegalArgumentException("too heavy");
        }
    }
}
