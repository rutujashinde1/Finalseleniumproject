package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelectorLocator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/accounts/login/");
		driver.findElement(By.name("username")).sendKeys("rutuja123");
		driver.findElement(By.name("password")).sendKeys("A123dfgt");
		driver.findElement(By.cssSelector("button[class*='p ']")).click();
		}

}
