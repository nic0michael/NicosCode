package com.solutions.fluidity.enums;

/**
 * @author nickm
 */
public enum TypeOfFuel {

  SMALL_VEHICLE("Petrol"),
  ELECTRIC_VEHICLE("Electricity KW"),
  LARGE_VEHICLE("Petrol");

  private final String fuelType;

  TypeOfFuel(String fuelType) {
    this.fuelType = fuelType;
  }

  public String getFuelType() {
    return fuelType;
  }

}
