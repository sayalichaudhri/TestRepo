package seleniumprogram;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		
		
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//ul[@class='h-c-header__cta-list header__nav--ltr']//a[contains(text(),'Sign in')]")).click();

		
		Set<String> allvalues=driver.getWindowHandles();
		Iterator itr=allvalues.iterator();
		for(String value:allvalues)
			while(itr.hasNext())
			{
				if(!parent.equalsIgnoreCase(value))
				{
					driver.switchTo().window(value);
					driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sayalic3011@gmail.com");
					driver.findElement(By.xpath("//span[@class='CwaK9']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
					driver.findElement(By.xpath("//span[text()='Next']")).click();
					System.out.println("password entered");
				}
				break;
			}
	}
}
