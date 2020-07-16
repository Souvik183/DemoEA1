package com.EA.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EA.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="UserName")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginbtn;

	public LoginPage() throws Exception 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}

}
