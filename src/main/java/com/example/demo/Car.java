package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Car{
	Engine engine = new Engine();
	String make = "car";
	public Car(){
		//this.engine = new Engine();
	}
	public Car(String make){
		this.setMake(make);
	}
	public Car(String make, float capacity, int power, String type){
		this.engine = new Engine(type, power, capacity);
		this.setMake(make);
	}
	public Engine getEngine() {
		return engine;
	}
	public Car setEngine(Engine engine) {
		this.engine = engine;
		return this;
	}
	public String getMake() {
		return make;
	}
	public Car setMake(String make) {
		this.make = make;
		return this;
	}
	public void go(int time) {
		this.getEngine().start();
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
		System.out.println(this.getMake() + " going.");
	}
}
	
