/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.calculadora.backend.steps;


import com.calculadora.backend.CucumberSpringConfiguration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import java.util.HashMap;
import java.util.Map;

@CucumberContextConfiguration
public class OperacionesBasicasSteps extends CucumberSpringConfiguration {
    Map<String,Object> backpack = new HashMap();
    
    @Given("the first number is {double}")
    public void GivenTheFirstNumberIs(double a) {
        backpack.put("primer_numero", a);
    }
    
    @And("the second number is {double}")
    public void GivenTheSecondNumberIs(double b) {
        backpack.put("segundo_numero", b);
    }
    
    //Add
    @When("the two numbers are added$")
    public void WhenTheTwoNumbersAreAdded() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        //backpack.put("result", result);
    }
    
    //Substract
    @When("the first is substracted the second$")
    public void WhenTheFirstIsSubstractedTheSecond() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        //backpack.put("result", result);
    }
    
    //Multiplication
    @When("the two numbers are multiplied$")
    public void WhenTheTwoNumbersAreMultiplied() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        //backpack.put("result", result);
    }
    
    @Then("the result should be {double}")
    public void ThenTheResultShouldBe(double c) {
        double result = (double) backpack.get("result");
        assert(result == c);
    }
    
}
