package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {

    public WebDriver driver;
    Login login;
    public WebDriverWait wait;

    @Before
    public void BeforeEachTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        login = new Login(driver);
    }




    @Given("user navigates to the Login page")
    public void navigate_to_the_login_page() {
        login = new Login(driver);
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("^user enters (.*) and (.*)$")
    public void enter_username_and_password(String username, String password) {
        login.EnterUserNameAndPass(username, password);
    }

    @When("clicks the Login CTA")
    public void click_login_CTA() {
        login.ClickLoginButton();
    }

    @When("the user selects an item and adds it to the Cart")
    public void select_item_and_add_it_to_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @Then("the user verifies that the item is added to the card")
    public void verify_item_is_added() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement itemAdded= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals("Sauce Labs Bike Light", itemAdded.getText());
    }

    @After
    public void AfterEachTest() {
        driver.quit();
    }
}
