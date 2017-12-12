package com.codenotfound.ws.client;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@XmlRootElement(name = "Car")
public class Car{
	//Engine engine = new Engine();
	public String make = "car";
	public String type = "";
	public int power = 0;
	public float capacity = 0.0;
	public Car(){
		//this.engine = new Engine();
	}
	public Car(String make){
		this.setMake(make);
	}
	public Car(String make, float capacity, int power, String type){
		this.capacity = capacity;
		this.type = type;
		this.power = power;
		this.setMake(make);
	}
	public String getMake() {
		return make;
	}
	public Car setMake(String make) {
		this.make = make;
		return this;
	}
	public void go(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
		System.out.println(this.getMake() + " going.");
	}
}
	
