package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public void handleDropDown(WebElement element,String targetedelement) {
		
		Select s = new Select(element);
		s.selectByVisibleText(targetedelement);
	}
	public void mouseOver(WebDriver driver, WebElement element) {
	
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	public void switchWindow(WebDriver driver, String expectedUrl) {
		Set<String> ids = driver.getWindowHandles();
		for (String str : ids) {
			String actualUrl = driver.switchTo().window(str).getCurrentUrl();
			System.out.println(actualUrl);
			
			String childUrl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
			if (actualUrl.contains(expectedUrl)) {
				break;
			}
		}
	}
	public File screenShot(WebDriver driver, String screenShot) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver ;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./ScreenShot/"+screenShot+".png");
		FileUtils.copyFile(tempfile, destinationFile);
		return destinationFile;
		
	}
}
