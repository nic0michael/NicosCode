package com.solutions.fluidity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nickm
 */
public class DemetersElectriclCarTest {
  private final int ELECTRIC_CAR = 1;
  private final int SMALL_LOAD = 200;
  private final int OVERLOADED = 1000;
  Vehicle car = null;

  @Test
  @DisplayName("Test 1 testDemetersElectricCarBeingLoaded")
  public void testDemetersElectricCarBeingLoaded() {
    car = new DemetersElectricCar();
    car.doEverything(SMALL_LOAD);
    int vehicleType = car.getVehicleType();
    Assertions.assertEquals(ELECTRIC_CAR, vehicleType);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);

    boolean isVehicleIsOverloaded = status.isVehicleIsOverloaded();
    assertFalse(isVehicleIsOverloaded);

    int cargoKgs = status.getCargoKgs();
    Assertions.assertEquals(SMALL_LOAD, cargoKgs);

  }

  @Test
  @DisplayName("Test 2 testDemetersElectricCarOilIsChanged")
  public void testDemetersElectricCarOilIsChanged() {
    car = new DemetersElectricCar();
    car.doEverything(SMALL_LOAD);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isOilChanged = status.isOilChanged();
    assertTrue(isOilChanged);
  }

  @Test
  @DisplayName("Test 3 testDemetersElectricCarFilledUpWithElectricity")
  public void testDemetersElectricCarFilledUpWithElectricity() {
    car = new DemetersElectricCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isFilledUpWithPetrol = status.isFilledUpWithPetrol();
    assertTrue(isFilledUpWithPetrol);
  }

  @Test
  @DisplayName("Test 4 testDemetersElectricCarBeingDriven")
  public void testDemetersElectricCarBeingDriven() {
    car = new DemetersElectricCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isVehicleIsIdle = status.isVehicleIsIdle();
    assertFalse(isVehicleIsIdle);
  }

  @Test
  @DisplayName("Test 5 testDemetersElectricCarBeingOverloaded")
  public void testDemetersElectricCarBeingOverloaded() {
    car = new DemetersElectricCar();
    car.doEverything(OVERLOADED);
    int vehicleType = car.getVehicleType();

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);

    boolean isVehicleIsOverloaded = status.isVehicleIsOverloaded();
    assertTrue(isVehicleIsOverloaded);

    int cargoKgs = status.getCargoKgs();
    Assertions.assertEquals(OVERLOADED, cargoKgs);
  }
}
