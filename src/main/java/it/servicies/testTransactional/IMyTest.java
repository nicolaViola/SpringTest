package it.servicies.testTransactional;

import java.util.Collection;

import it.model.Persona;
import it.servicies.test.IPerson;

public interface IMyTest {
	
	public void create(Collection<Persona> people);

}
