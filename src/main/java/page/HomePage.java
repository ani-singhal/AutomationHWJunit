package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class HomePage extends BasePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	
	}



	@FindBy(how = How.CSS, using = "input[name='allbox']")
	WebElement TOGGLEBOX;
	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement RemoveButton;
	// @FindBy(how =How.CSS, using="input[name='data']") WebElement AddTextBox;
	@FindBy(how = How.CSS, using = "ul[style='list-style-type: none; padding-left:0']")
	WebElement AllCheckBoxes;
	@FindBy(how = How.CSS, using = "input[type='checkbox']")
	List<WebElement> AllCheckBoxes2; // includes the toggle checkboc
	@FindBy(how = How.XPATH, using = "//li/input[@type='checkbox']")
	List<WebElement> AllCheckBoxes3; // without the toggle checkbox

	public void toggle_button_click() {
		TOGGLEBOX.click();
	}

	public void remove_Button_click() {
		System.out.println("TRTR"+RemoveButton.getText());
		RemoveButton.click();
	}

	public void Validate_all_boxes_checked() {
		
		boolean flag = true;
		List<WebElement> checkBoxes = AllCheckBoxes2;
		for (WebElement item : checkBoxes) {
			if (item.isSelected()) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == false) {
			System.out.println("The validation Failed. Not all CheckBoxes are clicked");
		} else {
			System.out.println("All CHeckBoxes clicked. Validated.");
		}
	}

	public void singlecheckBoxRemoveValidation() {
		List<WebElement> checkBoxes = AllCheckBoxes2;
		int j = checkBoxes.size();
		int i = RandomGen(j);
		System.out.println("Random No "+i);
		// //input[@name='todo[0]']
		String Before = "//input[@name='todo[";
		String After = "]']";
		String fullXpath = Before + i + After;
		System.out.println(fullXpath);
		
		WebElement SingleCheckBox = driver.findElement(By.xpath(fullXpath));
		Timer(driver, 2, SingleCheckBox);
		System.out.println("+++"+SingleCheckBox);
		String ToDelete = SingleCheckBox.getAttribute("name");
		System.out.println("==="+ToDelete);
		SingleCheckBox.click();
		RemoveButton.click();
		boolean flag = true;
		for (WebElement item : checkBoxes) {
			if (item.getAttribute("name").contains(ToDelete)) {
			flag=false;	
		System.out.println(" The CheckBox NOT deleted when remove button clicked and single check is checked");
			break;}
			
	}
		if(flag==true) {
			System.out.println("The deleted CHeckBOX is REMOVED");
		}
		
	}
	
	

	public void validateDeletionofAllcheckboxes() {
		List<WebElement> checkBoxes = AllCheckBoxes3;
		System.out.println("THERE are "+ checkBoxes.size());
		
		Assert.assertEquals("We still have CheckBoxes", 0, checkBoxes.size());
	
		System.out.println("ZZZZZZZ");
	
	}

}
