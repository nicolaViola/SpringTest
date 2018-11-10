package it.servicies.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import it.model.MyData;
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
	
	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostFilter("filterObject.owner == principal.username")
	public Collection<MyData> getMyDataPostFilterd() {
		System.out.println("Questi sono i miei dai");
		Collection<MyData> data = new ArrayList<>();
		data.add(new MyData("pippo", "ciao sono pippo"));
		data.add(new MyData("pippo", "oggi c'è il sole"));
		
		data.add(new MyData("pippo2", "ciao sono pippo2"));
		
		return data;
	}
	
	
	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	@PreFilter("filterObject.owner != principal.username")
	public Collection<MyData> getMyDataPreFileterd(Collection<MyData> data) {
		return data;
	}

}
