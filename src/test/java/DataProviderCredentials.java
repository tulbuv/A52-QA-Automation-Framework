import org.testng.annotations.DataProvider;

public class DataProviderCredentials {
    @DataProvider(name = "incorrectCredential")
    public Object[][] provideIncorrectCredential(){
        return new Object[][]{
                {"vasile.tulbu@testpro.io", ""},
                {"","ZgPSBpAE" },
                {"vasile.tulbu@testpro", "ZgPSBpAE"},
                {"vasile.tulbu@testpro.io", " tryuj"},
                {"vasie.tulbu@testpro.io","tryuj"}

        };

    }
}
