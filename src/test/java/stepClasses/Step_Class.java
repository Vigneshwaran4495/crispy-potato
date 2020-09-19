package stepClasses;

import io.cucumber.java.en.Given;
import testFunctions.LazyTester;

public class Step_Class {

	@Given("Test a sample script of BDD")
	public void testing() throws Exception {
		System.out.println("test bdd");
	}
	
	@Given("Test a sample script of BDD second time")
	public void testing1() throws Exception {
		System.out.println("test bdd again 2");
	}
}
