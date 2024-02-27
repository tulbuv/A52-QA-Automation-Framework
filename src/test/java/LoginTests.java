import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Check if user login with correct credentials", priority = 1)
    public void loginTest() {
        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertTrue(avatar.isDisplayed()); // true
    }

    @Test( dataProvider = "incorrectCredential",dataProviderClass = DataProviderCredentials.class)
    public void loginWithEmptyCredentials(String email, String password) {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login(email,password);
        Assert.assertTrue(logo.isDisplayed());
    }

}
