package irctc.commonaction;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunction {
	public static WebDriver driver;
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	public void browserClose() {
		driver.quit();
	}
	public void insertText(WebElement e, String text) {
		e.sendKeys(text);
	}
	public void touch(WebElement e) {
		e.click();
	}
	public void get_text(WebElement e) {
		String out = e.getText();
	}
	public void alert() {
		driver.switchTo().alert();
	}
	public void handlingWindow() {
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String x: child) {
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}
	public void dropDown(WebElement e, int i) {
		Select s = new Select(e);
		s.selectByIndex(i);
	}
	public void insertText(String value, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", e);
	}
	public void insertText(String value, WebElement e, int i) {
		Actions a = new Actions(driver);
		a.sendKeys(e, value);
	}
	public void frames() {
		
	}

}
