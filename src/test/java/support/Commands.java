package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element){
        System.out.println("Init #######################################");
        System.out.println("*** Clicar no elemento: " + element);
        try {
            waitElementBeClickable(element, 5);
            getDriver().findElement(element).click();
            System.out.println("*** OK");
        } catch (Exception error) {
            System.out.println("*** Erro ao tentar clicar no elemento: " + element);
            System.out.println(error);
        }
        System.out.println("Finish #####################################");
    }

    public static void fillFild(By element, String value){
        System.out.println("Init #######################################");
        System.out.println("*** Preencher campo no elemento: " + element);
        try {
            waitElementBeVisible(element, 5);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("*** OK");
        } catch (Exception error) {
            System.out.println("*** Erro ao tentar preencher o campo: " + element + " com o valor: " + value);
            System.out.println(error);
        }
        System.out.println("Finish #####################################");
    }

    public static void validateMessage(By element, String valueExpected){
        System.out.println("Init #######################################");
        System.out.println("*** Verificar valor de '"+ valueExpected + "' no elemento: " + element);
        waitElementBeVisible(element, 5);
        Assert.assertEquals("Os textos não são iguais!", valueExpected, getDriver().findElement((element)).getText());
        System.out.println("Finish #####################################");
    }
}
