package MyPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelWeb {

	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vira\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.akbartravels.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//section[@class='search-container']//form//div[@class='firstbox']/mat-radio-group[@role='radiogroup']/mat-radio-button[2]")).click();
		driver.findElement(By.xpath("//section[@class='search-container']//form//div//ul[@class='ow-row']//li[@id='liFrom']//div//label[contains(text(),'FROM')]")).click();
		if(driver.findElement(By.xpath("//input[@placeholder='From']")).isEnabled())
		{
		System.out.println("Avijit");	
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Dubai");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element1=driver.findElement(By.xpath("//strong[contains(text(),'DXB')]"));
		if(element1.isEnabled())
		{
		element1.click();
		}
		driver.findElement(By.xpath("//section[@class='search-container']//form//div//ul[@class='ow-row']//li[@id='liTo']//div//label[contains(text(),'TO')]")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//System.out.println("Avijit");	
		driver.findElement(By.xpath("//input[@placeholder='To' and @name='sectortype']")).sendKeys("New York");
		WebElement element2=driver.findElement(By.xpath("//strong[contains(text(),'NYC')]"));
		if(element2.isEnabled())
		{
		element2.click();
		}
		/*
		 * driver.switchTo().frame(0); //WebElement element=driver.findElement(By.xpath(
		 * "/html/body/app-root/app-layout/div[2]/flight-home/home-header/header/div/flight-search/section/form/div[2]/ul/li[1]/div/h6"
		 * )); System.out.println(driver.findElement(By.xpath(
		 * "//div[@class='mat-radio-label-content']//span//text()")).getText());
		 *///driver.switchTo().frame();
		
		//element.sendKeys("Dubai");
		
		
		

	}

}
