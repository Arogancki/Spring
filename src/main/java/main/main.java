package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import vehicle.Car;
import vehicle.CarDao;
import vehicle.Engine;

public class main{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Car car = (Car) context.getBean("car");
		CarDao cd = (CarDao) context.getBean("CarDao");
		cd.Add((Car) context.getBean("car"));
		/*
		// 1.8
		cd.GetAll().forEach((obj) -> {
			obj.go(500);
		});
		*/
		for (Car obj : cd.GetAll()){
			obj.go(5000);
			System.out.println("Deleting obj:");
			cd.DeleteCar(obj.getMake(), obj.getEngine().getPower(), obj.getEngine().getType());
		}
		
	}
}