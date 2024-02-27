import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylistTest()  {

        String deletedPlaylistMessage = "Deleted playlist";

        String playlistName = "Vasya";

        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists i[role='button']")));
        WebElement addPlaylistButton = driver.findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        addPlaylistButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        WebElement createPlaylistButton = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        createPlaylistButton.click();
        WebElement playlistNameInput = driver.findElement(By.cssSelector("[name='create-simple-playlist-form']>input"));
        playlistNameInput.sendKeys(playlistName);
        playlistNameInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        WebElement playListVasya = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        playListVasya.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='del btn-delete-playlist']")));
        WebElement deletePlayListBtn = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deletePlayListBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='ok']")));
        WebElement okBtn = driver.findElement(By.cssSelector("[class='ok']"));
        okBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        Assert.assertFalse(playListVasya.isDisplayed());



    }
}
