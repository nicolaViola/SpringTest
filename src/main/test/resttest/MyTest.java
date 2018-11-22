package resttest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

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
		String url = "http://localhost:8081/SpringTest/rest/testObject/xxxx";
		RestTemplate restTemplate = new RestTemplate();
		MyData myData = restTemplate.getForObject(url, MyData.class);
		System.out.println(myData.getOwner() + "  " + myData.getComment());
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
	}
	
}
