package vehicle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;

@Aspect
public class Profiler {
	
	@Around("execution(* Car.go(..)) && args(time)")
	//throwing= "error")
	public void calculateTime(ProceedingJoinPoint joinPoint, int time) throws Throwable{
		System.out.println("Aspect starts.");
		long start = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long stop = System.currentTimeMillis();
		System.out.println("time: "+String.valueOf(stop-start) + ", przejechane : " + time);
	}
}
