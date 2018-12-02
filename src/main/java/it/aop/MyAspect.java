package it.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import it.servicies.test.Padre;
import it.servicies.test.Tester;

@Aspect
@Component
public class MyAspect {
	
	

//	@Before("execution(* *.getRandomNumber())")
//	public void xxx(JoinPoint jp) throws Throwable{
//		
//		//System.out.println("sss ");
//		throw new RuntimeException();
//	}
	
//	@AfterReturning(pointcut= "execution(* *.getRandomNumber())", returning = "retruningValue")
//	public void xxx(JoinPoint jp, int retruningValue){
//		System.out.println("sss " + retruningValue);
//	}
	
//	@AfterThrowing(pointcut= "execution(* *.getRandomNumber())", throwing = "exceptionValue")
//	public void xxx(JoinPoint jp, RuntimeException exceptionValue){
//		System.out.println("sss " + exceptionValue.getMessage());
//	}
	
	
//	@After("execution(* *.getRandomNumber())")
//	public void xxx(JoinPoint jp) throws Throwable{
//		
//		System.out.println("sia che va bene che va male ");
//		
//	}
	
	
//	@Around("execution(* *.getRandomNumber()) || execution(* *.otherMethod())") 
//	public int xxx(ProceedingJoinPoint pjp) throws Throwable{
//		System.out.println("prima");
//		try{
//			Integer i = (Integer)pjp.proceed();
//			
//			System.out.println("dopo");
//			return i;
//		}catch(RuntimeException e){
//			System.out.println("scoppi");
//			return 0;
//		}
//		
//	}
	
	@Around("execution(** *..*.*(..) throws Exception) and within(*..*) and (this(it.servicies.test.Tester) or this(it.servicies.test.IPadre))") 
	public int xxx(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi");
			return 0;
		}
		
	}
	
	@Around("target(it.servicies.test.IPadre)") 
	public int xxx2(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima2");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo2");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi2");
			return 0;
		}
		
	}
	
	@Around("this(it.servicies.test.Tester)") 
	public int xxx3(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima3");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo3");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi3");
			return 0;
		}
		
	}
	
	@Around("args(*)") 
	public int xxx4(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima4");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo4");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi4");
			return 0;
		}
		
	}
	
	@Around("@target(org.springframework.stereotype.Component)") 
	public int xxx5(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima5");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo5");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi5");
			return 0;
		}
		
	}
	
	@Around("@args(it.servicies.test.Nicola)") 
	public int xxx6(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima6");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo6");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi6");
			return 0;
		}
		
	}
	
	@Around("@within(it.servicies.test.Nicola)") 
	public int xxx7(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima7");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo7");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi7");
			return 0;
		}
		
	}
	
	@Around("@annotation(it.servicies.test.NicolaMethod)") 
	public int xxx8(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima8");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo8");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi8");
			return 0;
		}
		
	}
	
	@Around("bean(*)") 
	public int xxx9(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("prima9");
		try{
			Integer i = (Integer)pjp.proceed();
			
			System.out.println("dopo9");
			return i;
		}catch(RuntimeException e){
			System.out.println("scoppi9");
			return 0;
		}
		
	}
	
	
	@Before("@annotation(it.servicies.test.NicolaMethod)") 
	public int xxx10(JoinPoint jp) throws Throwable{
		try {
			
			System.out.println(jp.getKind());
			
			Signature sign = jp.getSignature();
			
			Object th1 = jp.getThis();
			
			
			Object obj = jp.getTarget();
			
			Tester obj2 = (Tester) jp.getTarget();
			
			System.out.println(obj);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	@Before("execution(** *..*.*(..) throws Exception)") 
	public int xxx11(JoinPoint jp) throws Throwable{
		try {
			
			System.out.println(jp.getKind());
			
			Signature sign = jp.getSignature();
			
			Object th1 = jp.getThis();
			
			
			Object obj = jp.getTarget();
			
			Tester obj2 = (Tester) jp.getTarget();
			
			System.out.println(obj);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	@Around("@annotation(it.servicies.test.NicolaMethod)") 
	public int xxx10(ProceedingJoinPoint pjp) throws Throwable{
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
}
