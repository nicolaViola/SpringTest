package it.client;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;


import it.model.MyData;

public class RestClient {

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();

//		String uri = "http://localhost:8081/SpringTest/rest/test/{userName}";
//		MyData myData = restTemplate.getForObject(uri, MyData.class, "ciccio");
//		System.out.println(myData.getOwner());
//		System.out.println(myData.getComment());
		
		
//		String url = "http://localhost:8081/SpringTest/rest/test/nicola";
//		MyData myData2 = restTemplate.getForObject(url, MyData.class);
//		System.out.println(myData2.getOwner());
//		System.out.println(myData2.getComment());
		
		
//		Map<String, Object> dataMap = new HashMap<>();
//		MyData myData = restTemplate.execute(url, HttpMethod.GET, new RequestCallback() {
//			@Override
//			public void doWithRequest(ClientHttpRequest request) throws IOException {
//				System.out.println("url " + request.getURI().toString());
//				HttpHeaders headers = request.getHeaders();
//				headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
//				System.out.println("eccomi");
//			}
//		}, new HttpMessageConverterExtractor<MyData>(MyData.class, restTemplate.getMessageConverters()),dataMap);
//		System.out.println(myData.getOwner());
//		System.out.println(myData.getComment()); 
		
//		String uri = "http://localhost:8081/SpringTest/rest/test2/{userName}";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//		MyData d = new MyData("zio", "ciao");
//		HttpEntity<MyData> userRequest = new HttpEntity<>(d, headers);
//		ResponseEntity<MyData> myResponse = restTemplate.exchange(uri, HttpMethod.GET, userRequest, MyData.class, "ww");
//		System.out.println(myResponse.getBody());
		
		String uri = "http://localhost:8081/SpringTest/rest/test3";
		MyData d = new MyData("zio", "ciao");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MyData> userRequest = new HttpEntity<>(d, headers);
		URI newUri = restTemplate.postForLocation(uri, userRequest,MyData.class);
		System.out.println(newUri.toString());
	}
	
}