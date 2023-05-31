package dynamicScreenshot;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

public class BaseTest {
	static WebDriver driver;
  @BeforeTest
  public void Property() {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  }
  @BeforeMethod
  public void setup()
  {
	  ChromeOptions co=new ChromeOptions();
	  co.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(co);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	 driver.get("http://desktop-pulp5vs/login.do");
	  
  }
  public void failedMethodToTakesScreenshot(String failedMethod)
  {
	  try {
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File dest = new File("./ScreenShots/"+failedMethod+".png");
	  Files.copy(src, dest);
	  }
	  catch(Exception e)
	  {
		  
	  }
  // @AfterMethod
   //public void tearDown() throws InterruptedException {
//	   Thread.sleep(2000);
	   //driver.quit();
   }
}

