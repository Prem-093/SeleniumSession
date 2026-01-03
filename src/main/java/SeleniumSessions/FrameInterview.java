package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameInterview {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://selectorshub.com/iframe-and-nested-iframe/");
		
		WebElement frame1=driver.findElement(By.xpath("//iframe[@id='pact2']"));
		driver.switchTo().frame(frame1);//name,index,webelement
		driver.findElement(By.id("jex")).sendKeys("firstuser");
		WebElement frame2=driver.findElement(By.xpath("//iframe[@id='pact3']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("glaf")).sendKeys("seconduser");
		driver.switchTo().parentFrame();
		driver.findElement(By.id("jex")).clear();
		driver.findElement(By.id("jex")).sendKeys("thirduser");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("inp_val")).sendKeys("Infosys");
		
		
		
		
	}

}
