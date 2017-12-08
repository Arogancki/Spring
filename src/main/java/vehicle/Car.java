package vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CarsOrm")
@Component
public class Car  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	static  public String x(){return "CarsOrm";};
	
	//@Autowired
	//Engine engine;
	@Column
	String make;
	public Car(){
		//this.engine = new Engine();
	}
	public Car(String make){
		this.setMake(make);
	}
	public Car(String make, float capacity, int power, String type){
	//	this.engine = new Engine(type, power, capacity);
		this.setMake(make);
	}
	//public Engine getEngine() {
		//return engine;
	//}
//	public Car setEngine(Engine engine) {
	//	this.engine = engine;
		//return this;
	//}
	public String getMake() {
		return make;
	}
	public Car setMake(String make) {
		this.make = make;
		return this;
	}
	public void go(int time) {
	//	this.getEngine().start();
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
		}
		System.out.println(this.getMake() + " going.");
	}
}
	
