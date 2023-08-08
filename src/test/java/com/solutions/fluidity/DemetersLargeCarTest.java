package com.solutions.fluidity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author nickm
 */
public class DemetersLargeCarTest {
  private final int LARGE_CAR =2;
  private final int SMALL_LOAD =2000;
  private final int OVERLOADED =50000;
  DemetersLargeCar car = null;

  @Test
  @DisplayName("Test 1 testDemetersLargeCarBeingLoaded")
  public void testDemetersLargeCarBeingLoaded(){
    car = new DemetersLargeCar();
    car.doEverything(SMALL_LOAD);
    int vehicleType = car.getVehicleType();
    Assertions.assertEquals(LARGE_CAR,vehicleType);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);

    boolean isVehicleIsOverloaded = status.isVehicleIsOverloaded();
    assertFalse(isVehicleIsOverloaded);

    int cargoKgs= status.getCargoKgs();
    Assertions.assertEquals(SMALL_LOAD,cargoKgs);

  }

  @Test
  @DisplayName("Test 2 testDemetersLargeCarOilIsChanged")
  public void testDemetersLargeCarOilIsChanged(){
    car = new DemetersLargeCar();
    car.doEverything(SMALL_LOAD);

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isOilChanged = status.isOilChanged();
    assertTrue(isOilChanged);
  }

  @Test
  @DisplayName("Test 3 testDemetersLargeCarFilledUpWithPetrol")
  public void testDemetersLargeCarFilledUpWithPetrol(){
    car = new DemetersLargeCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isFilledUpWithPetrol = status.isFilledUpWithPetrol();
    assertTrue(isFilledUpWithPetrol);
  }

  @Test
  @DisplayName("Test 4 testDemetersLargeCarBeingDriven")
  public void testDemetersLargeCarBeingDriven(){
    car = new DemetersLargeCar();
    car.doEverything(SMALL_LOAD);
    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);
    boolean isVehicleIsIdle = status.isVehicleIsIdle();
    assertFalse(isVehicleIsIdle);
  }

  @Test
  @DisplayName("Test 5 testDemetersLargeCarBeingOverloaded")
  public void testDemetersLargeCarBeingOverloaded(){
    car = new DemetersLargeCar();
    car.doEverything(OVERLOADED);
    int vehicleType = car.getVehicleType();

    VehicleStatusPojo status = car.getStatusPojo();
    Assertions.assertNotNull(status);

    boolean isVehicleIsOverloaded = status.isVehicleIsOverloaded();
    assertTrue(isVehicleIsOverloaded);

    int cargoKgs= status.getCargoKgs();
    Assertions.assertEquals(OVERLOADED,cargoKgs);
  }
}
