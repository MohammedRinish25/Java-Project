package com.bikerental.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.bikerental.model.Bike;
import com.bikerental.model.User;
import com.bikerental.service.BikeServiceImpl;
import com.bikerental.service.BookingServiceImpl;
import com.bikerental.service.IBikeService;
import com.bikerental.service.IBookingService;
import com.bikerental.service.IUserService;
import com.bikerental.service.UserServiceImpl;

public class BikeMain {

	public static void main(String[] args) {

		System.out.println("Welcome to Bike Rental Application ");
		Scanner sc = new Scanner(System.in);
		IBikeService rentalService = new BikeServiceImpl();
		IUserService userService = new UserServiceImpl();
		IBookingService bookingService=new BookingServiceImpl();

		System.out.println("1.Register\n2.Login");
		int role = sc.nextInt();
		sc.nextLine();
		if (role == 1) {
			User user = new User();
			
			System.out.println("Enter your Name"); 
			String username = sc.nextLine();
			user.setName(username); 
			
			System.out.println("Enter your Mobile No"); long
			mobile = sc.nextLong(); sc.nextLine(); 
			user.setMobileNumber(mobile);
			
			System.out.println("Enter city"); 
			String city = sc.nextLine();
			user.setCity(city); 
			
			user.setType("user");
			
			System.out.println("Enter UserName "); 
			String userName = sc.nextLine();
			user.setUsername(userName); 
			
			System.out.println(userService.register(user));
			
		} else if (role == 2) {
			User user = null;
			System.out.println("Enter your userName");
			String userName = sc.nextLine();
			System.out.println("Enter your password");
			String password = sc.nextLine();
			user = userService.login(userName, password);
			String type = user.getType();

			switch (type) {
			case "admin": {

				System.out.println("Enter your choice\n" + "1.Add a Bike\n" + "2.Delete a Bike\n"
						+ "3.Get By bike Number\n" + "4.Update Bike fare \n");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter The Bike Number");
					String number = sc.nextLine();

					System.out.println("Enter The Bike Name");
					String name = sc.nextLine();

					System.out.println("Enter The Brand Name");
					String brand = sc.nextLine();

					System.out.println("Enter The Location");
					String location = sc.nextLine();

					System.out.println("Enter The Category");
					String category = sc.nextLine();

					System.out.println("Enter the Start Date");
					String start = sc.nextLine();
					LocalDate startDate = LocalDate.parse(start);

					System.out.println("Enter the End Date");
					String end = sc.nextLine();
					LocalDate endDate = LocalDate.parse(end);

					System.out.println("Enter Start Date&Time(yyyy-mm-dd hh:mm):");
					String timeStart = sc.nextLine();
					DateTimeFormatter startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime startTime = LocalDateTime.parse(timeStart, startFormatter);

					System.out.println("Enter End Date&Time(yyyy-mm-dd hh:mm:ss):");
					String timeEnd = sc.nextLine();
					DateTimeFormatter endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime endTime = LocalDateTime.parse(timeEnd, endFormatter);

					System.out.println("Enter The Fare");
					Double fare = sc.nextDouble();

					Bike bike = new Bike(number, name, brand, location, category, startDate, endDate, startTime,
							endTime, fare);
					rentalService.addBike(bike);
					break;

				case 2:
					System.out.println("Enter bike number to delete");
					number = sc.nextLine();
					rentalService.deleteBike(number);
					System.out.println("Bike deleted successfully");
					break;

				case 3:
					System.out.println("Get by bikeNumber");
					number = sc.nextLine();
					System.out.println(rentalService.getById(number));
					break;

				case 5:
					System.out.println("Update fare ");
					System.out.println("Enter bike Number");
					number = sc.nextLine();
					System.out.println("Enter fare");
					fare = sc.nextDouble();
					rentalService.updateBike(number, fare);
					System.out.println("Updated");
					break;

				default:
					System.out.println("Invalid Choice");
				}
				break;
			}
			case "user": {
				List<Bike> bikes = null;
				System.out.println("1.Get All Bikes\n" + "2.Get Bike based On category\n"
						+ "3.Get Bike based On Category and Fare\n" + "4.Get Bike based On Timings and Location\n"
						+ "5.Get Bike based On Timings and Category\n" + "6.Get Bike based On Duration"+"7.Booking");

				int select = sc.nextInt();
				sc.nextLine();
				switch (select) {
				case 1:

					bikes = rentalService.getAllBikes();
					System.out.println("All Bikes List");
					bikes.forEach(System.out::println);
					break;
				case 2:

					System.out.println("Enter the Category- Gear/Gearless");
					String category = sc.nextLine();
					bikes = rentalService.getByCategory(category);
					// sc.nextLine();
					System.out.println("The bikes based on Category are :");
					bikes.forEach(System.out::println);
					break;

				case 3:
					System.out.println("Enter the Category- Gear/Gearless");
					category = sc.nextLine();
					System.out.println("Enter the fare");
					double fare = sc.nextDouble();
					bikes = rentalService.getByCategoryandFare(category, fare);
					System.out.println("The bikes based on Category and Fare are :");
					bikes.forEach(System.out::println);
					break;

				case 4:
					System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
					String timeStart = sc.nextLine();
					DateTimeFormatter startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime startTime = LocalDateTime.parse(timeStart, startFormatter);

					System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
					String timeEnd = sc.nextLine();
					DateTimeFormatter endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime endTime = LocalDateTime.parse(timeEnd, endFormatter);

					System.out.println("Enter the location");
					String location = sc.nextLine();

					bikes = rentalService.getByTimeAndLocation(startTime, endTime, location);
					System.out.println("Bike list based on timings and Location");
					bikes.forEach(System.out::println);
					break;

				case 5:
					System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
					timeStart = sc.nextLine();
					startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					startTime = LocalDateTime.parse(timeStart, startFormatter);

					System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
					timeEnd = sc.nextLine();
					endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					endTime = LocalDateTime.parse(timeEnd, endFormatter);

					System.out.println("Enter the category");
					category = sc.nextLine();

					bikes = rentalService.getByTimeAndCategory(startTime, endTime, category);
					System.out.println("Bike list based on timings and Category");
					bikes.forEach(System.out::println);
					break;
				case 6:

					System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
					timeStart = sc.nextLine();
					startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					startTime = LocalDateTime.parse(timeStart, startFormatter);

					System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
					timeEnd = sc.nextLine();
					endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					endTime = LocalDateTime.parse(timeEnd, endFormatter);

					bikes = rentalService.getByDuration(startTime, endTime);
					System.out.println("Bike list based on timings");
					bikes.forEach(System.out::println);
					break;
					
				case 7:
					System.out.println("Please Enter here to book a Bike");
					System.out.println("Please enter the Start date and Time in yyyy-MM-dd HH:mm format");
					timeStart = sc.nextLine();
					startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					startTime = LocalDateTime.parse(timeStart, startFormatter);

					System.out.println("Please enter the End date and Time in yyyy-MM-dd HH:mm format");
					timeEnd = sc.nextLine();
					endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					endTime = LocalDateTime.parse(timeEnd, endFormatter);
					
					 System.out.println("Enter the Category- Gear/Gearless");
				     category = sc.nextLine();
				     
				     user=new User();
				     
				    Bike bike=bookingService.booking(startTime, endTime, category);
				    bookingService.updateAvailability(bike.getBikeNumber());
				    System.out.println(bike);
				    break;
				default:
					System.out.println("Invalid Choce");
				}
				break;
			}
			default:
				System.out.println("Invalid Option");

				sc.close();

			}
		} else {
			System.out.println("Incorrect input");
		}
	}
}
