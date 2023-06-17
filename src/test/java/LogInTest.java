import PageObject.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static DataObject.LogInData.*;

public class LogInTest {
    WebDriver driver;

    @BeforeMethod(description = "setup browser before testing") // ყოველთვის მეთოდის წინ გაიხსნას ბრაუზერი
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }
    @Test
    public void validLogIn() throws InterruptedException {
        LogInPage home = new LogInPage(driver);
        home
                .UsernameInput(username)
                .PasswordInput(password)
                .clickOnLogInButton();
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
