package in.co.irctc;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BuyTicket_Stepdefinition {
	public static WebDriver driver;
	@Given("launch the browser and url {string}")
	public void launch_the_browser_and_url(String url) {
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-popups");
		options.addArguments("disable-notifications");
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(url);    
	}

	@Given("users enters value or clicks on from field {string}")
	public void users_enters_value_or_clicks_on_from(String start) {
    	WebElement from = driver.findElement(By.id("src"));
    	from.sendKeys(start);
    	driver.findElement(By.xpath("//li[contains(text(),'Koyambedu')]")).click();
	}

	@When("users enters value or clicks on to field {string}")
	public void users_enters_value_or_clicks_on_to_field(String end) {
		WebElement to = driver.findElement(By.xpath("//input[@id='dest']"));
    	to.sendKeys(end);
    	driver.findElement(By.xpath("//li[contains(text(),'Kada')]")).click();
	}

	@When("users enters value or clicks on to field with one dim list")
	public void users_enters_value_or_clicks_on_to_field_with_one_dim_list(DataTable dataTable) {
		List<String> EndLocations = dataTable.asList();
		String end = EndLocations.get(1);
		WebElement to = driver.findElement(By.xpath("//input[@id='dest']"));
    	to.sendKeys(end);
    	driver.findElement(By.xpath("//li[contains(text(),'Kada')]")).click();
	}
	@Given("users enters value or clicks on from field with one dim map")
	public void users_enters_value_or_clicks_on_from_field_with_one_dim_map(DataTable dataTable) {
		Map<String, String> StartLocations = dataTable.asMap(String.class, String.class);
		String start = StartLocations.get("location3");
		WebElement from = driver.findElement(By.id("src"));
    	from.sendKeys(start);
    	driver.findElement(By.xpath("//li[contains(text(),'Koyambedu')]")).click();
	}
	@Then("validate the date")
	public void validate_the_date() {
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
	}

	@When("user clicks on search")
	public void user_clicks_on_search() {
	    driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	}
	}
