import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HMW17 extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys("vasile.tulbu@testpro.io");
        passwordInput.sendKeys("ZgPSBpAE");
        loginButton.click();
        WebElement allSongsBtn=driver.findElement(By.xpath("//li/a[@href='#!/songs']"));
        allSongsBtn.click();
        WebElement firstSong=driver.findElement(By.xpath("//td[contains(text(), 'M33 Project - Emotional Soundtrack')]"));
        firstSong.click();
        WebElement addToBtn= driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToBtn.click();
      //  WebElement createNewPlayList= driver.findElement(By.xpath("//*[@id=\"queueWrapper\"]/header/div[3]/div/section[2]/form/input"));
      //  createNewPlayList.sendKeys("Vasya");
        WebElement saveBtn= driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/button"));
        saveBtn.click();
       // Assert.assertEquals();

       // WebElement favoriteLink= driver.findElement(By.xpath("//ul/li[@class='favorites']"));
        //favoriteLink.click();

        driver.quit();


      //  WebElement createNewPlayList= driver.findElement(By.cssSelector("[title='Create a new playlist']"));
      //  createNewPlayList.click();
      //  WebElement newPlayList= driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));



    }


}
