package com.thedeciderstest.pitest;

import org.junit.Before;
import org.junit.Test;

import com.thedeciders.pitest.Passenger;
import com.thedeciders.pitest.TicketPriceCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.thedeciders.pitest.TicketPriceCalculator.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TicketPriceCalculatorTest {

    private static int ADULT_TICKET_PRICE_BUS = 40;
    private static int CHILD_TICKER_PRICE_BUS = 20;
    
    private static int ADULT_TICKET_PRICE_TRAIN = 20;
    private static int CHILD_TICKER_PRICE_TRAIN = 10;
    
    private static int ADULT_TICKET_PRICE_TAXI = 80;
    private static int CHILD_TICKER_PRICE_TAXI = 50;
    
    private static int ADULT_TICKET_PRICE_AIRPLANE = 4000;
    private static int CHILD_TICKER_PRICE_AIRPLANE = 2000;
    

    private static int ADULT_TICKET_PRICE_SHIP = 4000;
    private static int CHILD_TICKER_PRICE_SHIP = 2000;
    

    private static int ADULT_TICKET_PRICE_MOVIE = 4000;
    private static int CHILD_TICKER_PRICE_MOVIE = 2000;
    private TicketPriceCalculator calculator;
    
    
    @Before
	  public void setUp() {
    	calculator = new TicketPriceCalculator();
	  }

    @Test
    public void calculatePriceForOneAdultBUS() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        int[] arr = {10,30,35,28,22,25,29,50,78,44};
        int n=10;
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, price, 0);
    
    }
