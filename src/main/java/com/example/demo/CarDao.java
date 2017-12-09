package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarDao {
	 private DataSource dataSource;
	 private JdbcTemplate jdbcTemplateObject;
	 
	 public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	} 
	 
	public void Add(Car car){
		String SQL = "insert into cars (make, capacity, power, type) values (?, ?, ?, ?)";
		try{
	    jdbcTemplateObject.update( SQL, car.getMake(), 
	    		car.getEngine().getCapacity(),
	    		car.getEngine().getPower(),
	    		car.getEngine().getType());
	    System.out.println("Record created");
		}
		catch(Exception e){}
	    return;
	}
	public Car Get(String make, int power, String type){
		try {
		 String SQL = "select * from cars where make = ? AND power = ? AND type = ?";
	      Car car = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{make, power, type}, new CarMapper());
	      return car;
		}
		catch (org.springframework.dao.EmptyResultDataAccessException e){
			return new Car("NULL");
		}
	}
	public List<Car> GetFew(String make, int power, String type){
		 String SQL =  "select * from cars where make = '"+make+"' AND power = "+power+" AND type = '"+type+"'";
	      return jdbcTemplateObject.query(SQL, new CarMapper());
		}
	public List<Car> GetAll(){
		try {
		String SQL = "select * from cars";
	      return jdbcTemplateObject.query(SQL, new CarMapper());
		}
		catch (org.springframework.dao.EmptyResultDataAccessException e){
			 List<Car> x = new ArrayList();
			return x;
		}
	}
	public void DeleteCar(String make, int power, String type){
		String SQL = "delete from cars where make = ? AND power = ? AND type = ?";
	    jdbcTemplateObject.update(SQL, make, power, type);
	    System.out.println("Record deleted");
	    return;
	}
}
