package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    private By Username = By.id("user-name");
    private By Password = By.id("password");
    private By LoginButton = By.id("login-button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterUserNameAndPass(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
    }

    public void ClickLoginButton() {
        System.out.println("Button click called");
        driver.findElement(LoginButton).click();
    }
}


