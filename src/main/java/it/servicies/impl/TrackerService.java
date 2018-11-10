package it.servicies.impl;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import it.servicies.ITrackerService;

@Service
public class TrackerService implements ITrackerService{

	@Override
	@RolesAllowed(value={"ROLE_USER"})
	public void getDataStream() {
		System.out.println("Questo è un flusso di dati");
		
	}

	@Override
	@Secured(value={"ROLE_USER"})
	public void getDataStream2() {
		System.out.println("Questo è un flusso di dati2");
	}

	@Override
	@PreAuthorize("hasRole('ROLE_USER') and principal.username=='pippo'")
	public void getDataStreamPreAuthorize() {
		System.out.println("Questo è un flusso di getDataStreamPreAuthorize");
		
	}
	
	@Override
	@PostAuthorize("hasRole('ROLE_USER') and returnObject == 'ok'")
	public String getDataStreamPostAuthorize() {
		System.out.println("Questo è un flusso di getDataStreamPostAuthorize");
		return "ok";
	}

}
