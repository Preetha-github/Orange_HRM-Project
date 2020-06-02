package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_PageObjects {
	
	
	@FindBy(xpath="//tr[@class='odd']/child::*")
	public static WebElement PendingLeaveRequest;

}


