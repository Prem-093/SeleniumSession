package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("--headless");
		//		
	   // co.addArguments("--incognito");
//		ChromeDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		String title=driver.getTitle();
		System.out.println(title);
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.close();
		
		

	}

}
