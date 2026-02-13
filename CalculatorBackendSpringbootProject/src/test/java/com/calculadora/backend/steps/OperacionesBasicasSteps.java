/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.calculadora.backend.steps;


import com.calculadora.backend.CucumberSpringConfiguration;
import com.calculadora.backend.ScenarioContext;
import com.calculadora.backend.Servicios.OperacionesBasicasServicios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

@CucumberContextConfiguration
public class OperacionesBasicasSteps extends CucumberSpringConfiguration {
    @Autowired
    ScenarioContext backpack;
    
    @Autowired 
    OperacionesBasicasServicios varServicio;
     

    //Factor a (double)
    @Given("the first number is {double}")
    public void GivenTheFirstNumberIs(double a) {
        backpack.put("primer_numero", a);
    }
    
    //Factor b (double)
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
        result = varServicio.sumar(a, b);    
        //Write code here that turns the phrase above into concrete actions
        //Comment once implemented
        //throw new io.cucumber.java.PendingException();
        //Uncomment once implemented
        backpack.put("result", result);
    }
    
    //Substract
    @When("the first is substracted the second$")
    public void WhenTheFirstIsSubstractedTheSecond() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        result = varServicio.restar(a, b); 
        //Write code here that turns the phrase above into concrete actions
        //Comment or delete once implemented
        //throw new io.cucumber.java.PendingException();
        //Uncomment once implemented
        backpack.put("result", result);
    }
    
    //Multiplication
    @When("the two numbers are multiplied$")
    public void WhenTheTwoNumbersAreMultiplied() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Write code here that turns the phrase above into concrete actions
        //Comment or delete once implemented
        throw new io.cucumber.java.PendingException();
        //Uncomment once implemented
        //backpack.put("result", result);
    }
    
    //Division
    @When("the first is divided by the second$")
    public void WhenTheFirstIsDividedByTheSecond() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Write code here that turns the phrase above into concrete actions
        //Comment or delete once implemented
        throw new io.cucumber.java.PendingException();
        //Uncomment once implemented
        //backpack.put("result", result);
    }
    
    //Division by zero
    @When("the first is divided by zero$")
    public void WhenTheFirstIsDividedByTheZero() {
        double a = (double) backpack.get("primer_numero");
        double b = (double) backpack.get("segundo_numero");
        double result;
        //Comment or delete once implemented
        throw new io.cucumber.java.PendingException();
        //Uncomment once implemented
        /*
        try {
            //Write code here that turns the phrase above into concrete actions
            //result = ...
            //backpack.put("throw", false);
        } catch (RuntimeException e) {
            backpack.put("throw", true);
        }
        */
    }
    
    //Result {double}
    @Then("the result should be {double}")
    public void ThenTheResultShouldBe(double c) {
        double result = (double) backpack.get("result");
        assert(result == c);
    }
    
    //Result exception
    @Then("the result should be an exception$")
    public void ThenTheResultShouldBeAnException() {
        boolean result = (boolean) backpack.get("throw");
        assert(result);
    }
    
}
