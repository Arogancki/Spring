package vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car{
	//@Autowired
	Engine engine;
	String make = "car";
	public Car(){
		this.engine = new Engine();
	}
	public Car(String make, Engine engine){
		this.setEngine(engine);
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
	public void go() {
		this.getEngine().start();
		System.out.println(this.getMake() + " going.");
	}
}
	
