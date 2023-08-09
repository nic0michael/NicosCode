package com.solutions.fluidity;

import com.solutions.fluidity.enums.TypeOfFuel;
import com.solutions.fluidity.enums.TypeOfVehicle;

/**
 * @author nickm
 * I decided to take the code from the original car class and make it this superclass
 * */
public abstract class Vehicle {

  VehicleStatusPojo status = new VehicleStatusPojo();
  private int cargoKgs = 0;
  private int vehicleType = 0;
  private String fuelType = null;

  public Vehicle(TypeOfVehicle typeOfVehicle) {
    this.vehicleType = typeOfVehicle.getVehicleType();
    setFuelTypeInStatusPojo();
    setVehiclelTypeInStatusPojo();
  }

  /**
   * This method allows the super Class to be replaced by a child Class
   * Liskov Substitution Principle
   * Also the only public method exposed to comply with Law of Demeter
   *
   * @param cargoKgs
   */
  public void doEverything(int cargoKgs) {
  }

  protected void drive() {
    status.setVehicleIsIdle(false);
  }

  public void addCargo(int cargoKgs) {
    this.cargoKgs = cargoKgs;
    status.setCargoKgs(cargoKgs);
  }

  protected void fillUpFuel() {
    status.setFilledUpWithPetrol(true);
  }

  protected void changeOil() {
    status.setOilChanged(true);
  }

  protected void setVehicleIsOverloadedState() {
    status.setVehicleIsOverloaded(true);
  }

  protected void printStats() {
    System.out.println("Vehicle Statistics");
    System.out.println("==================");
    System.out.println("Vehicle type: " + status.getTypeOfVehicle());
    System.out.println("Fuel type: " + status.getFuelType());

    if (status.isVehicleIsOverloaded()) {
      System.out.println("Vehicle is Overloaded: " + status.getCargoKgs() + " Kg");
    } else {
      System.out.println("Vehicle is loaded with: " + status.getCargoKgs() + " Kg");
    }

    if (status.isFilledUpWithPetrol()) {
      System.out.println("Vehicle is being filled up with : " + status.getFuelType());
    }

    if (status.isOilChanged()) {
      System.out.println("Vehicle's oil has being changed");
    }

    if (status.isVehicleIsIdle()) {
      System.out.println("Vehicle is Idle: ");
    } else {
      System.out.println("Vehicle is being driven: ");
    }

    System.out.println("==================\n\n");
  }

  protected int getVehicleType() {
    return vehicleType;
  }

  protected VehicleStatusPojo getStatusPojo() {
    return status;
  }

  private void setFuelTypeInStatusPojo() {

    switch (vehicleType) {
      case 0:
        fuelType = TypeOfFuel.SMALL_VEHICLE.getFuelType();
        break;

      case 1:
        fuelType = TypeOfFuel.ELECTRIC_VEHICLE.getFuelType();
        break;

      case 2:
        fuelType = TypeOfFuel.LARGE_VEHICLE.getFuelType();
        break;

      default:
        throw new IllegalArgumentException("Unkwown VehicleType");
    }
    status.setFuelType(fuelType);
  }

  private void setVehiclelTypeInStatusPojo() {
    String typeOfVehicle = null;

    switch (vehicleType) {
      case 0:
        typeOfVehicle = TypeOfVehicle.SMALL_VEHICLE.getDescription();
        break;

      case 1:
        typeOfVehicle = TypeOfVehicle.ELECTRIC_VEHICLE.getDescription();
        break;

      case 2:
        typeOfVehicle = TypeOfVehicle.LARGE_VEHICLE.getDescription();
        break;

      default:
        throw new IllegalArgumentException("Unkwown VehicleType");
    }
    status.setTypeOfVehicle(typeOfVehicle);
  }
}
