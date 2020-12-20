package WebdriverScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class webscenario {
	public static WebDriver driver;
	public static void main(String[] args) {
//	 System.setProperty("webdriver.chrome.driver", "D:\\Jars\\chromedriver.exe");
//	 ChromeDriver driver1=new ChromeDriver();  
	 InternetExplorerDriver driver2=new InternetExplorerDriver();  
//	 driver1.navigate().to("http://www.javatpoint.com/");  
//	 driver1.manage().window().maximize();  
	 System.setProperty("webdriver.ie.driver", "D:\\Jars\\IEDriverServer.exe");
	 driver2.navigate().to("http://www.javatpoint.com/");  
	 driver2.manage().window().maximize();  
	}

}
