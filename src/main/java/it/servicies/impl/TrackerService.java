package it.servicies.impl;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import it.servicies.ITrackerService;

@Service
public class TrackerService implements ITrackerService{

	@Override
	@Secured(value={"ROLE_USER"})
	public void getDataStream() {
		System.out.println("Questo è un flusso di dati");
		
	}

}
