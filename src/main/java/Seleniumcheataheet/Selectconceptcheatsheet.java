package Seleniumcheataheet;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectconceptcheatsheet {

	static WebDriver driver;

	public static void dropdownSelectbyText(By locator, String value) {
		WebElement element = driver.findElement(locator);

		Select select = new Select(element);
		select.selectByVisibleText(value);
		//select.selectByIndex(0);
		
	}

	public static void dropdownSelectbyvalue(By locator, String value) {
		WebElement element = driver.findElement(locator);

		Select select = new Select(element);
		select.selectByValue(value);
		// select.selectByVisibleText(value);
	}

	public static void dropdowndeSelectbyvalue(By locator, String value) {
		WebElement element = driver.findElement(locator);

		Select select = new Select(element);
		select.deselectByValue(value);
		// select.selectByVisibleText(value);
	}

	public static boolean checkIsMultiple(By locator) {
		driver.manage().window().maximize();

		WebElement element = driver.findElement(locator);

		Select select = new Select(element);

		return select.isMultiple();

	}

	public static void selectMultipledropDown(By locator, String value1, String value2, String value3) {

		WebElement element = driver.findElement(locator);
		Select select = new Select(element);

		select.selectByVisibleText(value1);
		select.selectByVisibleText(value2);
		select.selectByVisibleText(value3);
	}

	public static ArrayList<String> toGetAllSelectedOption(By locator) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);

		List<WebElement> selectOptionList = select.getAllSelectedOptions();

		ArrayList<String> textlist = new ArrayList<String>();

		for (WebElement e : selectOptionList) {
			String text = e.getText();
			textlist.add(text);
		}
		return textlist;
	}

	public static ArrayList<String> toGettOptions(By locator) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		List<WebElement> list_option = select.getOptions();
		ArrayList<String> list = new ArrayList<String>();

		for (WebElement e : list_option) {
			String text = e.getText();
			list.add(text);
		}

		return list;
	}

	public static ArrayList<String> selectoptiobyGettOptions(By locator) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		List<WebElement> list_option = select.getOptions();
		ArrayList<String> list = new ArrayList<String>();

		for (WebElement e : list_option) {
			String text = e.getText();
			list.add(text);
			if (text.equalsIgnoreCase("wednesday")) {
				e.click();
				break;

			}

		}

		return list;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		// driver.get("https://www.orangehrm.com/30-day-free-trial/");
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		// By dropDownloc = By.name("Country");
		By dropdown_loc = By.xpath("(//select[contains(@class,'form-control')])[2]");

		By multileloc = By.xpath("//select[@id='multi-select']");

		// dropdownSelectbyText(dropDownloc,"India");
		// dropdownSelectbyvalue(dropDownloc,"India");
		// dropdowndeSelectbyvalue(dropDownloc,"India");// You may only deselect options
		// of a multi-select
		Boolean flag = checkIsMultiple(multileloc);
		System.out.println(flag);
		selectMultipledropDown(multileloc, "New York", "Texas", "Washington");
		ArrayList<String> selectText = toGetAllSelectedOption(multileloc);
		System.out.println(selectText);

		ArrayList<String> text = toGettOptions(dropdown_loc);
		System.out.println(text);
		selectoptiobyGettOptions(dropdown_loc);
	}

}
