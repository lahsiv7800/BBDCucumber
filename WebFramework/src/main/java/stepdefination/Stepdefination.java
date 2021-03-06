package stepdefination;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class Stepdefination {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
//-----------------------------------------------------------------------------------	
	@Given("User prepares get request to get {string} pets in pet store")
	public void user_prepares_get_request_to_get_pets_in_pet_store(String available) {
	    res=given().queryParam("status",available).accept("application/json");	}
	
	@When("Get request is triggered sucessfully")
	public void get_request_is_triggered_sucessfully() {
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=res.when().get("https://petstore.swagger.io/v2/pet/findByStatus");
    }

	@Then("status code should be verify")
	public void status_code_should_be_verify() {
		assertEquals(response.getStatusCode(),200);
	}

	@Then("Verify status {string} in the response body")
	public void verify_status_in_the_response_body(String expstatus) {
		JsonPath jp= new JsonPath(response.asString());
	    String actStatus;
	    int arrSizze=jp.getInt("$.size");
	    for(int i=0;i<arrSizze;i++) {
	    	actStatus=jp.getString("["+i+"].status");
	    	assertEquals(actStatus,expstatus);
	    }
	}
//-----------------------------------------------------------------------------------		
	@Given("User Prepars POST request to post new pet in store")
	public void user_Prepars_POST_request_to_post_new_pet_in_store() {
		res=given().body("{\r\n" + 
				"  \"id\": 1221,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"Cheeta\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"doggie\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"Cheeta\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"Cheeta\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"available\"\r\n" + 
				"}").accept("application/json");	
	}

	@When("POST request is triggered sucessfully")
	public void post_request_is_triggered_sucessfully() {
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=res.when().post("https://petstore.swagger.io/v2/pet");
	}

	@Then("Assert newly addes pet to store")
	public void assert_newly_addes_pet_to_store(String exppetname) {
		JsonPath jp= new JsonPath(response.asString());
		exppetname = "Cheeta";
	    String actpetName=jp.getString("name");
	    assertEquals(actpetName,exppetname);
	 }
//-----------------------------------------------------------------------------------------------------------------------
	@Given("User Prepars PUT request to post new pet in store")
	public void user_Prepars_PUT_request_to_post_new_pet_in_store() {
		res=given().body("{\r\n" + 
				"  \"id\": 1221,\r\n" + 
				"  \"category\": {\r\n" + 
				"    \"id\": 0,\r\n" + 
				"    \"name\": \"Cheeta\"\r\n" + 
				"  },\r\n" + 
				"  \"name\": \"doggie\",\r\n" + 
				"  \"photoUrls\": [\r\n" + 
				"    \"Cheeta\"\r\n" + 
				"  ],\r\n" + 
				"  \"tags\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 0,\r\n" + 
				"      \"name\": \"Cheeta\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"status\": \"sold\"\r\n" + 
				"}").accept("application/json");	
	    }
	@When("PUT request is triggered sucessfully")
	public void put_request_is_triggered_sucessfully() {
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=res.when().put("https://petstore.swagger.io/v2/pet");
	}
	
	@Then("Asserts newly added pets status {string} in the response")
	public void asserts_newly_added_pets_status_in_the_response(String expected) {
	    expected = "sold";
	    JsonPath jp= new JsonPath(response.asString());
		String actStatus=jp.getString("available");
	    assertEquals(actStatus,expected);
	}
	
//-----------------------------------------------------------------------------------------------------------------
    
	private static WebDriver driver;
	Screenshot screenshot = new AShot().takeScreenshot(driver);
	public static void launch() {
	  System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
	  driver=new ChromeDriver(); 
	  driver.navigate().to("https://www.demoblaze.com/index.html");
	  driver.manage().window().maximize();  
	}

	@Given("User navigates through product categories")
	public void user_navigate_through_product_categories() {
	 launch();	  
	 System.out.println("-----User navigates to Phones Section--------");
	 driver.findElement(By.linkText("Phones"));
	 System.out.println("-----User navigates to Laptop Section--------");
	 driver.findElement(By.linkText("Laptop"));
	 System.out.println("-----User navigates to Monitor Section--------");
	 driver.findElement(By.linkText("Monitors"));
	}

	@When("User adds laptops into the shopping cart")
	public void user_adds_laptops_into_the_shopping_cart() {
		System.out.println("-----User navigates to Laptop Section--------");
		driver.findElement(By.linkText("Laptop"));
		System.out.println("-----User clicks on Sony vaio i5--------");
		driver.findElement(By.xpath("//a[@class='hrefch']"));
		driver.findElement(By.cssSelector("[class='btn btn-success btn-lg']"));
		driver.switchTo().alert().accept();
		System.out.println("-----User navigates to Laptop Section--------");
		driver.findElement(By.linkText("Laptop"));
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[4]/div/div/h4/a"));
		driver.findElement(By.cssSelector("[class='btn btn-success btn-lg']"));
		driver.switchTo().alert().accept();
	}

	@When("User deletes laptop from the cart")
	public void user_deletes_laptop_from_the_cart() {
		driver.findElement(By.xpath("//a[@id='cartur']"));
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[3]/td[4]/a")).click();
	}

	@When("Click on place order")
	public void click_on_place_order() {
	  System.out.println("-----User Clicks on place order--------");	
	  driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	}

	@Then("User fills web form and clicks on purchase")
	public void user_fills_web_form_and_clicks_on_purchase() throws IOException {
		System.out.println("-----User Enters on Web Forms--------");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vishal");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("12673822222");
		driver.findElement(By.xpath("//input[@id='Months']")).sendKeys("September");
		driver.findElement(By.xpath("//input[@id='Year']")).sendKeys("2020");
		System.out.println("-----User Enters on Purchase Button--------");
		driver.findElement(By.xpath("//class[@class='btn btn-primary']")).click();
		// Find the element to take a screenshot
		WebElement element = driver.findElement(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']"));
		// Along with driver pass element also in takeScreenshot() method
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
		ImageIO.write(screenshot.getImage(), "jpg", new File("c:\\ElementScreenshot.jpg"));
	}

	@Then("User asserts purchase amount and clicks Ok.")
	public void user_asserts_purchase_amount_and_clicks_Ok() {
	   driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getAttribute("Amount: 790 USD").split(":");
	   driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
	   driver.close();
       driver.quit();
	}
	
	
}






