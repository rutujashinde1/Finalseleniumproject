package qsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LaunchMsEdgeBrowser {
		
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
			EdgeOptions eo=new EdgeOptions();
			eo.addArguments("--remote-allow-origins=*");
			WebDriver driver=new EdgeDriver(eo);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.close();
		}

	}
