package com.cucumberRunner;

import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features ={"src\\main\\java\\com\\cucumberFeatureFile\\Smoke.feature"} , dryRun =!true , snippets = CucumberOptions.SnippetType.CAMELCASE , monochrome  = true , glue ={"cucumberStepDefinition","Hooks"} , plugin = {"pretty","json:target/cucumber-reports1/Cucumber.json","html:target/cucumber-reports123/index.html"}  )
public class RunnerCucumber extends AbstractTestNGCucumberTests{
		
}