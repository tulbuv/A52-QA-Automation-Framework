import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest{

   @Test
    public void playSong(){
       login("vasile.tulbu@testpro.io" , "ZgPSBpAE");
       WebElement allSongsBtn=driver.findElement(By.xpath("//li/a[@href='#!/songs']"));
       allSongsBtn.click();
       WebElement firstSong=driver.findElement(By.xpath("//td[contains(text(), 'M33 Project - Emotional Soundtrack')]"));
       firstSong.click();
       //firstSong.;

    }
}
