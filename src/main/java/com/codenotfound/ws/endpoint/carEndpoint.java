package com.codenotfound.ws.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class CarEndpoint {

  @PayloadRoot(namespace = "http://codenotfound.com/types/car", localPart = "car")
  @ResponsePayload
  public Car carOut(@RequestPayload Car car) {
    System.out.println("mam: "+car.getMake());
    return car;
  }
  
  public Car carIn(Car car) {
	  webServiceTemplate.marshalSendAndReceive(car);
	    return car
	  }
}

