package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generator.generateString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {

	static WebDriver driver;

	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\afgba\\Desktop\\selenium2\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(" https://login.mailchimp.com/signup/");
		Thread.sleep(5000); // Let the user actually see something!
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}

	@When("user fills email {string}")
	public void user_fills_email(String email) {
		WebElement Email = driver.findElement(By.cssSelector("input[id=email]"));
		Email.sendKeys(email);

	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {

		username = username + generateString.getAlphaNumericString(5);

		WebElement usr = driver.findElement(By.name("username"));
		usr.sendKeys(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {

		WebElement psw = driver.findElement(By.name("password"));
		psw.sendKeys(password);
	}

	@When("user clicks sign up button")
	public void user_clicks_sign_up_button() {

		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		driver.findElement(By.id("create-account")).click();
	}

	@Then("user see the message")
	public void user_see_the_message(String result) {

		if (result.equalsIgnoreCase("yes")) {

			String actual = driver.getTitle();

			String expected = "Success | Mailchimp";
			Assert.assertEquals(expected, actual);

			quit();
		}
	}

	public void quit() {

		driver.quit();

	}
}
