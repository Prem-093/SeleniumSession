package Seleniumcheataheet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	static WebDriver driver;

	public static int rowcountinTable() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		return list.size();
	}

	public static void traverseColumn() {
		String Beforexpath = "//*[@id=\"customers\"]/tbody/tr[";
		String Afetrxpath = "]/td[1]";
		for (int i=2; i<=rowcountinTable(); i++) {
			String TotalXpath =Beforexpath+i+Afetrxpath;

			System.out.println(TotalXpath);
			List<WebElement> columnlist = driver.findElements(By.xpath(TotalXpath));
			for (WebElement e : columnlist) {
				String text = e.getText();
				System.out.println(text);
			}
			//System.out.println(text);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		traverseColumn();

	}

}
