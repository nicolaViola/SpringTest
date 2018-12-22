package it.servicies;

import java.util.List;

import it.model.Elemento;

public interface JpaService {
	
	public void saveElemento(Elemento elemento);
	
	public List<Elemento> getAllElemento();
	
	public List<Elemento> findElementoByNomeLike(String like);

}
