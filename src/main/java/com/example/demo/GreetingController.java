package com.example.demo;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Greeting;

@RestController
public class GreetingController {

	static private CarDao cd = (CarDao) new ClassPathXmlApplicationContext("context.xml").getBean("CarDao");
    private static final String template = "{Car.make: %s, Car.engine.capacity: %f, "
    		+ "Car.engine.power: %d, Car.engine.type: %s}";
    
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public Greeting get(@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="power", required=true) int power,
    		@RequestParam(value="type", required=true) String type)
    {
    	try{
    	Car x = cd.Get(name, power, type);
    	if (!x.getMake().equalsIgnoreCase("NULL"))
            return new Greeting(counter.incrementAndGet(),
                                String.format(template, x.getMake(), x.getEngine().capacity,
                                		x.getEngine().getPower(), x.getEngine().getType()));
        	else
        		 return new Greeting(counter.incrementAndGet(), "Not found in db.");
    	}
    	catch (org.springframework.dao.IncorrectResultSizeDataAccessException e){
    		List<Car> list =  cd.GetFew(name, power, type);
    		String s = "{ ";
    		int count=0;
    		for (Car x : list){
    			if (count!=0){
    				s += ", ";
    			}
    			s += "car" + ++count + " :" +String.format(template, x.getMake(), x.getEngine().capacity,
                		x.getEngine().getPower(), x.getEngine().getType());
    		}
    		s+=" }";
    		return new Greeting(counter.incrementAndGet(), s);
    	}
    }
    
    @RequestMapping(value="/test",method = RequestMethod.POST)
    public Greeting post(@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="power", required=true) int power,
    		@RequestParam(value="type", required=true) String type,
    		@RequestParam(value="capacity", required=true) float capacity)
    {
    	cd.Add(new Car(name,capacity,power,type));
    	return new Greeting(counter.incrementAndGet(), "Done");
    }
    
    @RequestMapping(value="/test",method = RequestMethod.DELETE)
    public Greeting delete(@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="power", required=true) int power,
    		@RequestParam(value="type", required=true) String type)
    {
    	cd.DeleteCar(name, power, type);
    	return new Greeting(counter.incrementAndGet(), "Done");
    }
    
}
