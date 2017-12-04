package vehicle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	public int getPower() {
		return power;
	}
	public Engine setPower(int power) {
		this.power = power;
		return this;
	}
	public double getCapacity() {
		return capacity;
	}
	public Engine setCapacity(float capacity) {
		this.capacity = capacity;
		return this;
	}
	public String getType() {
		return type;
	}
	public Engine setType(String type) {
		this.type = type;
		return this;
	}
	@Value("${capacity}")
	int power = 0;
	@Value("#{T(java.lang.Math).PI}")
	double capacity = .0f;
	String type = "Not specified";
	public Engine(){}
	public Engine(String type, int power, float capacity){
		this.type=type;
		this.power=power;
		this.capacity=capacity;
	}
	void start() {
		System.out.println("Starting "+this.getType()+" engine: "+this.getPower()+"KM/"+this.getCapacity()+"l.");
	}
}
	
