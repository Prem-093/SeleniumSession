package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {

	WebDriver driver;

	public Action(WebDriver driver) {

		this.driver = driver;
	}

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
	
	public void doActionSendKeysNavigation(By firstname_loc,ElementUtil util,Actions ac,String Value_FirstName,String Value_LastName)
	{
		WebElement ac_SenKeys=util.doGetElement(firstname_loc);
		ac.sendKeys(ac_SenKeys,Value_FirstName)
		.pause(1000)
		.sendKeys(Keys.TAB)
		.sendKeys(Value_LastName)
		.pause(1000)
		.sendKeys(Keys.TAB)
		.build().perform();		
	}
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value,Actions ac,ElementUtil util) {
		//Actions act = new Actions(driver);
		WebElement loc=util.doGetElement(locator);
		
		ac.sendKeys(loc, value).build().perform();
	}
	
	

	public static void doActionsClick(By locator,Actions ac,ElementUtil util) {
		//Actions act = new Actions(driver);
		
		WebElement locClick=util.doGetElement(locator);
		ac.click(locClick).build().perform();
		
	}
		
	

	public static void main(String[] args) throws InterruptedException {

		LaunchCrossBrowser lb = new LaunchCrossBrowser();
		WebDriver driver = lb.launchBrowser("chrome");

		Action action = new Action(driver);

		ElementUtil util = new ElementUtil(driver);

		// driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Thread.sleep(3000);

		By righsugg_loc = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");

		By parent_loc = By.xpath("(//span[text()='Shop by'])[2]");

		By righClick_Sugg_loc = By.linkText("Paste");

		Thread.sleep(1000);
		Actions ac = new Actions(driver);

		By righClick_loc = By.xpath("//span[text()='right click me']");

		By firstLevel = By.linkText("Food Court");

		Thread.sleep(1000);

		By secondLevel = By.linkText("Cold Beverages");

		Thread.sleep(1000);

		By target_locator = By.linkText("Smoothies & Shakes");

		// action.rightClick(util, righClick_loc, ac, righsugg_loc, "Copy");

		By firstname_loc = By.id("input-firstname");

		/*
		 * ac.sendKeys(driver.findElement(firstname_loc),
		 * "Prem").sendKeys(Keys.TAB).pause(1000).sendKeys("Tripathi")
		 * .sendKeys(Keys.TAB).build().perform();
		 */
		
		action.doActionSendKeysNavigation(firstname_loc, util, ac, "Prem", "Tripathi");

	}

}
