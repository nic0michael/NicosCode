package com.solutions.fluidity;

import com.solutions.fluidity.enums.CargoLimits;
import com.solutions.fluidity.enums.TypeOfVehicle;

/**
 * In this class we don't violate the Law of Demeter
 * Also this class has a Single Responsibility to provide "Large Car" behaviour
 *
 * @author nickm
 */
public class DemetersLargeCar extends Vehicle {

  public DemetersLargeCar() {
    super(TypeOfVehicle.LARGE_VEHICLE);
  }

  public void doEverything(int cargoKgs) {
    try {
      validateCargoValue(CargoLimits.LARGE_VEHICLE_CARGO.getCargoLimit(), cargoKgs);
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
