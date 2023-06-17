package PageObject;
import DataObject.LogInData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static DataObject.LogInData.username;
import static DataObject.LogInData.password;


public class LogInPage {
                  // ლოკატორებზე რომ ვიმოქმედოთ და დრაივერი რომ გავხსნათ driver გვჭირდება
    WebDriver driver;

    public LogInPage (WebDriver driver) {
        this.driver = driver ; // პატარა შესავალია თითოეულ გვერდზე, თითოეულ გვერდზე ახლიდან ხოარ წამოვიღებთ ხოლმე driver-ს და სხვა რამებს,ამიტომ გვჭირდება.ყველა ელემენტებზე ვიმოქმედოთ.
    }
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
@Step("username input:{0}")
    public LogInPage UsernameInput(String username){
        driver.findElement(usernameInput).sendKeys(LogInData.username);
        return this;
    }
@Step ("password input:{0}")
    public LogInPage PasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(LogInData.password);
        return  this;
    }
    @Step("clickon on button")
    public LogInPage clickOnLogInButton() throws InterruptedException {
        driver.findElement(loginButton).click();
        Thread.sleep(5000);
        return this; // რადგან მეთოდიც/ცვლადიც არგუმენტად იღებს იუზერნეიმს და თან ვაბრუნებინებთ იუზერნეიმს, რადგან ორივეს ერთიდაიგივე სახელი ჰქვია ამიტომ ვუწერთ return this.რაც კლასის დონის ცვლადია იმას დააბრუნებს.

    }

}
