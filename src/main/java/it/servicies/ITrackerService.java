package it.servicies;

import java.util.Collection;
import java.util.List;

import it.model.MyData;

public interface ITrackerService {
	
	public void getDataStream();
	public void getDataStream2();
	
	public void getDataStreamPreAuthorize();
	public String getDataStreamPostAuthorize();

	public Collection<MyData> getMyDataPostFilterd();
	public Collection<MyData> getMyDataPreFileterd(Collection<MyData> data);
}
