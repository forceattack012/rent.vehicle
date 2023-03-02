package com.xcompany.rent.vehicle;

import com.xcompany.rent.vehicle.entity.*;
import com.xcompany.rent.vehicle.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private static Logger logger = Logger.getLogger(Application.class.getName());
	@Autowired
	private RentalCarRepository rentalCarRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private CarRepository carRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("------------ Test Running -------------------");

//		Car car = new Car();
//		car.setName("test");
//		car.setPrice(1000.2111);
//		carRepository.save(car);

//		Customer customer = new Customer();
//		customer.setName("ab");
//		customer.setBirthDate(LocalDateTime.now());
//		customer.setLastName("ab");
//		customer.setCitizenId("122233");
//		customerRepository.save(customer);
//
//		Driver driver = new Driver();
//		driver.setName("driver");
//		driver.setLastName("s");
//		driver.setCitizenId("11");
//		driver.setLicenseId("1");
//		driver.setLicenseExpire(LocalDateTime.now());
//		driver.setBirthDate(LocalDateTime.now());
//		driverRepository.save(driver);

//		var car = carRepository.findById(1L);
//		var cust = customerRepository.findById(1L);
//		LocalDateTime today = LocalDateTime.now();
//		for(int i=0; i<2; i++){
//			RentalCar rental = new RentalCar();
//			rental.setCustomer(cust.get());
//			rental.setCar(car.get());
//			rental.setStartDate(today);
//			rental.setEndDate(today.plusHours(2));
//			rental.setTotalAmount(1000.00);
//			rentalCarRepository.save(rental);
//		}
	}
}
