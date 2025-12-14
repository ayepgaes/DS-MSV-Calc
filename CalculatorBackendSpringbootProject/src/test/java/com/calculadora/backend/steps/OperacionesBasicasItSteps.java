/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.calculadora.backend.steps;

import com.calculadora.backend.CucumberSpringConfiguration;
import com.calculadora.backend.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author usuario
 */

public class OperacionesBasicasItSteps extends CucumberSpringConfiguration {
    @Autowired
    private ScenarioContext backpack;
    @Autowired
    RestTemplate restTemplate;
    //Port
    @Value("${server.port}")
    private String port;
    
    //Call to the endpoint (POST)
    @When("the client calls {string}")
    public void WhenTheClientCalls(String call) {
        
        //Url
        String usrUrl = "http://localhost:"+port+call;
        
        //Body
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        Map<String,Double> peticion = new HashMap();
        peticion.put("a",a);
        peticion.put("b",b);
        
        //Response Handling & Exception Handling
        try{
            ResponseEntity<String> dataResponse = restTemplate.postForEntity(usrUrl, peticion, String.class);
            backpack.put("status", dataResponse.getStatusCode().value());
            backpack.put("response", dataResponse.getBody());
        }
        catch (HttpClientErrorException | HttpServerErrorException e){
            backpack.put("status", e.getStatusCode().value());
            backpack.put("response", "");
        }
        
        
    }
    
    //Status code
    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer correct_code) {
        int status = (int) backpack.get("status");
        assert(status == correct_code);
    }
    
    //Response body
    @Then("the client receives result = {double}")
    public void the_client_receives_result(Double c) {
        String dataResponse = (String) backpack.get("response");
        //It should return a JSON with this structure
        assert(("{\"result\":"+c+"}").equals(dataResponse));
    }
}
