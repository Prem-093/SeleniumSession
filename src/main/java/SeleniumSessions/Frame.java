package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frame {

	WebDriver driver;

	public Frame(WebDriver driver) {

		this.driver = driver;
	}

	public void frameImgClickConcept(By locator, ElementUtil elemetUtil, By FrameLocator, By FrameTextLocator,
			String Value) {
		elemetUtil.doClick(locator);
		WebElement frameLocator = elemetUtil.doGetElement(FrameLocator);
		driver.switchTo().frame(frameLocator);
		elemetUtil.doSendKeys(FrameTextLocator, Value);
	}

	public static void main(String[] args) throws InterruptedException {
		LaunchCrossBrowser LcBrowser = new LaunchCrossBrowser();
		WebDriver driver = LcBrowser.launchBrowser("Chrome");

		ElementUtil elemetUtil = new ElementUtil(driver);
		Frame frame = new Frame(driver);

		// driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		driver.get("http://selectorshub.com/iframe-and-nested-iframe/");

		WebElement pact2Frame = driver.findElement(By.xpath("//iframe[@id='pact2']"));

		driver.switchTo().frame(pact2Frame);

		driver.findElement(By.xpath("//input[@id='jex']")).sendKeys("Hi");

		WebElement patct3Frame = driver.findElement(By.xpath("//iframe[@id='pact3']"));

		driver.switchTo().frame(patct3Frame);

		driver.findElement(By.id("glaf")).sendKeys("Hi Prem");

		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@id='jex']")).sendKeys("Hi tripathi");

		driver.switchTo().defaultContent();

		driver.findElement(By.id("inp_val")).sendKeys("hi tiwari ji");

		// driver.findElement(By.xpath("//iframe[@id='pact2']"));

		// By
		// ImgClick=By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']");

		// Thread.sleep(5000);
		// By frameElement=By.xpath("//iframe[@id='frame-one748593425']");
		// driver.switchTo().frame(frameElement);
		// By FrameText=By.xpath("//input[@id='RESULT_TextField-1']");//Exception in
		// thread "main" org.openqa.selenium.NoSuchElementException: no such element:
		// Unable to locate element:
		// {"method":"xpath","selector":"//input[@id='RESULT_TextField-1']"}
		// frame.frameImgClickConcept(ImgClick,elemetUtil,frameElement,FrameText,"Hello");

		//// iframe[@id='frame-one748593425']
	}

}
