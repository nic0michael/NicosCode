package com.solutions.fluidity.enums;

/**
 * @author nickm
 */
public enum TypeOfVehicle {
  SMALL_VEHICLE(0, "Small Vehicle"),
  ELECTRIC_VEHICLE(1, "Electric Vehicle"),
  LARGE_VEHICLE(2, "Large Vehicle");

  private final int vehicleType;
  private final String description;

  TypeOfVehicle(int vehicleType, String description) {
    this.vehicleType = vehicleType;
    this.description = description;
  }

  public int getVehicleType() {
    return vehicleType;
  }

  public String getDescription() {
    return description;
  }

}
