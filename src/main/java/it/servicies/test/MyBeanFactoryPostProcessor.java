package it.servicies.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered{
//	@Autowired
//	private Padre x;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
//		Padre p = beanFactory.getBean(Padre.class);
//		p.setNome("ee");
//		
//		Figlio f = beanFactory.getBean(Figlio.class);
//		
//		for(String name : beanFactory.getBeanDefinitionNames()){
//			
//			System.out.println("name " + name);
//		}
		System.out.println("s");
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
