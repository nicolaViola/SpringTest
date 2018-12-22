package it.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.model.Elemento;

public interface AutomaticRepo extends JpaRepository<Elemento, Long>{
	
	public List<Elemento> findElementoByNomeLike(String p);

}
