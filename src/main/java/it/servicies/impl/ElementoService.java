package it.servicies.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.model.Elemento;
import it.repo.AutomaticRepo;
import it.servicies.JpaService;

@Service
public class ElementoService implements JpaService{
	
	
	@Autowired
	private AutomaticRepo automaticRepo;
	
//	@PersistenceContext
//    private EntityManager entityManager;

	@Override
	public void saveElemento(Elemento elemento) {
		automaticRepo.save(elemento);
	}

	@Override
	public List<Elemento> getAllElemento() {
		return automaticRepo.findAll();
	}

	@Override
	public List<Elemento> findElementoByNomeLike(String like) {
		return automaticRepo.findElementoByNomeLike(like);
	}

}
