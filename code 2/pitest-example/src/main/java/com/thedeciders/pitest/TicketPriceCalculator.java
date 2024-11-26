package com.thedeciders.pitest;

import java.util.List;

public class TicketPriceCalculator {

    public static int ADULT_AGE_BUS = 18;
    public static int FREE_TICKET_AGE_BELOW_BUS = 3;
    private static int SENIOR_CITIZEN_BUS = 60;
    private static int ARMY_OFFICER_BUS = 18;
    public static double FAMILY_DISCOUNT_BUS= 0.05;
    
    private static int ADULT_AGE_TRAIN = 18;
    private static int FREE_TICKET_AGE_BELOW_TRAIN = 3;
    private static int SENIOR_CITIZEN_TRAIN = 60;
    private static int ARMY_OFFICER_TRAIN = 18;
    public static double FAMILY_DISCOUNT_TRAIN= 0.25;
    
    
    private static int ADULT_AGE_AIRPLANE = 18;
    private static int FREE_TICKET_AGE_BELOW_AIRPLANE = 3;
    private static int SENIOR_CITIZEN_AIRPLANE = 60;
    private static int ARMY_OFFICER_AIRPLANE = 18;
    public static double FAMILY_DISCOUNT_AIRPLANE= 1;
    
    
    private static int ADULT_AGE_TAXI = 18;
    private static int FREE_TICKET_AGE_BELOW_TAXI = 3;
    private static int SENIOR_CITIZEN_TAXI = 60;
    private static int ARMY_OFFICER_TAXI = 18;
    public static double FAMILY_DISCOUNT_TAXI= 0.15;
    
    private static int ADULT_AGE_SHIP = 18;
    private static int FREE_TICKET_AGE_BELOW_SHIP = 3;
    private static int SENIOR_CITIZEN_SHIP = 60;
    private static int ARMY_OFFICER_SHIP = 18;
    public static double FAMILY_DISCOUNT_SHIP= 0.05;
    
    private static int ADULT_AGE_MOVIE = 18;
    private static int FREE_TICKET_AGE_BELOW_MOVIE = 3;
    private static int SENIOR_CITIZEN_MOVIE = 60;
    private static int ARMY_OFFICER_MOVIE = 18;
    public static double FAMILY_DISCOUNT_MOVIE= 0.05;
    
    private static int ADULT_AGE_HOTEL = 18;
    private static int FREE_TICKET_AGE_BELOW_HOTEL = 3;
    private static int SENIOR_CITIZEN_HOTEL = 60;
    private static int ARMY_OFFICER_HOTEL = 18;
    public static double FAMILY_DISCOUNT_HOTEL= 0.05;

//    public double calculatePriceBus(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice ) {
//        int totalPriceBus = 0;
//        int childrenCounterBus = 0;
//        int adultCounterBus = 0;
//        double resultBus;
//        int seniorCitizen=0;
//
//
//        for (Passenger passenger : passengers) {
//
//        	if(passenger.getAge() >150)
//        	{
//        		System.out.println("Not Valid");
//
//        	}
//        	if(passenger.getAge() < 0)
//        	{
//        		 System.out.println("Not Valid");
//
//        	}
//
//        	if(passenger.getAge() >60 && passenger.getAge()<100)
//        	{
//        		 System.out.println("Person is senior citizen");
//        		 seniorCitizen++;
//
//        	}
//
//            if (passenger.getAge() > ADULT_AGE_BUS) {
//                totalPriceBus += adultTicketPrice;
//                adultCounterBus++;
//            }
//            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_BUS) {
//                totalPriceBus += childTicketPrice;
//                childrenCounterBus++;
//            }
//        }
//
//        if (childrenCounterBus > 1 && adultCounterBus > 1) {
//            resultBus = (1 - FAMILY_DISCOUNT_BUS) * totalPriceBus;
//        }
//        else {
//            resultBus = totalPriceBus;
//        }
//
//          //sortBusPassengerAge(arr,n);
//        return resultBus;
//    }
//

