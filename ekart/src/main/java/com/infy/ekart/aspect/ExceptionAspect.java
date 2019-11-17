package com.infy.ekart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {
	
	/*@Around("execution(* com.infosys.service.EmployeeService.add*(..))")  
    public Object logAfterAdvice(ProceedingJoinPoint joinPoint) {                      
          System.out.println("Around Before Joinpoint signature :" + joinPoint.getSignature());
          Object ret = null;
          try {
			ret = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("exc = " + e.getMessage());
		}
          System.out.println("Around After Returned value :" + ret);
          return ret;
	}
	
	@AfterReturning(pointcut="execution(* com.infosys.service.EmployeeService.getEmployee(..))", returning="e1")  
    public void logAfterReturningAdvice(Employee e1 ){            
          //Log Joinpoint signature details          
          //System.out.println("Before Joinpoint signature :" + joinPoint.getSignature());
          //long time = System.currentTimeMillis();               
          //Log details such as time stamp of report generated
          //System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
          System.out.println("Accessing returned value of getEmployee in AfterReturning Aspect, Employee Id = " + e1.getEmpId());
	}*/
	
	/*@Around("execution(* com.infy.ekart.controller.AddressController.viewAddress(..))")  
    public Object handleControllerExceptions( ProceedingJoinPoint joinPoint){            
          
          System.out.println("111111111111111111111111111");
          Object ret = null;
          try {
  			ret = joinPoint.proceed();
  		} catch (Throwable e) {
  			// TODO Auto-generated catch block
  			System.out.println("exc = " + e.getMessage());
  		}
          System.out.println("Around After Returned value :" + ret);
          return ret;
	}*/
	
	
}
