package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.factory.DriverFactory;
import com.pages.GuardianNewsHomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuardianFirstNewsArticleValidationSteps {
	private GuardianNewsHomePage newsPage = new GuardianNewsHomePage(DriverFactory.getDriver());
	String firstNews ="";
	
	@Given("User navigates to the Guardian News portal")
	public void userNavigatesToGuardianNewsPage() {

		DriverFactory.getDriver()
				.get("https://www.theguardian.com/tone/news");
	}

@And("User finds the Articles displayed on Guardian News page")
public void User_finds_the_Articles_Dislayed() {
  List<String> allArticles = newsPage.getAllTheNewsArticles();
  for(int i = 0; i<allArticles.size() ;i++) {
  System.out.println("News article posted : " + allArticles.get(i));
}
	 String firstNews = newsPage.getFirstNewsTitle();
	 System.out.println("News article posted : " + firstNews);

	
	}

@And("user reads the first News headline displayed")
public void readFirstArticle() {
	String firstNews = newsPage.getFirstNewsTitle();
	 System.out.println("News article posted : " + firstNews);
}
@And("User navigates to Google Search page in the other tab of the same browser window to perform Search for the same Article")
public void userNavigatesToGoogle() {
	 firstNews = newsPage.getFirstNewsTitle();
	 System.out.println("News article posted : " + firstNews);
	newsPage.navigateToGoogle();
	newsPage.enterGoogleSearchValue(firstNews);
    newsPage.pressKeyboardEnter();
		
}
@Then("verify that the first Guardian News article is actually valid if two or more results found for the same News article")
public void verifyLinkIsFakeOrValid() {
	List<WebElement> allValidLinks = newsPage.getAllValidLinks();
	int countOfLinks = allValidLinks.size();
	for(int i =0 ;i<allValidLinks.size();i++) {
		System.out.println("All links text : " + allValidLinks.get(i).getText());
		if(allValidLinks.get(i).getText().contentEquals(firstNews) && allValidLinks.size()>=2) {
			Assert.assertTrue(true);
	}
		else {
			Assert.fail();
		}
	
	}
}
}


