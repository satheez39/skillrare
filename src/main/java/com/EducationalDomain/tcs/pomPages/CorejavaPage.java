package com.EducationalDomain.tcs.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CorejavaPage {
	
	@FindBy(xpath="//a[contains(text(),' Core Java For')]")
    private WebElement corejava;
	
	@FindBy(xpath="//button[text()='Accept']")
	 private WebElement cookie;
	
	public WebElement getCookie() {
		return cookie;
	}


	public CorejavaPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getCorejava() {
		return corejava;
	}
	
	public WishlistPage corejavaselenium(WebDriver driver) {
		corejava.click();
		cookie.click();
		return new WishlistPage(driver);
	}
}
