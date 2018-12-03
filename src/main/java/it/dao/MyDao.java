package it.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.model.Persona;


@Repository
public class MyDao implements IMyDao{
	
	@Autowired
	private JdbcTemplate myJdbcTemplate;

	@Override
	public void create(Collection<Persona> people) {
		
		
		// TODO Auto-generated method stub
		
	}

}
