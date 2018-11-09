package it.servicies.impl;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import it.servicies.ITrackerService;

@Service
public class TrackerService implements ITrackerService{

	@Override
	//@Secured(value={"ROLE_USER"})
	@RolesAllowed(value={"ROLE_USER"})
	public void getDataStream() {
		System.out.println("Questo è un flusso di dati");
		
	}

	@Override
	@Secured(value={"ROLE_USER"})
	public void getDataStream2() {
		System.out.println("Questo è un flusso di dati2");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	public void getDataStreamPreAuthorize() {
		System.out.println("Questo è un flusso di getDataStreamPreAuthorize");
		
	}

}
