package it.dao;

import java.util.Collection;

import it.model.Persona;
import it.servicies.test.IPerson;

public interface IMyDao {

	public void create(Collection<Persona> people);
}
