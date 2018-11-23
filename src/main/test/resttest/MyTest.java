package resttest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import it.model.MyData;

public class MyTest {

	@Test
	public void test_execute() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/SpringTest/rest/test2/xxx";
		
		MyData data = restTemplate.execute(uri, HttpMethod.GET, new RequestCallback() {
			
			@Override
			public void doWithRequest(ClientHttpRequest request) throws IOException {
				HttpHeaders header = new HttpHeaders();
				header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
				System.out.println("header" + header);
			}
		}, new HttpMessageConverterExtractor<MyData>(MyData.class, restTemplate.getMessageConverters()), new HashMap<String, Object>(){{put("owner","xxx");}});

		System.out.println(data.getOwner() + "  " + data.getComment());
	}

	@Test
	public void test_exchange() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/SpringTest/rest/test2/xxx";
		
		MyData data = new MyData("nicola", "exchange with PUT");
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON_UTF8);
		final HttpEntity<MyData> dataRequest = new HttpEntity<>(data, header);
		
		ResponseEntity<MyData> result = restTemplate.exchange(uri, HttpMethod.PUT, dataRequest,MyData.class, "nicola");
		
		MyData mm = result.getBody();
		System.out.println(mm.getOwner() + "  " + mm.getComment());
	}
	
	@Test
	public void test_get() {
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/SpringTest/rest/testObject/{userName}";
		MyData myData = restTemplate.getForObject(url, MyData.class, "pippo");
		ResponseEntity<MyData> responseEntity = restTemplate.getForEntity(url, MyData.class, "pippo");
		
		Date lastModifiedDate = new Date(responseEntity.getHeaders().getLastModified());
		List<MediaType> mediaTipies = responseEntity.getHeaders().getAccept();
		System.out.println(responseEntity.getStatusCode()+ " " + responseEntity.getBody().getOwner() + " " + responseEntity.getBody().getComment());

		
		URI uri = URI.create("http://localhost:8081/SpringTest/rest/testObject/ciccio");
		MyData myData2 = restTemplate.getForObject(uri, MyData.class);
		
		System.out.println(myData2.getOwner() + "  " + myData2.getComment());
		
		
		
			}
	
	@Test
	public void test_post() {
		String url = "http://localhost:8081/SpringTest/rest/testObject/xxx";
		RestTemplate restTemplate = new RestTemplate();
		MyData myData = new MyData("pippo", "franco");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MyData> request = new HttpEntity<>(myData, headers);
		
		URI uri = restTemplate.postForLocation(url, request);
		System.out.println(uri);
		
		MyData myDataResult = restTemplate.postForObject(url, request, MyData.class);
		System.out.println(myDataResult);
		
		 restTemplate.put("http://localhost:8081/SpringTest/rest/test2/{userName}", myDataResult, "ecco");
		 System.out.println(myDataResult);
	}
	
}