/*
    @Test
    public void sortPassengerAgeBUS() {
    
    	
        int[] arr = {10,30,35,28,22,25,29,50,78,44};
        int n=10;
        int[] age = calculator.mergeSort(arr,n);
        assertEquals(arr,age);
    
    }
    */
    
    @Test
    public void calculatePriceForChildBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((2 * ADULT_TICKET_PRICE_BUS + 2 * CHILD_TICKER_PRICE_BUS) *
                (1 - FAMILY_DISCOUNT_BUS), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseBUS() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((2 * ADULT_TICKET_PRICE_BUS + CHILD_TICKER_PRICE_BUS), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenBUS() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((ADULT_TICKET_PRICE_BUS + 2 * CHILD_TICKER_PRICE_BUS), price, 0);
    
    }
    
    
    @Test
    public void calculatePriceForOneAdultTRAIN() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(ADULT_TICKET_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForChildTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((2 * ADULT_TICKET_PRICE_TRAIN + 2 * CHILD_TICKER_PRICE_TRAIN) *
                (1 - FAMILY_DISCOUNT_TRAIN), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseTRAIN() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((2 * ADULT_TICKET_PRICE_TRAIN + CHILD_TICKER_PRICE_TRAIN), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenTRAIN() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((ADULT_TICKET_PRICE_TRAIN + 2 * CHILD_TICKER_PRICE_TRAIN), price, 0);
    
    }
    
    
    @Test
    public void calculatePriceForOneAdultTAXI() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(ADULT_TICKET_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForChildTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((2 * ADULT_TICKET_PRICE_TAXI + 2 * CHILD_TICKER_PRICE_TAXI) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_TAXI), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals(CHILD_TICKER_PRICE_TAXI, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseTAXI() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((2 * ADULT_TICKET_PRICE_TAXI + CHILD_TICKER_PRICE_TAXI), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenTAXI() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((ADULT_TICKET_PRICE_TAXI + 2 * CHILD_TICKER_PRICE_TAXI), price, 0);
    
    }
    
    @Test
    public void calculatePriceForOneAdultShip() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
        assertEquals(ADULT_TICKET_PRICE_SHIP, price, 0);
    
    }

    @Test
    public void calculatePriceForChildShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
      assertEquals(CHILD_TICKER_PRICE_SHIP, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
       assertEquals((2 * ADULT_TICKET_PRICE_SHIP + 2 * CHILD_TICKER_PRICE_SHIP) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_SHIP), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_AIRPLANE);
        assertEquals(CHILD_TICKER_PRICE_AIRPLANE, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseShip() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
       assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
     assertEquals((2 * ADULT_TICKET_PRICE_SHIP + CHILD_TICKER_PRICE_SHIP), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenShip() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_AIRPLANE, CHILD_TICKER_PRICE_SHIP);
        assertEquals((ADULT_TICKET_PRICE_SHIP + 2 * CHILD_TICKER_PRICE_SHIP), price, 0);
    
    }
    
    @Test
    public void calculatePriceForOneAdultMovie() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(ADULT_TICKET_PRICE_MOVIE, price, 0);
    
    }
    

    @Test
    public void calculatePriceForChildMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceAirPlane(passengers, ADULT_TICKET_PRICE_AIRPLANE, CHILD_TICKER_PRICE_AIRPLANE);
        assertEquals(CHILD_TICKER_PRICE_AIRPLANE, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((2 * ADULT_TICKET_PRICE_MOVIE + 2 * CHILD_TICKER_PRICE_MOVIE) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_MOVIE), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(CHILD_TICKER_PRICE_MOVIE, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseMovie() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((2 * ADULT_TICKET_PRICE_MOVIE + CHILD_TICKER_PRICE_MOVIE), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenMovie() {

    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((ADULT_TICKET_PRICE_MOVIE + 2 * CHILD_TICKER_PRICE_MOVIE), price, 0);

    }

    @Test
    public void testInvalidAgeBoundary() {
        List<Passenger> passengers = new ArrayList<>();

        // Case 1: Age at the boundary (150)
        Passenger passengerAtBoundary = new Passenger(150);
        passengers.add(passengerAtBoundary);
        // This should not print "Not Valid" or trigger any invalid logic
        double priceBoundary = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, priceBoundary, 0); // Assuming 150 is treated as adult

        // Case 2: Age above 150 (invalid age)
        passengers.clear();
        Passenger passengerAboveBoundary = new Passenger(151);
        passengers.add(passengerAboveBoundary);
        // Capture the output if necessary to verify "Not Valid" is printed
        double priceAboveBoundary = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(0, priceAboveBoundary, 0); // Assuming invalid passengers are not charged

        // Case 3: Age below 150 (valid age)
        passengers.clear();
        Passenger passengerBelowBoundary = new Passenger(149);
        passengers.add(passengerBelowBoundary);
        double priceBelowBoundary = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, priceBelowBoundary, 0); // Valid adult ticket price
    }

    @Test
    public void testSeniorCitizenBoundaryConditions() {
        List<Passenger> passengers = new ArrayList<>();

        // Case 1: Age exactly 60 (not a senior citizen)
        Passenger passengerAtLowerBoundary = new Passenger(60);
        passengers.add(passengerAtLowerBoundary);
        double priceLowerBoundary = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, priceLowerBoundary, 0); // Valid adult, not senior citizen

        // Case 2: Age exactly 100 (not a senior citizen)
        passengers.clear();
        Passenger passengerAtUpperBoundary = new Passenger(100);
        passengers.add(passengerAtUpperBoundary);
        double priceUpperBoundary = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, priceUpperBoundary, 0); // Valid adult, not senior citizen

        // Case 3: Age between 60 and 100 (senior citizen)
        passengers.clear();
        Passenger seniorCitizen = new Passenger(110);
        passengers.add(seniorCitizen);
        double priceSeniorCitizen = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, priceSeniorCitizen, 0); // Senior citizen logic should apply
    }

    @Test(timeout = 1000)
    public void testMergeSortEdgeCases() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // Case 1: Array of size 1
        int[] singleElementArray = {42};
        int[] sortedSingleElement = calculator.mergeSortBus(singleElementArray, singleElementArray.length);
        assertArrayEquals(new int[]{42}, sortedSingleElement);

        // Case 2: Array of size 2
        int[] twoElementArray = {42, 21};
        int[] sortedTwoElement = calculator.mergeSortBus(twoElementArray, twoElementArray.length);
        assertArrayEquals(new int[]{21, 42}, sortedTwoElement);

        // Case 3: Array of size 3
        int[] threeElementArray = {42, 21, 84};
        int[] sortedThreeElement = calculator.mergeSortBus(threeElementArray, threeElementArray.length);
        assertArrayEquals(new int[]{21, 42, 84}, sortedThreeElement);

        // Case 4: Larger array
        int[] largeArray = {5, 2, 9, 1, 5, 6};
        int[] sortedLargeArray = calculator.mergeSortBus(largeArray, largeArray.length);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, sortedLargeArray);

        // Case 5: Array already sorted
        int[] sortedArray = {1, 2, 3, 4};
        int[] resultSortedArray = calculator.mergeSortBus(sortedArray, sortedArray.length);
        assertArrayEquals(new int[]{1, 2, 3, 4}, resultSortedArray);

        // Case 6: Array in reverse order
        int[] reverseArray = {4, 3, 2, 1};
        int[] resultReverseArray = calculator.mergeSortBus(reverseArray, reverseArray.length);
        assertArrayEquals(new int[]{1, 2, 3, 4}, resultReverseArray);
    }

    @Test(timeout = 1000)
    public void testMergeSortParkSmallArray() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // Case 1: Single element
        int[] singleElementArray = {10};
        int[] sortedSingleElement = calculator.mergeSortPark(singleElementArray, singleElementArray.length);
        assertArrayEquals(new int[]{10}, sortedSingleElement);

        // Case 2: Two elements
        int[] twoElementArray = {20, 10};
        int[] sortedTwoElement = calculator.mergeSortPark(twoElementArray, twoElementArray.length);
        assertArrayEquals(new int[]{10, 20}, sortedTwoElement);
    }
    @Test(timeout = 1000)
    public void testMergeSortParkLargeArray() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // Case 1: Array where n is a power of 2
        int[] powerOfTwoArray = {8, 4, 2, 1};
        int[] sortedPowerOfTwoArray = calculator.mergeSortPark(powerOfTwoArray, powerOfTwoArray.length);
        assertArrayEquals(new int[]{1, 2, 4, 8}, sortedPowerOfTwoArray);

        // Case 2: Array where n is not a power of 2
        int[] nonPowerOfTwoArray = {9, 7, 5, 3, 1};
        int[] sortedNonPowerOfTwoArray = calculator.mergeSortPark(nonPowerOfTwoArray, nonPowerOfTwoArray.length);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, sortedNonPowerOfTwoArray);
    }
    @Test(timeout = 1000)
    public void testMergeSortParkEdgeCases() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        int[] largeArray = {10, 20, 5, 15, 30, 25, 1, 35};

        // Add logging to track the value of right_end
        calculator.mergeSortPark(largeArray, largeArray.length); // No assertion, verify via logging
    }

    @Test
    public void testMergeSortPlaneBasic() {
        int[] arr = { 3, 1, 4, 1 };
        int[] expected = { 1, 1, 3, 4};


        int[] result = calculator.mergeSortAirPlane(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTrainBasic() {
        int[] arr = { 3, 1, 4, 1 };
        int[] expected = { 1, 1, 3, 4};


        int[] result = calculator.mergeSortTrain(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortBusBasic() {
        int[] arr = { 3, 1, 4, 1 };
        int[] expected = { 1, 1, 3, 4};


        int[] result = calculator.mergeSortBus(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortWithEdgeCase() {
        int[] arr = { 3, 1, 4, 1 };
        int[] expected = { 1, 1, 3, 4};


        int[] result = calculator.mergeSortMovie(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortSubtractionAddition() {
        int[] arr = { 5, 3, 8, 2, 1 };
        int[] expected = { 1, 2, 3, 5, 8 };


        // Testing with values that will go through subtraction and addition in the merge sort
        int[] result = calculator.mergeSortMovie(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortNegatedConditional() {
        int[] arr = { 9, 2, 6, 3, 1, 5 };
        int[] expected = { 1, 2, 3, 5, 6, 9 };


        // Testing a case that involves negating condition checks in merge sort
        int[] result = calculator.mergeSortMovie(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortMultiplicationDivision() {
        int[] arr = { 1, 5, 9, 3, 6, 7, 2 };
        int[] expected = { 1, 2, 3, 5, 6, 7, 9 };


        // The multiplication logic in the merge sort (e.g., `curr_size = 2 * curr_size`) should still behave correctly.
        int[] result = calculator.mergeSortMovie(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortShipBasic() {
        int[] arr = { 4, 2, 7, 1, 9, 3, 6, 8, 5 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortWithNegativeNumbers() {
        int[] arr = { -5, 3, -2, 8, 0, -1 };
        int[] expected = { -5, -2, -1, 0, 3, 8 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortWithZero() {
        int[] arr = { 3, 0, 1, 5, 2, 4 };
        int[] expected = { 0, 1, 2, 3, 4, 5 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortSingleElement() {
        int[] arr = { 1 };
        int[] expected = { 1 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortAlreadySorted() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortWithRepeatedElements() {
        int[] arr = { 4, 5, 4, 2, 5, 3, 2 };
        int[] expected = { 2, 2, 3, 4, 4, 5, 5 };


        int[] result = calculator.mergeSortShip(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTaxiBasic() {
        int[] arr = { 4, 2, 7, 1, 9, 3, 6, 8, 5 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };


        int[] result = calculator.mergeSortTaxi(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTaxiWithNegativeNumbers() {
        int[] arr = { -5, 3, -2, 8, 0, -1 };
        int[] expected = { -5, -2, -1, 0, 3, 8 };


        int[] result = calculator.mergeSortTaxi(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTaxiWithZero() {
        int[] arr = { 3, 0, 1, 5, 2, 4 };
        int[] expected = { 0, 1, 2, 3, 4, 5 };


        int[] result = calculator.mergeSortTaxi(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTaxiSingleElement() {
        int[] arr = { 1 };
        int[] expected = { 1 };


        int[] result = calculator.mergeSortTaxi(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testMergeSortTaxiEmptyArray() {
        int[] arr = {};
        int[] expected = {};


        int[] result = calculator.mergeSortTaxi(arr, arr.length);


        assertArrayEquals(expected, result);
    }


    @Test
    public void testCalculatePriceHotelWithFamilyDiscount() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(25), // Adult
                new Passenger(40), // Adult
                new Passenger(5),   // Child
                new Passenger(6)
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Define expected result with family discount
        double expectedPrice = (1 - FAMILY_DISCOUNT_MOVIE) * (2 * adultTicketPrice + 2*childTicketPrice);


        // Call the method
        double result = calculator.calculatePriceHotel(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceHotelSingleAdult() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(30)  // Adult
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = adultTicketPrice;


        // Call the method
        double result = calculator.calculatePriceHotel(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceHotelSingleChild() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(7)  // Child
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = childTicketPrice;


        // Call the method
        double result = calculator.calculatePriceHotel(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceHotelInvalidAgeNegative() {
        // Define passengers with invalid age
        List<Passenger> passengers = Arrays.asList(
                new Passenger(-5)  // Invalid age
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result is 0 due to invalid input
        double expectedPrice = 0.0;


        // Call the method
        double result = calculator.calculatePriceHotel(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void calculatePriceForSeniorCitizenHotel() {
        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65)); // Senior citizen
        passengers.add(new Passenger(70)); // Senior citizen
        double price = calculator.calculatePriceHotel(passengers, adultTicketPrice, childTicketPrice);
        assertEquals(2 * adultTicketPrice, price, 0);
    }




    @Test
    public void testCalculatePriceTaxiWithFamilyDiscount() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(25), // Adult
                new Passenger(40), // Adult
                new Passenger(5),   // Child
                new Passenger(6)
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Define expected result with family discount
        double expectedPrice = (1 - FAMILY_DISCOUNT_TAXI) * (2 * adultTicketPrice + 2*childTicketPrice);


        // Call the method
        double result = calculator.calculatePriceTaxi(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }






    @Test
    public void testCalculatePriceTaxiSingleAdult() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(30)  // Adult
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = adultTicketPrice;


        // Call the method
        double result = calculator.calculatePriceTaxi(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceTaxiSingleChild() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(7)  // Child
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = childTicketPrice;


        // Call the method
        double result = calculator.calculatePriceTaxi(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceTaxiInvalidAgeNegative() {
        // Define passengers with invalid age
        List<Passenger> passengers = Arrays.asList(
                new Passenger(-5)  // Invalid age
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result is 0 due to invalid input
        double expectedPrice = 0.0;


        // Call the method
        double result = calculator.calculatePriceTaxi(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void calculatePriceForSeniorCitizenTaxi() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65)); // Senior citizen
        passengers.add(new Passenger(70)); // Senior citizen
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals(2 * ADULT_TICKET_PRICE_TAXI, price, 0);
    }


    @Test
    public void testCalculatePriceAirPlaneWithFamilyDiscount() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(25), // Adult
                new Passenger(40), // Adult
                new Passenger(5),   // Child
                new Passenger(6)
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Define expected result with family discount
        double expectedPrice = (1 - FAMILY_DISCOUNT_AIRPLANE) * (2 * adultTicketPrice + 2*childTicketPrice);


        // Call the method
        double result = calculator.calculatePriceAirPlane(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceAirPlaneSingleAdult() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(30)  // Adult
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = adultTicketPrice;


        // Call the method
        double result = calculator.calculatePriceAirPlane(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceAirPlaneSingleChild() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(7)  // Child
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = childTicketPrice;


        // Call the method
        double result = calculator.calculatePriceAirPlane(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void calculatePriceForSeniorCitizenAirPlane() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65)); // Senior citizen
        passengers.add(new Passenger(70)); // Senior citizen
        double price = calculator.calculatePriceAirPlane(passengers, ADULT_TICKET_PRICE_AIRPLANE, CHILD_TICKER_PRICE_AIRPLANE);
        assertEquals(2 * ADULT_TICKET_PRICE_AIRPLANE, price, 0);
    }




    @Test
    public void testCalculatePriceAirPlaneInvalidAgeNegative() {
        // Define passengers with invalid age
        List<Passenger> passengers = Arrays.asList(
                new Passenger(-5)  // Invalid age
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result is 0 due to invalid input
        double expectedPrice = 0.0;


        // Call the method
        double result = calculator.calculatePriceAirPlane(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void calculatePriceForInvalidHighAgeBus() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(160)); // Invalid age
        passengers.add(new Passenger(30));  // Valid adult
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, price, 0);
    }


    @Test
    public void calculatePriceForInvalidNegativeAgeBus() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(-5));  // Invalid age
        passengers.add(new Passenger(5));  // Valid child
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS, price, 0);
    }


    @Test
    public void calculatePriceForBoundaryAgesBus() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(FREE_TICKET_AGE_BELOW_BUS + 1)); // Child
        passengers.add(new Passenger(ADULT_AGE_BUS + 1));             // Adult
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS + ADULT_TICKET_PRICE_BUS, price, 0);
    }


    @Test
    public void calculatePriceForFamilyDiscountBus() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(30)); // Adult
        passengers.add(new Passenger(35)); // Adult
        passengers.add(new Passenger(10)); // Child
        passengers.add(new Passenger(8));  // Child


        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        double expectedPrice = (1 - FAMILY_DISCOUNT_BUS) * (2 * ADULT_TICKET_PRICE_BUS + 2 * CHILD_TICKER_PRICE_BUS);
        assertEquals(expectedPrice, price, 0);
    }


    @Test
    public void calculatePriceForSeniorCitizenBus() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65)); // Senior citizen
        //passengers.add(new Passenger(70)); // Senior citizen
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals( ADULT_TICKET_PRICE_BUS, price, 0);
    }




    @Test
    public void testCalculatePriceTrainWithFamilyDiscount() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(25), // Adult
                new Passenger(40), // Adult
                new Passenger(5),   // Child
                new Passenger(6)
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Define expected result with family discount
        double expectedPrice = (1 - FAMILY_DISCOUNT_TRAIN) * (2 * adultTicketPrice + 2*childTicketPrice);


        // Call the method
        double result = calculator.calculatePriceTrain(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceTrainSingleAdult() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(30)  // Adult
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = adultTicketPrice;


        // Call the method
        double result = calculator.calculatePriceTrain(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceTrainSingleChild() {
        // Define passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger(7)  // Child
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result with no discount
        double expectedPrice = childTicketPrice;


        // Call the method
        double result = calculator.calculatePriceTrain(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void testCalculatePriceTrainInvalidAgeNegative() {
        // Define passengers with invalid age
        List<Passenger> passengers = Arrays.asList(
                new Passenger(-5)  // Invalid age
        );


        // Ticket prices
        int adultTicketPrice = 100;
        int childTicketPrice = 50;


        // Expected result is 0 due to invalid input
        double expectedPrice = 0.0;


        // Call the method
        double result = calculator.calculatePriceTrain(passengers, adultTicketPrice, childTicketPrice);


        // Assert the result
        assertEquals(expectedPrice, result, 0.01);
    }


    @Test
    public void calculatePriceForSeniorCitizenTrain() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65)); // Senior citizen
        passengers.add(new Passenger(70)); // Senior citizen
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(2 * ADULT_TICKET_PRICE_TRAIN, price, 0);
    }



    @Test
    public void testPriceCalculationAcrossMultipleTransportModes() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // Create a list of passengers
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(25));  // Adult
        passengers.add(new Passenger(3));   // Free ticket (child)
        passengers.add(new Passenger(65));  // Senior citizen
        passengers.add(new Passenger(150)); // Upper valid age boundary
        passengers.add(new Passenger(200)); // Invalid age

        // Calculate bus ticket price
        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        System.out.println("Bus price: " + busPrice);
        assertEquals(120.0, busPrice, 0.01); // 2 adults, 1 child, no family discount

        // Calculate train ticket price
        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        System.out.println("Train price: " + trainPrice);
        assertEquals(60.0, trainPrice, 0.01); // 2 adults, 1 child, no family discount

        // Calculate airplane ticket price
        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        System.out.println("Airplane price: " + airplanePrice);
        assertEquals(12000.0, airplanePrice, 0.01); // 3 adults, 1 child (charged as adult), no family discount
    }



    @Test
    public void testPriceCalculationForInvalidPassengers() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // All passengers have invalid ages
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(-10));  // Negative age (invalid, should be skipped)
        passengers.add(new Passenger(0));   // Free ticket (child, should be counted but not priced)
        passengers.add(new Passenger(160)); // Age above maximum (invalid, should be skipped)

        // Calculate bus ticket price
        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        // No valid passengers, only free ticket child (age 0)
        assertEquals(0.0, busPrice, 0.01);  // Only invalid passengers and age 0 (free)

        // Calculate train ticket price
        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        // Same logic applies for the train, no valid passengers contributing to the price
        assertEquals(0.0, trainPrice, 0.01);  // Only invalid passengers and age 0 (free)
    }

    @Test
    public void testFamilyDiscountAcrossModes() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        // Family with 2 adults and 2 children
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(35));  // Adult 1
        passengers.add(new Passenger(40));  // Adult 2
        passengers.add(new Passenger(10));  // Child 1
        passengers.add(new Passenger(5));   // Child 2

        // Calculate bus ticket price
        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        assertEquals((2 * 40 + 2 * 20) * 0.95, busPrice, 0.01); // Family discount applied

        // Calculate train ticket price
        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals((2 * 20 + 2 * 10) * 0.75, trainPrice, 0.01); // Family discount applied

        // Calculate airplane ticket price
        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        assertEquals((2 * 4000 + 2 * 2000) * 0.0, airplanePrice, 0.01); // Family discount applied
    }

    @Test
    public void testNoPassengers() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        assertEquals(0.0, busPrice, 0.01);

        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals(0.0, trainPrice, 0.01);

        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        assertEquals(0.0, airplanePrice, 0.01);
    }

    @Test
    public void testMixedValidAndInvalidPassengers() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(25));  // Valid adult
        passengers.add(new Passenger(3));   // Free ticket (child)
        passengers.add(new Passenger(65));  // Senior citizen
        passengers.add(new Passenger(160)); // Invalid passenger
        passengers.add(new Passenger(-10)); // Invalid passenger

        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        assertEquals(80.0, busPrice, 0.01); // 2 adults (40 each)

        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals(40.0, trainPrice, 0.01); // 2 adults (20 each)

        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        assertEquals(8000.0, airplanePrice, 0.01); // 2 adults (4000 each)
    }

    @Test
    public void testExtremeAges() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(0));   // Free ticket
        passengers.add(new Passenger(1));   // Free ticket
        passengers.add(new Passenger(150)); // Valid adult (upper boundary)

        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        assertEquals(40.0, busPrice, 0.01); // Only age 150 contributes

        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals(20.0, trainPrice, 0.01); // Only age 150 contributes

        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        assertEquals(4000.0, airplanePrice, 0.01); // Only age 150 contributes
    }

    @Test
    public void testNoFamilyDiscount() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(35));  // Adult
        passengers.add(new Passenger(25));  // Adult
        passengers.add(new Passenger(7));   // Child (does not meet discount criteria)

        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        // No family discount as there's only 1 child
        assertEquals((2 * 40 + 1 * 20), busPrice, 0.01); // 80 + 20 = 100

        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals((2 * 20 + 1 * 10), trainPrice, 0.01); // 40 + 10 = 50

        double airplanePrice = calculator.calculatePriceAirPlane(passengers, 4000, 2000);
        assertEquals((2 * 4000 + 1 * 2000), airplanePrice, 0.01); // 8000 + 2000 = 10000
    }

    @Test
    public void testSeniorCitizenGroup() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(65));   // Senior citizen
        passengers.add(new Passenger(70));   // Senior citizen
        passengers.add(new Passenger(60));   // Senior citizen boundary
        passengers.add(new Passenger(45));   // Adult

        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        assertEquals((3 * 40 + 1 * 40), busPrice, 0.01); // 4 adults x 40 = 160

        double trainPrice = calculator.calculatePriceTrain(passengers, 20, 10);
        assertEquals((4 * 20), trainPrice, 0.01); // 4 adults x 20 = 80
    }

    @Test
    public void testExtremeDiscountScenario() {
        TicketPriceCalculator calculator = new TicketPriceCalculator();

        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(30));  // Adult
        passengers.add(new Passenger(12));  // Child

        double busPrice = calculator.calculatePriceBus(passengers, 40, 20);
        // No discount as not enough passengers for family
        assertEquals((40 + 20), busPrice, 0.01); // 60
    }

}