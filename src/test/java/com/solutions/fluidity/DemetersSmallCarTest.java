package com.solutions.fluidity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nickm
 */
public class DemetersSmallCarTest {
  private final int SMALL_CAR = 0;
  private final int SMALL_LOAD = 200;
  private final int OVERLOADED = 1000;
  Vehicle car = null;

  @Test
  @DisplayName("Test 1 testDemetersSmallCarBeingLoaded")
  public void testDemetersSmallCarBeingLoaded() {
    car = new DemetersSmallCar();
    car.doEverything(SMALL_LOAD);
    int vehicleType = car.getVehicleType();
    Assertions.assertEquals(SMALL_CAR, vehicleType);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);

    boolean isVehicleIsOverloaded = status.isVehicleIsOverloaded();
    assertFalse(isVehicleIsOverloaded);

    int cargoKgs = status.getCargoKgs();
    Assertions.assertEquals(SMALL_LOAD, cargoKgs);

  }

  @Test
  @DisplayName("Test 2 testDemetersSmallCarOilIsChanged")
  public void testDemetersSmallCarOilIsChanged() {
    car = new DemetersSmallCar();
    car.doEverything(SMALL_LOAD);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isOilChanged = status.isOilChanged();
    assertTrue(isOilChanged);
  }

  @Test
  @DisplayName("Test 3 testDemetersSmallCarFilledUpWithPetrol")
  public void testDemetersSmallCarFilledUpWithPetrol() {
    car = new DemetersSmallCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isFilledUpWithPetrol = status.isFilledUpWithPetrol();
    assertTrue(isFilledUpWithPetrol);
  }

  @Test
  @DisplayName("Test 4 testDemetersSmallCarBeingDriven")
  public void testDemetersSmallCarBeingDriven() {
    car = new DemetersSmallCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isVehicleIsIdle = status.isVehicleIsIdle();
    assertFalse(isVehicleIsIdle);
  }

  @Test
  @DisplayName("Test 5 testDemetersSmallCarBeingOverloaded")
  public void testDemetersSmallCarBeingOverloaded() {
    car = new DemetersSmallCar();
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
