package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users_PageObjects {

	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	public static WebElement Admin;

	@FindBy(id = "searchSystemUser_userType")
	public static WebElement UserRole;

	@FindBy(id = "searchSystemUser_status")
	public static WebElement Status;

	@FindBy(xpath = "//input[@id='searchBtn']")
	public static WebElement SearchBtn;

	@FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
	public static WebElement UserManagement;

	@FindBy(xpath = "//a[@id='menu_admin_viewSystemUsers']")
	public static WebElement Users;

	@FindBy(xpath="//td[3]")
	public static WebElement UserRoleValue;
	
	@FindBy(xpath="//td[5]")
	public static WebElement UserStatusValue;
	
	
}
