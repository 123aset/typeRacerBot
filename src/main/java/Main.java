import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/opt/FBbot/fbbot_resources/geckodriver");
        FirefoxProfile ffp = new FirefoxProfile();
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("/opt/FBbot/fbbot_resources/firefox/firefox-bin"));

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
//        options.addPreference("dom.disable_beforeunload", true);
//        options.addArguments("--disable-user-media-security");
        options.setCapability(FirefoxDriver.PROFILE, ffp);
        options.setBinary(firefoxBinary);
//        options.setCapability("rotatable", true);
        options.setProfile(ffp);

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1152, 864));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get("https://play.typeracer.com/");
        Actions actions = new Actions();
        actions.actionClick(driver, By.xpath("//a[contains(text(), 'Enter a typing race')]"));
        String text = driver.findElement(By.xpath("//table[@class='inputPanel']")).getText().replace("change display format","");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.typeInField(By.xpath("//table/tbody/tr/td/input"), text, driver);
        System.out.println("");
    }
}
