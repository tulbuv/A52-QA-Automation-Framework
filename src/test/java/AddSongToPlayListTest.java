import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongToPlayListTest extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String nameSong = "pluto";
        String namePlaylist = "Vasya Playlist";
        String expectedSongAddedMessage = "Added 1 song into \"" + namePlaylist + ".\"";

        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        Thread.sleep(2000);
        searchSong(nameSong);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist(namePlaylist);
        Assert.assertEquals(getAddToPlaylistSuccesMsg(), expectedSongAddedMessage);
    }
        //Method to search for a song by name
        public void searchSong(String nameSong) throws InterruptedException {
            //Locating the search field and entering the song name.
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
            searchField.sendKeys(nameSong);
            Thread.sleep(2000);
    }
    //Method to click the "View All" button.
    public void clickViewAllBtn() throws InterruptedException{
        //Locating and clicking the "View All" button
        WebElement viewAll = driver.findElement(By.xpath(" //button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }

    //Method to select the first song result.
    public void selectFirstSongResult() throws InterruptedException{
        //Locating and clicking the first song result.
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    //Method to click the "Add To" button.
    public void clickAddToBtn() throws InterruptedException{
        //Locating and clicking the "Add To" button.
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    //Method to choose a playlist by name.
    public void choosePlaylist(String playlistName) throws InterruptedException{
        //Locating and clicking the playlist with the specified name.
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '\" + playlistName + \"')]"));
        playlist.click();
        Thread.sleep(2000);
    }
    //Method to get the success message after adding to the playlist.
    public String getAddToPlaylistSuccesMsg(){
        //Locating and retrieving the success message.
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }





       // WebElement allSongsBtn=driver.findElement(By.xpath("//li/a[@href='#!/songs']"));
       // allSongsBtn.click();
//        WebElement firstSong=driver.findElement(By.xpath("//td[contains(text(), 'M33 Project - Emotional Soundtrack')]"));
//        firstSong.click();
//        WebElement addToBtn= driver.findElement(By.cssSelector("[class='btn-add-to']"));
//        addToBtn.click();
      //  WebElement createNewPlayList= driver.findElement(By.xpath("//*[@id=\"queueWrapper\"]/header/div[3]/div/section[2]/form/input"));
      //  createNewPlayList.sendKeys("Vasya");
//        WebElement saveBtn= driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[2]/form/button"));
//        saveBtn.click();
//       // Assert.assertEquals();

       // WebElement favoriteLink= driver.findElement(By.xpath("//ul/li[@class='favorites']"));
        //favoriteLink.click();


      //  WebElement createNewPlayList= driver.findElement(By.cssSelector("[title='Create a new playlist']"));
      //  createNewPlayList.click();
      //  WebElement newPlayList= driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));



    }



