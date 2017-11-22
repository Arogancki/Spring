package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vehicle.Car;
import vehicle.Engine;

public class main{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Car car = (Car) context.getBean("car");
		car.go(2500);
	}
}