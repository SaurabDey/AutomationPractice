package my.auto.com.AutomationPractice.cucumber.runnerclass;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions
( 
		features="FeatureFolder/Start2.feature",
		glue="my.auto.com.AutomationPractice.cucumber.stepdefination",
		plugin  = {"pretty:STDOUT","html:target/HTMLCucumberReport1","json:target/Cucumber.json"},
		monochrome=true
)

public class FirstRunnerClass extends AbstractTestNGCucumberTests
{
	@Test
	public void f()
	{
		
	}

}