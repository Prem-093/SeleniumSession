package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
	}

//**************************************************************************WebElement**************************************************************************//

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public WebElement doGetElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		}

		catch (NoSuchElementException e) {
			System.out.println("Element not present with :" + locator + "Please pass correct locator");
		}
		try {
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		element = driver.findElement(locator);

		return element;
	}

	public void doSendKeys(By locator, String values) {
		doGetElement(locator).sendKeys(values);
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

	public void doClear(By locator) {
		doGetElement(locator).clear();
	}

	public String dogetAttribute(By locator, String Value) {
		return doGetElement(locator).getAttribute(Value);
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> WElemets = driver.findElements(locator);
		return WElemets;
	}

	// **********************************************************************Links*********************************************************************************//
	public void getGoogleSuggestion(By locator, String value, By locators, String Values) throws InterruptedException {

		doSendKeys(locator, value);
		Thread.sleep(4000);
		List<WebElement> suggList = getElements(locators);
		int sugSize = suggList.size();
		System.out.println("suggestion size =" + sugSize);
		Thread.sleep(2000);
		if (sugSize > 0) {
			for (WebElement e : suggList) {
				String suggText = e.getText();

				if (suggText.length() > 0) {

					System.out.println(suggText);

					if (suggText.contains(Values)) {

						e.click();
						break;
					}

				} else {
					System.out.println("Suggestion is blank ");
				}

			}
		} else {
			System.out.println("Suggestion list is zero");
		}
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
		}

		return arList;

	}

	public void doeveryLinkClick(By locator) {

		List<WebElement> linkTextlist = getElements(locator);

		for (WebElement e : linkTextlist) {
			// String linkText = e.getText();
			e.click();

		}

	}

	public void doLinkClick(By locator, String linkValue) {

		List<WebElement> linkTextlist = getElements(locator);

		for (WebElement e : linkTextlist) {
			String linkText = e.getText();

			if (linkText.equals(linkValue)) {
				e.click();
				break;

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

	// ***********************************************************************select*******************************************************************************//

	public void doselectByVisisbleText(By locator, String value) throws InterruptedException {
		WebElement drdoLOC = doGetElement(locator);
		Thread.sleep(3000);
		Select select = new Select(drdoLOC);
		select.selectByVisibleText(value);

	}

	public boolean getTotalCountDropDown(By locator) {
		boolean flag;
		/// ElementUtil elementUtil = new ElementUtil(driver);
		WebElement drdoLOC = doGetElement(locator);
		Select select = new Select(drdoLOC);
		List<WebElement> dropDwonList = select.getOptions();
		int dropDwonsiz = dropDwonList.size();
		System.out.println(dropDwonsiz - 1);
		if (dropDwonsiz - 1 == 233) {
			flag = true;

			System.out.println("Total size :" + dropDwonsiz + "," + flag);
		}

		else {
			flag = false;

			System.out.println("Incorrect number of Links :" + dropDwonsiz + "," + flag);
		}

		return flag;

	}

	public boolean doClickByGetOption(By locator, String value) throws InterruptedException {
		WebElement dropdwLoc = doGetElement(locator);

		Select select = new Select(dropdwLoc);
		List<WebElement> dropDownList = select.getOptions();

		boolean flag = false;
		if (dropDownList.size() > 0) {
			for (WebElement e : dropDownList) {
				String optionText = e.getText();

				// Thread.sleep(2000);

				if (optionText.length() > 0) {
					System.out.println(optionText);

					if (optionText.contains(value)) {
						e.click();
						flag = true;
						System.out.println(value + "  " + "Option is avaialable " + "  " + flag);
						break;
					} else {

						System.out.println("Option is not avaiable :" + value + "is not available " + "   " + flag);

					}
				}

				else {

					System.out.println("Option is blank :" + optionText + "Please pass correct option " + "   " + flag);
				}
			}

		} else {
			System.out
					.println("Please pass correct locator which contain" + "  " + dropdwLoc + "  " + " dropdown list");

		}
		return flag;

	}

	public void doSelectWithoutSelect(By locator, By locators) {

		doGetElement(locator);
		List<WebElement> dropDownListOption = getElements(locators);
		System.out.println(dropDownListOption.size());
		for (WebElement e : dropDownListOption) {
			String optionText = e.getText();
			System.out.println(optionText);

			if (optionText.contains("India")) {

				e.click();
				break;
			}

		}

	}

	// ************************************************************************************Wait**************************************************************************************
	public WebElement waitforElementVisisble(By locator, int timeout) {

		// An expectation for checking that an element is present on the DOM of a page
		// and visible.
		// Visibility means that the element is not only displayed but also has a height
		// and width that is greater than 0.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public void sendValuesAfterWait(By locator, int timeout, String Values) {

		waitforElementVisisble(locator, timeout).sendKeys(Values);

	}

	public void elementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public List<WebElement> waitForElementsVisible(By locators, int TimeOut) {

		// An expectation for checking that all elements present on the web page that
		// match the locatorare visible.
		// Visibility means that the elements are not only displayed but also have a
		// heightand width that is greater than 0.

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		List<WebElement> link_list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locators));
		return link_list;
	}

	public Alert waitforAlertJSPopUp(int TimeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public String alrttGetText(int TimeOut) {
		String alertText = waitforAlertJSPopUp(TimeOut).getText();
		return alertText;
	}

	public void alertAcept(int TimeOut) {

		waitforAlertJSPopUp(TimeOut).accept();

	}

	public void alertDismiss(int TimeOut) {

		waitforAlertJSPopUp(TimeOut).dismiss();

	}

	public void sendValuesAlert(int TimeOut, String values) {

		waitforAlertJSPopUp(TimeOut).sendKeys(values);

	}

	public String waitGetTitle(String titleFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			String textTitle = driver.getTitle();

			return textTitle;

		} else {
			System.out.println("Title is not present within TomeOutLimit " + timout);
			return null;
		}
	}

	public String waitExacttGetTitle(String titleFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.titleIs(titleFraction))) {
			String textTitle = driver.getTitle();

			return textTitle;

		} else {
			System.out.println("Title is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public String waitForGetURL(String URLFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.urlContains(URLFraction))) {
			String URL = driver.getCurrentUrl();

			return URL;

		} else {
			System.out.println("URL is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public String waitForExacttGetURL(String URLFraction, int timout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timout));

		if (wait.until(ExpectedConditions.urlToBe(URLFraction))) {
			String URL = driver.getCurrentUrl();

			return URL;

		} else {
			System.out.println("URL is not present within TomeOutLimit " + timout);
			return null;
		}

	}

	public Boolean waitForWindowGetSize(int TotalWindow, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));

		return wait.until(ExpectedConditions.numberOfWindowsToBe(TotalWindow));
	}

	public void waitForFramebyLocator(By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFramebyIndex(int Index, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Index));
	}

	public void waitForFramebyName(String name, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}

	public void waitForPageLoadTimeOut(int TimeOut) {
		long TotalTime = System.currentTimeMillis() + TimeOut;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageStage = js.executeScript("return document.readyState").toString();
		while (System.currentTimeMillis() < TotalTime) {
			if (pageStage.equals("complete")) {
				System.out.println("PAGE DOM is fully loaded now....");

				break;
			} else {
				System.out.println("Page is not loded with given Timeout =" + pageStage);
			}
		}
	}

	public boolean pageLoadTimeout(int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\'complete\'"))
				.toString();
		return Boolean.parseBoolean(flag);
	}
	
	
	

	// **********************************************************************************Window
	// //
	// Handles**************************************************************************

	public void windowHandels(Actions action, By locator, ElementUtil util) {

		action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		util.doClick(locator);
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> it = Window.iterator();
		String parentWindow = it.next();
		System.out.println(parentWindow);
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		String childURl = driver.getCurrentUrl();
		System.out.println(childURl);
		driver.close();
		driver.switchTo().window(parentWindow);
		String chilURL = driver.getCurrentUrl();
		System.out.println(chilURL);
		driver.quit();
	}

	public void windowMultipleHandle(Actions action, By locator, ElementUtil util) {

		action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
		util.doeveryLinkClick(locator);
		String parenWind = driver.getWindowHandle();

		Set<String> windowID = driver.getWindowHandles();

		Iterator<String> it = windowID.iterator();
		// ArrayList<String> list=new ArrayList<String>();

		while (it.hasNext()) {
			String windowText = it.next();
			System.out.println(windowText);
			driver.switchTo().window(windowText);
			String url = driver.getCurrentUrl();
			System.out.println(url);

			if (!windowText.equalsIgnoreCase(parenWind)) {

				driver.close();
			}
		}
		driver.switchTo().window(parenWind);

		String parURL = driver.getCurrentUrl();

		System.out.println(parURL);

		driver.quit();

	}

	// ***********************************************************************************Actions**************************************************************************//

	public void dragAndDrop(By locator_drag, By locator_drop, Actions action, ElementUtil util) {

		WebElement drag_loc = util.doGetElement(locator_drag);
		WebElement drop_loc = util.doGetElement(locator_drop);

		action.clickAndHold(drag_loc).moveToElement(drop_loc).release().perform();
	}

	public void suggestionMovetoElement(ElementUtil util, Actions ac, By parent_loc, By firstLevel_locator,
			By secondLevel_locator, By target_locator) throws InterruptedException {
		util.doClick(parent_loc);
		Thread.sleep(1000);
		WebElement firstLevel = util.doGetElement(firstLevel_locator);
		ac.moveToElement(firstLevel).build().perform();
		Thread.sleep(1000);
		WebElement secondLevel = util.doGetElement(secondLevel_locator);
		ac.moveToElement(secondLevel).build().perform();
		Thread.sleep(1000);
		util.doClick(target_locator);
	}

	public void rightClick(ElementUtil util, By righClick_loc, Actions ac, By righsugg_loc, String value)
			throws InterruptedException {
		WebElement rightClick = util.doGetElement(righClick_loc);
		// Thread.sleep(1000);
		ac.contextClick(rightClick).build().perform();
		Thread.sleep(4000);
		util.doLinkClick(righsugg_loc, value);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();

	}

	public void doActionSendKeysNavigation(By firstname_loc, ElementUtil util, Actions ac, String Value_FirstName,
			String Value_LastName) {
		WebElement ac_SenKeys = util.doGetElement(firstname_loc);
		ac.sendKeys(ac_SenKeys, Value_FirstName).pause(1000).sendKeys(Keys.TAB).sendKeys(Value_LastName).pause(1000)
				.sendKeys(Keys.TAB).build().perform();
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsSendKeys(By locator, String value, Actions ac, ElementUtil util) {
		// Actions act = new Actions(driver);
		WebElement loc = util.doGetElement(locator);

		ac.sendKeys(loc, value).build().perform();
	}

	public static void doActionsClick(By locator, Actions ac, ElementUtil util) {
		// Actions act = new Actions(driver);

		WebElement locClick = util.doGetElement(locator);
		ac.click(locClick).build().perform();

	}

}
