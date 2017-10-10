package vehicle;

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
	public float getCapacity() {
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
	int power = 0;
	float capacity = .0f;
	String type = "Not specified";
	public Engine(){}
	public Engine(String type, int power, float capacity){
		this.power = power;
		this.capacity = capacity;
		this.type = type;
	}
	void start() {
		System.out.println("Starting "+this.getType()+" engine: "+this.getPower()+"KM/"+this.getCapacity()+"l.");
	}
}
	
