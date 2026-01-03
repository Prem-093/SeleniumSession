package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	WebDriver driver;

	public DropDown(WebDriver driver) {
		this.driver = driver;
	}

	public void doselectByVisisbleText(By locator, String value, ElementUtil elementUtil) throws InterruptedException {

		WebElement drdoLOC = elementUtil.doGetElement(locator);
		Thread.sleep(3000);
		Select select = new Select(drdoLOC);
		select.selectByVisibleText(value);

	}

	public boolean getTotalCountDropDown(By locator, ElementUtil elementUtil) {
		boolean flag;
		/// ElementUtil elementUtil = new ElementUtil(driver);
		WebElement drdoLOC = elementUtil.doGetElement(locator);
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

	public boolean doClickByGetOption(By locator, ElementUtil elementUtil, String value) throws InterruptedException {
		WebElement dropdwLoc = elementUtil.doGetElement(locator);

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

	public void doSelectWithoutSelect(By locator , ElementUtil elementUtil,By locators) {
		
		WebElement dropLocator= elementUtil.doGetElement(locator);
		List<WebElement>   dropDownListOption=elementUtil.getElements(locators);
		System.out.println(dropDownListOption.size());
		for(WebElement e: dropDownListOption )
		{
			String optionText=e.getText();
			System.out.println(optionText);
		
		if(optionText.contains("India")) {
			
			e.click();
			break;
		}
		
		}
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {

		LaunchCrossBrowser br = new LaunchCrossBrowser();
		WebDriver driver = br.launchBrowser("chrome");
		ElementUtil elementUtil = new ElementUtil(driver);

		driver.get("https://www.orangehrm.com/30-day-free-trial/");

		By dropLoc = By.name("Country");
		
		By optionsLoc=By.xpath("//select[@class='dropdown']/option");

		DropDown drdp = new DropDown(driver);
		// Select select=new Select(dropLoc);
		//drdp.doClickByGetOption(dropLoc, elementUtil, "Angola");
		
		drdp.doSelectWithoutSelect(dropLoc,elementUtil,optionsLoc);

		// ElementUtil elementUtil = new ElementUtil(driver);

		// drdp.getTotalCountDropDown(dropLoc, elementUtil);
		// drdp.doselectByVisisbleText(dropLoc, "India");

		// WebElement locDrDo=driver.findElement(By.name("Country"));

		// Select select=new Select(locDrDo);

		// select.selectByVisibleText("India");
		// select.selectByIndex(8);
		// select.selectByValue("Yemen");
		/*
		 * List<WebElement> drdpList=select.getOptions();
		 * 
		 * int dropSize=drdpList.size(); System.out.println(dropSize-1);
		 */
	}

}
