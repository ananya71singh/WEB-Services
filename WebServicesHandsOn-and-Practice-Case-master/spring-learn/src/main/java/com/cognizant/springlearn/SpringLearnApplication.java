package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		try {
			displayDate();
			displayCountry();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void displayCountry()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCoutry=(Country)context.getBean("country",Country.class);
		LOGGER.info("START");
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("END");
	}
	public static void displayDate() throws ParseException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format =context.getBean("dateFormat", SimpleDateFormat.class);
		Date date=format.parse("31/12/2018");
		LOGGER.info("START");
		LOGGER.debug("date  : ------------",date);
		LOGGER.info("END");

}
}
