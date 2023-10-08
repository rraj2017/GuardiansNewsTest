package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.util.ElementUtil;



public class GuardianNewsHomePage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By iAmHappyButton = By.xpath("//button[@title='Yes, I’m happy']");
	private By firstNewsArticle = By.xpath("(//div[@class='fc-item__header']//a[contains(@href,'https://www.theguardian.com')]//following-sibling::span[contains(@class,'fc-item__headline')])[1]");
	private By allNewsArticle = By.xpath("//div[@class='fc-item__header']//a[contains(@href,'https://www.theguardian.com')]//following-sibling::span[contains(@class,'fc-item__headline')]");
	private By textBox = By.name("q");
	private By allLinks = By.xpath("//a[contains(@href,'https')]/child::h3");

	public GuardianNewsHomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	
	}
	
	public String getFirstNewsTitle() {
		return eleUtil.doGetText(firstNewsArticle);
	}
	
	public List<String> getAllTheNewsArticles() {
	  
		return eleUtil.getElementsTextListWithWait(allNewsArticle, 5);
	}
	
public void navigateToGoogle() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.open()");
    
    //..................1st way get all the tabs and switch using index .....................
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("https://google.com");
    eleUtil.waitForElementsToBeVisible(textBox,10);
  
}
public void enterGoogleSearchValue(String value) {
	eleUtil.doSendKeys(textBox, value);
}
public void pressKeyboardEnter() {
	driver.findElement(textBox).sendKeys(Keys.RETURN);
}

public List<WebElement> getAllValidLinks() {
	return eleUtil.getElements(allLinks);
		
}


}
