import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {


    @Test
    public void registrationNavigationTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        
        WebElement registrationBtn = driver.findElement(By.cssSelector("[href='registration']"));
        registrationBtn.click();
        WebElement registrationText = driver.findElement(By.xpath("//div[@class='login-wrapper']/h2[contains(text(),'Register new account or')]"));
        Assert.assertTrue(registrationText.isDisplayed());
        driver.quit();


        // a[href='registration']
    }






}
