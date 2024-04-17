package support;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenshotUtils {
    public static void addScreenshotOnScenario(Scenario scenario) {
        System.out.println("####################");
        System.out.println("Cenário executado: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("Tags: " + scenario.getSourceTagNames());

        if (scenario.isFailed()){
            System.out.println("Cenário falhou");
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs((OutputType.BYTES));
            scenario.embed(screenshot, "image/png" );
        }
        System.out.println("####################");
    }
}
