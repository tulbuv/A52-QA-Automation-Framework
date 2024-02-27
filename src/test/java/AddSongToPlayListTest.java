import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String nameSong = "pluto";
        String namePlaylist = "Vasya Playlist";
        String expectedSongAddedMessage = "Added 1 song into \"" + namePlaylist + ".\"";

        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#searchForm input[type='search']")));
        searchSong(nameSong);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist(namePlaylist);
        Assert.assertEquals(getAddToPlaylistSuccesMsg(), expectedSongAddedMessage);
    }
        //Method to search for a song by name
        public void searchSong(String nameSong)  {
            //Locating the search field and entering the song name.
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
            searchField.sendKeys(nameSong);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@data-test='view-all-songs-btn']")));

    }
    //Method to click the "View All" button.
    public void clickViewAllBtn() {
        //Locating and clicking the "View All" button
        WebElement viewAll = driver.findElement(By.xpath(" //button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
    }

    //Method to select the first song result.
    public void selectFirstSongResult() throws InterruptedException{
        //Locating and clicking the first song result.
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
    }
    //Method to click the "Add To" button.
    public void clickAddToBtn() throws InterruptedException{
        //Locating and clicking the "Add To" button.
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '\" + playlistName + \"')]")));
    }

    //Method to choose a playlist by name.
    public void choosePlaylist(String playlistName) throws InterruptedException{
        //Locating and clicking the playlist with the specified name.
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '\" + playlistName + \"')]"));
        playlist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));

    }
    //Method to get the success message after adding to the playlist.
    public String getAddToPlaylistSuccesMsg(){
        //Locating and retrieving the success message.
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }




    }



