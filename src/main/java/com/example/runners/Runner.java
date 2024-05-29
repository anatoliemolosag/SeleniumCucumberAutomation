package com.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/example",
        glue = "com/example/stepDef",
        dryRun = false,
        tags = "",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailed.Tests.txt"}
)
public class Runner {
}
