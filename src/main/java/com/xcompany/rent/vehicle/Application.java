package com.xcompany.rent.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
	private static Logger logger = Logger.getLogger(Application.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Bangkok"));
		logger.info(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
	}
}
