package it.servicies.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(1)
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
				//System.out.println("Dopo: " + beanName);
				return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		
		// TODO Auto-generated method stub
				System.out.println("Prima: " + beanName);
				
//				if(beanName.equals("padre")){
//					Padre dd = new Padre();
//					dd.setNome("cx");
//					return dd;
//				}
				
				return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 2;
	}
}
