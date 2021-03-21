package hwpart1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestingWithJunit {
	WebDriver driver;
	@Test
	public void init() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://techfios.com/test/101/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement TOGGLEBOX = driver.findElement(By.name("allbox"));
		WebElement ForCheckBox = driver.findElement(By.xpath("//ul[@style='list-style-type: none; padding-left:0']"));
		WebElement RemoveCheckBox = driver.findElement(By.cssSelector("input[value='Remove']"));
		WebElement AllCheckBoxes = driver.findElement(By.cssSelector("input[type='checkbox']"));
		WebElement OneCheckBoxSel = driver.findElement(By.cssSelector("input[name='todo[0]']"));
		
		TOGGLEBOX.click();
		List<WebElement> checkboxes= (List<WebElement>) AllCheckBoxes;
		if(TOGGLEBOX.isSelected()){;
		System.out.println("Toggle selected");}
		takeScreenshotAtEndOfTest(driver);
		for(WebElement item:checkboxes) {
		System.out.println(item.getText());
		}
	}
	
		
		
//	OneCheckBoxSel.click();
//	RemoveCheckBox.click();
//	if(OneCheckBoxSel.isDisplayed()) {
//		System.out.println("Selected item NOT deleted");
//	}
//	else {
//		System.out.println("Your deletion is successful");
//	}
	
//	//test3
//	Assert.assertEquals("CheckBOXES NOT Deleted", null, AllCheckBoxes.getText());
//		
	
	
	
	public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(sourceFile, new File(currentDir + "/screenshots/" + label + ".png"));
	}

	
//	@After
//	public void teardown() {
//		driver.close();
//		driver.quit();
//	}
	
}
