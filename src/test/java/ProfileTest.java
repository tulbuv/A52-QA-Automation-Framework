import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test(groups = "Smoke")
    public void changeProfileNameTest() throws InterruptedException {
        String newName = UUID.randomUUID().toString();
        login("vasile.tulbu@testpro.io", "ZgPSBpAE");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Thread.sleep(2000);
        avatar.click();
        WebElement currentPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currentPasswordField.sendKeys("ZgPSBpAE");
        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.clear();
        nameInput.sendKeys(newName);
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userBadge span[class=name]")));
        WebElement userNameLabel = driver.findElement(By.cssSelector("#userBadge span[class=name]"));
        Thread.sleep(2000);
        Assert.assertEquals(newName, userNameLabel.getText());
    }
}