    public double calculatePriceBus(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceBus = 0;
        int childrenCounterBus = 0;
        int adultCounterBus = 0;
        double resultBus=0.0;
        int seniorCitizen = 0;

        for (Passenger passenger : passengers) {
            // Skip invalid passengers
            if (passenger.getAge() > 150 || passenger.getAge() < 0) {
                System.out.println("Not Valid");
                continue; // Skip processing this passenger
            }


            // Senior citizen check (optional, for output only)
            if (passenger.getAge() > 60 && passenger.getAge() < 100) {
                System.out.println("Person is senior citizen");
                seniorCitizen++;
                totalPriceBus+=adultTicketPrice;
                continue;
            }

            // Calculate ticket price based on age
            if (passenger.getAge() > ADULT_AGE_BUS) {
                totalPriceBus += adultTicketPrice;
                adultCounterBus++;
            } else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_BUS) {
                totalPriceBus += childTicketPrice;
                childrenCounterBus++;
            }
        }

        // Apply family discount if applicable
        if (childrenCounterBus > 1 && adultCounterBus > 1) {
            resultBus = (1 - FAMILY_DISCOUNT_BUS) * totalPriceBus;
        } else {
            resultBus = totalPriceBus;
        }

        return resultBus;
    }





    /* Iterative mergesort function to sor
    t arr[0...n-1] */
    public int[] mergeSortBus(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergeBus(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergeBus(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    public double calculatePriceTrain(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceTrain = 0;
        int childrenCounterTrain = 0;
        int adultCounterTrain = 0;
        double resultTrain=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {

            if (passenger.getAge() > 150 || passenger.getAge() < 0) {
                System.out.println("Not Valid");
                continue; // Skip processing this passenger
            }

        	
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
                totalPriceTrain+=adultTicketPrice;
                continue;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_TRAIN) {
                totalPriceTrain += adultTicketPrice;
                adultCounterTrain++;
            }
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_TRAIN) {
                totalPriceTrain += childTicketPrice;
                childrenCounterTrain++;
            }
        }

        if (childrenCounterTrain > 1 && adultCounterTrain > 1) {
            resultTrain = (1 - FAMILY_DISCOUNT_TRAIN) * totalPriceTrain;
        } 
        else {
            resultTrain = totalPriceTrain;
        }

        return resultTrain;
    }
    
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
    public int[] mergeSortTrain(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergeTrain(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergeTrain(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    public double calculatePriceAirPlane(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPrice = 0;
        int childrenCounter = 0;
        int adultCounter = 0;
        double result=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {

            if (passenger.getAge() > 150 || passenger.getAge() < 0) {
                System.out.println("Not Valid");
                continue; // Skip processing this passenger
            }


            if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_AIRPLANE) {
                totalPrice += adultTicketPrice;
                adultCounter++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_AIRPLANE) {
                totalPrice += childTicketPrice;
                childrenCounter++;
            }
        }

        if (childrenCounter > 1 && adultCounter > 1) {
            result = (1 - FAMILY_DISCOUNT_AIRPLANE) * totalPrice;
        } 
        else {
            result = totalPrice;
        }

        return result;
    }
    
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
    public int[] mergeSortAirPlane(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergeAirPlane(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergeAirPlane(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public double calculatePriceTaxi(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceTaxi = 0;
        int childrenCounterTaxi = 0;
        int adultCounterTaxi = 0;
        double resultTaxi=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {
        	
        	if(passenger.getAge() >150)
        	{
        		System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	if(passenger.getAge() < 0)
        	{
        		 System.out.println("Not Valid");
                 return 0.0;
        		
        	}
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
                totalPriceTaxi+=adultTicketPrice;
                continue;
        		
        	}
        	
            if (passenger.getAge() > ADULT_AGE_TAXI) {
                totalPriceTaxi += adultTicketPrice;
                adultCounterTaxi++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_TAXI) {
                totalPriceTaxi += childTicketPrice;
                childrenCounterTaxi++;
            }
        }

        if (childrenCounterTaxi > 1 && adultCounterTaxi > 1) {
            resultTaxi = (1 - FAMILY_DISCOUNT_TAXI) * totalPriceTaxi;
        }
        else {
            resultTaxi = totalPriceTaxi;
        }

        return resultTaxi;
    }
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
    public int[] mergeSortTaxi(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergeTaxi(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergeTaxi(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    
    public double calculatePriceMovie(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceMovie = 0;
        int childrenCounterMovie = 0;
        int adultCounterMovie = 0;
        double resultMovie=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {
        	
        	if(passenger.getAge() >150)
        	{
        		System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	if(passenger.getAge() < 0)
        	{
        		 System.out.println("Not Valid");
                 return 0.0;
        		
        	}
        	
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
                totalPriceMovie+=adultTicketPrice;
                continue;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_MOVIE) {
                totalPriceMovie += adultTicketPrice;
                adultCounterMovie++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_MOVIE) {
                totalPriceMovie+= childTicketPrice;
                childrenCounterMovie++;
            }
        }

        if (childrenCounterMovie > 1 && adultCounterMovie > 1) {
            resultMovie = (1 - FAMILY_DISCOUNT_MOVIE) * totalPriceMovie;
        } 
        else {
            resultMovie = totalPriceMovie;
        }

        return resultMovie;
    }
    
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
    public int[] mergeSortMovie(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergeMovie(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergeMovie(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public double calculatePriceHotel(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceMovie = 0;
        int childrenCounterMovie = 0;
        int adultCounterMovie = 0;
        double resultMovie=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {
        	
        	if(passenger.getAge() >150)
        	{
        		System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	if(passenger.getAge() < 0)
        	{
        		 System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
                totalPriceMovie+=adultTicketPrice;
                continue;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_MOVIE) {
                totalPriceMovie += adultTicketPrice;
                adultCounterMovie++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_MOVIE) {
                totalPriceMovie+= childTicketPrice;
                childrenCounterMovie++;
            }
        }

        if (childrenCounterMovie > 1 && adultCounterMovie > 1) {
            resultMovie = (1 - FAMILY_DISCOUNT_MOVIE) * totalPriceMovie;
        } 
        else {
            resultMovie = totalPriceMovie;
        }

        return resultMovie;
    }
    
    public double calculatePriceShip(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceMovie = 0;
        int childrenCounterMovie = 0;
        int adultCounterMovie = 0;
        double resultMovie=0.0;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {
        	
        	if(passenger.getAge() >150)
        	{
        		System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	if(passenger.getAge() < 0)
        	{
        		 System.out.println("Not Valid");
                return 0.0;
        		
        	}
        	
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
                 totalPriceMovie+=adultTicketPrice;
                 continue;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_MOVIE) {
                totalPriceMovie += adultTicketPrice;
                adultCounterMovie++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_MOVIE) {
                totalPriceMovie+= childTicketPrice;
                childrenCounterMovie++;
            }
        }

        if (childrenCounterMovie > 1 && adultCounterMovie > 1) {
            resultMovie = (1 - FAMILY_DISCOUNT_MOVIE) * totalPriceMovie;
        } 
        else {
            resultMovie = totalPriceMovie;
        }

        return resultMovie;
    }
    
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
//    public int[] mergeSortShip(int arr[], int n)
//    {
//
//        // For current size of subarrays to
//        // be merged curr_size varies from
//        // 1 to n/2
//        int curr_size;
//
//        // For picking starting index of
//        // left subarray to be merged
//        int left_start;
//
//
//        // Merge subarrays in bottom up
//        // manner. First merge subarrays
//        // of size 1 to create sorted
//        // subarrays of size 2, then merge
//        // subarrays of size 2 to create
//        // sorted subarrays of size 4, and
//        // so on.
//        for (curr_size = 1; curr_size <= n-1;
//                      curr_size = 2*curr_size)
//        {
//
//            // Pick starting point of different
//            // subarrays of current size
//            for (left_start = 0; left_start < n-1;
//                        left_start += 2*curr_size)
//            {
//                // Find ending point of left
//                // subarray. mid+1 is starting
//                // point of right
//                int mid = left_start + curr_size - 1;
//
//                int right_end = Math.min(left_start
//                             + 2*curr_size - 1, n-1);
//
//                // Merge Subarrays arr[left_start...mid]
//                // & arr[mid+1...right_end]
//                mergeBus(arr, left_start, mid, right_end);
//            }
//        }
//        return arr;
//    }
    public int[] mergeSortShip(int arr[], int n) {
        int curr_size;

        for (curr_size = 1; curr_size <= n-1; curr_size = 2 * curr_size) {
            System.out.println("Current size: " + curr_size);

            for (int left_start = 0; left_start < n-1; left_start += 2 * curr_size) {
                int mid = left_start + curr_size - 1;
                int right_end = Math.min(left_start + 2 * curr_size - 1, n-1);

                mergeShip(arr, left_start, mid, right_end);
            }
        }
        return arr;
    }
    void mergeShip(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
    public double calculatePricePark(List<Passenger> passengers, int adultTicketPrice, int childTicketPrice) {
        int totalPriceMovie = 0;
        int childrenCounterMovie = 0;
        int adultCounterMovie = 0;
        double resultMovie;
        int seniorCitizen=0;
        for (Passenger passenger : passengers) {
        	
        	if(passenger.getAge() >150)
        	{
        		System.out.println("Not Valid");
        		
        	}
        	if(passenger.getAge() < 0)
        	{
        		 System.out.println("Not Valid");
        		
        	}
        	
        	if(passenger.getAge() >60 && passenger.getAge()<100)
        	{
        		 System.out.println("Person is senior citizen");
        		 seniorCitizen++;
        		
        	}
            if (passenger.getAge() > ADULT_AGE_MOVIE) {
                totalPriceMovie += adultTicketPrice;
                adultCounterMovie++;
            } 
            else if (passenger.getAge() > FREE_TICKET_AGE_BELOW_MOVIE) {
                totalPriceMovie+= childTicketPrice;
                childrenCounterMovie++;
            }
        }

        if (childrenCounterMovie > 1 && adultCounterMovie > 1) {
            resultMovie = (1 - FAMILY_DISCOUNT_MOVIE) * totalPriceMovie;
        } 
        else {
            resultMovie = totalPriceMovie;
        }

        return resultMovie;
    }
    

	/* Iterative mergesort function to sor 
    t arr[0...n-1] */
    public int[] mergeSortPark(int arr[], int n)
    { 
          
        // For current size of subarrays to 
        // be merged curr_size varies from  
        // 1 to n/2 
        int curr_size;  
                      
        // For picking starting index of  
        // left subarray to be merged 
        int left_start; 
                          
          
        // Merge subarrays in bottom up  
        // manner. First merge subarrays  
        // of size 1 to create sorted  
        // subarrays of size 2, then merge 
        // subarrays of size 2 to create  
        // sorted subarrays of size 4, and 
        // so on. 
        for (curr_size = 1; curr_size <= n-1;  
                      curr_size = 2*curr_size) 
        { 
              
            // Pick starting point of different 
            // subarrays of current size 
            for (left_start = 0; left_start < n-1; 
                        left_start += 2*curr_size) 
            { 
                // Find ending point of left  
                // subarray. mid+1 is starting  
                // point of right 
                int mid = left_start + curr_size - 1; 
          
                int right_end = Math.min(left_start  
                             + 2*curr_size - 1, n-1); 
          
                // Merge Subarrays arr[left_start...mid] 
                // & arr[mid+1...right_end] 
                mergePark(arr, left_start, mid, right_end); 
            } 
        } 
        return arr;
    } 
  
    void mergePark(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        
        for (i = 0; i < n1; i++) 
            L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
            R[j] = arr[m + 1+ j]; 
      
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
      
       
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
    
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
   
}