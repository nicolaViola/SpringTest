package it.servicies.testTransactional;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dao.MyDao;
import it.model.Persona;

@Service
public class MyTest implements IMyTest{
	
	@Autowired
	private MyDao dao;

	@Transactional
	@Override
	public void create(Collection<Persona> people) {
		dao.create(people);
	}

}
