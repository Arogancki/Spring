package com.codenotfound.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class carClient {

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  public Car carOut(Car car) {
		webServiceTemplate.marshalSendAndReceive(car);
	    return car
	  }
  
  public Car carIn(Car car) {
	  System.out.println("mam: "+car.getMake());
	    return car;
	  }
}
