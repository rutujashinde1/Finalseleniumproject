package genericPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WorkLib extends BaseTest {
	//handle the pop up 
	WebDriver driver;
	
	
	
	
	
	
	
	//handle mouse actions
	
	public void rightClick(WebElement target)
	{
		Actions act=new Actions(driver);
		act.contextClick(target).perform();
	}
	
	public void doubleClickMethod(WebElement target)
	{
		Actions act=new Actions(driver);
		act.doubleClick(target).perform();
	}
	
	public void mouseHoverMethod(WebElement src,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	//handle frame
	
	
	public void handleFrameByNameorId(String NameOrId)
	{
		driver.switchTo().frame(NameOrId);
	}

}
