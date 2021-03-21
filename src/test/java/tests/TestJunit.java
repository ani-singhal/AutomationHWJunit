package tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.HomePage;
import util.Browserfactory;

public class TestJunit {

	WebDriver driver;
@Before
public void Launch() {
	driver = Browserfactory.init();
}
	

	@Test
	public void Testcase1() throws IOException {
	
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.toggle_button_click();
		homePage.Validate_all_boxes_checked();

		homePage.takeScreenshotAtEndOfTest(driver);
}

	@Test
	public void Testcase2() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.singlecheckBoxRemoveValidation();
	}
	
	@Test
	public void Testcase3() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.toggle_button_click();
		homePage.remove_Button_click();
		homePage.validateDeletionofAllcheckboxes();
		
	}
}


