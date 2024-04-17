package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class RunBase {

    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver getDriver(String browser) {

        if (driver !=  null) {
            driver.quit();
        }

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "chrome-ci":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "window-size=1200x600");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "firefox-ci":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                throw new IllegalArgumentException("Edge ainda nao suportado");
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, forefox ou edge.");
        }

        if(driver != null){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        return driver;
    }

}
