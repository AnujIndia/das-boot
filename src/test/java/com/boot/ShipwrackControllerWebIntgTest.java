package com.boot;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class ShipwrackControllerWebIntgTest {

	@Test
	public void testAll() throws IOException{
		RestTemplate objRS = new RestTemplate();
		ResponseEntity<String> res = objRS.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
		
		assertThat(res.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objMapper = new ObjectMapper();
		JsonNode resJson = objMapper.readTree(res.getBody());
		
		assertThat(resJson.isMissingNode(), is(false));
		assertThat(resJson.toString(), equalTo("[]"));
		
		
	}
}
