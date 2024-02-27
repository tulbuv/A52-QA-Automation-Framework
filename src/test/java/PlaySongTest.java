import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest{


    @Test
    public void playSongTest(){

        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        WebElement playSongButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playSongButton.click();
        WebElement nextSongButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        nextSongButton.click();
        WebElement soundBar = driver.findElement(By.cssSelector("[data-test='soundbars']"));
        Assert.assertTrue(soundBar.isDisplayed());



    }
}
