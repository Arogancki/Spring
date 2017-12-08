package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import vehicle.Car;
import vehicle.CarDao;
import vehicle.CarOrmDao;
import vehicle.Engine;

public class main{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		CarOrmDao cd = (CarOrmDao) context.getBean("carOrmDao");
		
		
		Car y = new Car("Audi");
		cd.save(y);
		System.out.print("zapisano w bazie\n");
		for (Car x : cd.findAll()){
			System.out.println("Z bazy marka: "+x.getMake());
		}																													                                                    System.out.println("Z bazy marka: "+y.getMake());
		System.out.println("koniec");
		/*
		// 1.8
		cd.GetAll().forEach((obj) -> {
			obj.go(500);
		});
		*/	
	}
}