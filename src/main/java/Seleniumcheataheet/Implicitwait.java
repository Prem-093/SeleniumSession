package Seleniumcheataheet;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Implicitwait {
	
	//implisitwait is global wait
	//it can not be apply on particular element
	//at the momen we write drver.manage.timeout.implicitlywait(Duration.milis of seconds) it wll apply on all element
	//it can not be apply on non web element(url,title.....)
	
	static WebDriver driver;

	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver=new ChromeDriver();
		
		

	}

}
