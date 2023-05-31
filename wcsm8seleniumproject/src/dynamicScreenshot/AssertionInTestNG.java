package dynamicScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AssertionInTestNG {
	static ChromeDriver driver;
  @BeforeTest
  public void property () 
  {
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  }
  
  @BeforeMethod
  public void setUp()
  {
	  driver = new ChromeDriver();
	  
  } 
}
