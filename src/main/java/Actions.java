import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;

public class Actions {
    public void actionClick(WebDriver driver, By by) {
        try {
            org.openqa.selenium.interactions.Actions builder = new org.openqa.selenium.interactions.Actions(driver);
            WebElement element = driver.findElement(by);
            Action action = builder
                    .moveToElement(element)
                    .click()
                    .build();
            action.perform();
        } catch (Exception e) {
            e.printStackTrace();
            driver.findElement(by).click();
        }
    }
    public void typeInField(By by, String value, WebDriver driver) {
        WebElement element = driver.findElement(by);
        element.clear();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = String.valueOf(c);
            element.sendKeys(s);
            try {
                TimeUnit.MILLISECONDS.sleep(85);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
