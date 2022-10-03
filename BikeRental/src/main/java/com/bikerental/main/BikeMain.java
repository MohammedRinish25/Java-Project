package com.bikerental.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.bikerental.model.Bike;
import com.bikerental.service.BikeServiceImpl;
import com.bikerental.service.IBikeService;




public class BikeMain {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bike Rental Application ");
		Scanner sc=new Scanner(System.in);
		IBikeService rentalService=new BikeServiceImpl();
		 System.out.println("Enter your choice\n"  +"1.Add a Bike\n" +"2.Delete a Bike\n"+"3.Get By bike Number\n"+"4.Get All Bikes\n"+"5.Update Bike fare \n"+"6.Get Bike based On category\n"+"7.Get Bike based On Category and Fare\n"
				 +"8.Get Bike based On Timings and Location\n"+"9.Get Bike based On Timings and Category\n"+"10.Get Bike based On Duration");
		 int choice=sc.nextInt();
		 sc.nextLine();
		 
		 switch(choice) {
		 case 1:
			 System.out.println("Enter The Bike Number");
			 String number=sc.nextLine();
			 
			 System.out.println("Enter The Bike Name");
			 String name=sc.nextLine();
			 
			 System.out.println("Enter The Brand Name");
			 String brand=sc.nextLine();
			 
			 System.out.println("Enter The Location");
			 String location=sc.nextLine();
			 
			 System.out.println("Enter The Category");
			 String category=sc.nextLine();
			 
			 System.out.println("Enter the Start Date");
			 String start=sc.nextLine();
			 LocalDate startDate=LocalDate.parse(start);
			 
			 
			 System.out.println("Enter the End Date");
			 String end=sc.nextLine();
			 LocalDate endDate=LocalDate.parse(end);
			
			
			 System.out.println("Enter Start Date&Time(yyyy-mm-dd hh:mm):");
		     String timeStart  = sc.nextLine();
			 DateTimeFormatter startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 LocalDateTime startTime = LocalDateTime.parse(timeStart, startFormatter);
			
			 
			 System.out.println("Enter End Date&Time(yyyy-mm-dd hh:mm:ss):");
			 String timeEnd = sc.nextLine();
			 DateTimeFormatter endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 LocalDateTime endTime = LocalDateTime.parse(timeEnd, endFormatter);
			
			 
			 System.out.println("Enter The Fare");
			 Double fare=sc.nextDouble();
			 
			 Bike bike=new Bike(number,name,brand,location,category,startDate,endDate,startTime,endTime,fare);
			 rentalService.addBike(bike);
			 break;
			 
		 case 2:
			 System.out.println("Enter bike number to delete");
			 number=sc.nextLine();
			 rentalService.deleteBike(number);
			 System.out.println("Bike deleted successfully");
			 break;
			 
		 case 3:
			     System.out.println("Get by bikeNumber");
		    	 number=sc.nextLine();
		    	 System.out.println(rentalService.getById(number));
		    	break;
		    	
		 case 4: 
			 
			 List<Bike> bikes=rentalService.getAllBikes();
			 System.out.println("Get All Bikes");
	        	bikes.forEach(System.out::println);
	            break;
		 case 5:
			    System.out.println("Update fare ");
		    	System.out.println("Enter bike Number");
		    	number=sc.nextLine();
		    	System.out.println("Enter fare");
		         fare=sc.nextDouble();
		    	rentalService.updateBike(number, fare);
		    	System.out.println("Updated");
		    	break;
		    	
		 case 6:
			 System.out.println("Enter the Category- Gear/Gearless");
			 category=sc.nextLine();
			  bikes=rentalService.getByCategory(category);
			 System.out.println("The bikes based on Category are :");
			 bikes.forEach(System.out::println);
			 break;
			 
		 case 7:
			 System.out.println("Enter the Category- Gear/Gearless");
			 category=sc.nextLine();
			 System.out.println("Enter the fare");
			 fare=sc.nextDouble();
			 bikes=rentalService.getByCategoryandFare(category, fare);
			 System.out.println("The bikes based on Category and Fare are :");
			 bikes.forEach(System.out::println);
			 break;
			 
		 case 8:
			 System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
			 timeStart  = sc.nextLine(); 
			 startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 startTime = LocalDateTime.parse(timeStart ,startFormatter );
			 
			 System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
			 timeEnd = sc.nextLine(); 
			 endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 endTime= LocalDateTime.parse(timeEnd,endFormatter);
			
			 System.out.println("Enter the location");
			 location=sc.nextLine();
			 

			 bikes = rentalService.getByTimeAndLocation(startTime,endTime,location);
			   System.out.println("Bike list based on timings and Location");
			   bikes.forEach(System.out::println);
			   break;
			   
		 case 9:
			 System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
			 timeStart  = sc.nextLine(); 
			 startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 startTime = LocalDateTime.parse(timeStart ,startFormatter );
			 
			 System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
			 timeEnd = sc.nextLine(); 
			 endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 endTime= LocalDateTime.parse(timeEnd,endFormatter);
				
		     System.out.println("Enter the category");
		      category=sc.nextLine();
				 

				bikes = rentalService.getByTimeAndCategory(startTime,endTime,category);
				   System.out.println("Bike list based on timings and Category");
				   bikes.forEach(System.out::println);
				   break;
		 case 10:
		 
			 System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
			 timeStart  = sc.nextLine(); 
			 startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 startTime = LocalDateTime.parse(timeStart ,startFormatter );
			 
			 System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
			 timeEnd = sc.nextLine(); 
			 endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			 endTime= LocalDateTime.parse(timeEnd,endFormatter);
			 
				 bikes= rentalService.getByDuration(startTime,endTime);
				   System.out.println("Bike list based on timings");
				   bikes.forEach(System.out::println);
				   break;
		 }
		 sc.close();

	}

}
