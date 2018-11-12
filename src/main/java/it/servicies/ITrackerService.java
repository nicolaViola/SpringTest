package it.servicies;

import java.util.Collection;
import java.util.List;

import it.model.MyData;

public abstract class ITrackerService {
	
	abstract public void getDataStream();
	abstract public void getDataStream2();
	
	abstract public void getDataStreamPreAuthorize();
	abstract public String getDataStreamPostAuthorize();

	abstract public Collection<MyData> getMyDataPostFilterd();
	abstract public Collection<MyData> getMyDataPreFileterd(Collection<MyData> data);
}
