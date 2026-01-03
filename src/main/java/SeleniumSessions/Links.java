package SeleniumSessions;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {

	WebDriver driver;

	public Links(WebDriver driver) {

		this.driver = driver;
	}

	public void getGoogleSuggestion(By locator, String value, By locators, String Values) throws InterruptedException {

		ElementUtil elementUtil = new ElementUtil(driver);

		elementUtil.doSendKeys(locator, value);
		Thread.sleep(4000);
		List<WebElement> suggList = getElements(locators);
		int sugSize = suggList.size();
		System.out.println("suggestion size =" + sugSize);
		Thread.sleep(2000);
		if(sugSize>0)
		{
		for (WebElement e : suggList) {
			String suggText = e.getText();

			if (suggText.length() > 0) {

				System.out.println(suggText);

				if (suggText.contains(Values)) {

					e.click();
					break;
				}

			}
			else {
				System.out.println("Suggestion is blank ");
			}

		}
		}
		else
		{
			System.out.println("Suggestion list is zero");
		}
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> WElemets = driver.findElements(locator);
		return WElemets;
	}

	public int totalLinkCount(By locator) {
		int count = getElements(locator).size();
		System.out.println(count);

		return count;
	}

	public List<String> linkText(By locator) {
		List<WebElement> linksLoc = getElements(locator);

		List<String> arList = new ArrayList<String>();

		int count = 0;

		for (WebElement e : linksLoc) {
			String linkText = e.getText();
			int linkLen = linkText.length();

			if (linkLen > 0) {
				System.out.println(count + "=" + linkText);
			}
			count++;

			arList.add(linkText);

			/*
			 * for (int i = 0; i < totalSize; i++) { WebElement linkLocation =
			 * totalLinks.get(i);
			 * 
			 * String linkText = linkLocation.getText();
			 * 
			 * if (linkText.length() > 0)
			 * 
			 * { System.out.println(i + "=" + linkText); }
			 * 
			 * }
			 */
		}

		return arList;

	}

	public void doLinkClick(By locator, String linkValue) {

		List<WebElement> linkTextlist = getElements(locator);

		for (WebElement e : linkTextlist) {
			String linkText = e.getText();

			if (linkText.equals(linkValue)) {
				e.click();

			}

		}

	}

	public List<String> getAttributeslink(By locator, String Values) {
		List<WebElement> footerListlink = getElements(locator);
		List<String> footerList = new ArrayList<String>();

		int count = 0;
		for (WebElement e : footerListlink) {

			String footerListLinkText = e.getText();
			System.out.println(count + "=" + footerListLinkText);

			String foolinkAttribute = e.getAttribute(Values);
			System.out.println(count + "=" + foolinkAttribute);

			footerList.add(foolinkAttribute);

			count++;

		}

		return footerList;

	}

	public static void main(String[] args) throws InterruptedException {

		LaunchCrossBrowser LcBr = new LaunchCrossBrowser();

		WebDriver driver = LcBr.launchBrowser("Chrome");

		Links LK = new Links(driver);

		driver.get("https://www.google.co.in/");
		
		By googLoc=By.name("q");
		By suggList=By.xpath("//div[@role='presentation']//li//span");
		LK.getGoogleSuggestion(googLoc,"dsdsdsdsds",suggList,"selenium webdriver");
		
		

		// List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		// int totalSize = totBy.alLinks.size();
		// By lnk = By.tagName("a");
		// LK.totalLinkCount(lnk);
		/*
		 * List<String> listLink = LK.linkText(lnk); if
		 * (listLink.contains("Forgotten Password")) { System.out.println("Pass"); }
		 */

		// LK.doLinkClick(lnk, "Forgotten Password");

		// By footerLocator=By.xpath("(//div[@class='container'])[5]//ul//a");
		// LK.getAttributeslink(footerLocator,"href");

		//driver.findElement(By.name("q")).sendKeys("Selenium");
		//Thread.sleep(3000);

		//List<WebElement> LiwebElemets = driver.findElements(By.xpath("//div[@role='presentation']//li//span"));
		//// div[@class='wM6W7d']/span
		//// div[@role='presentation']//li//span
		//System.out.println(LiwebElemets.size());

		/*
		 * for (WebElement e : LiwebElemets) { String suggText = e.getText();
		 * 
		 * if (suggText.length() > 0) { System.out.println(suggText);
		 * 
		 * if (suggText.contains("selenium webdriver")) { e.click(); break; } }
		 * 
		 * }
		 */

	}

}
