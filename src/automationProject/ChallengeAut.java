package automationProject;


import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChallengeAut {

	private WebDriver driver = new FirefoxDriver();
	private String baseUrl = "https://juice-shop.herokuapp.com";

	
	@Before
	public void setUp() throws Exception 
	{
		System.setProperty("webdriver.gecko.driver", "//Users/ramoncardenas/Documents/Drivers_Automation/geckodriver");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		Thread.sleep(2000);
				
	}

	
	/////////////////////////////To Validate Welcome Popup Window
	@Test
	public void test1WelcomeWindow() throws InterruptedException 
	{
		//driver.get(baseUrl);
		//Thread.sleep(2000);
		
		 	 
		 //Validate Welcome pop up window is present
		if (driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]")).isDisplayed()) {
			System.out.println("Element is present");
			
		}
		else {
			System.out.println("Element is NOT present");
			driver.close();
		}
		
		//Validate Dismiss button is present and click
		
		if (driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).isDisplayed()){
			System.out.println("Button is present");
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).click();
		}
		else {
			System.out.println("Button is NOT present");
			driver.close();
			
		}
			
		
		//Validate  Coockie Banner
	
		if (driver.findElement(By.xpath("/html/body/div[1]")).isDisplayed()) {
					System.out.println("Cookie element is present");
					
				}
		else {
				System.out.println("Coockie element is NOT present");
				driver.close();
				}
				
		//Validate Me Want it button is present and click
				
		if (driver.findElement(By.xpath("/html/body/div[1]/div/a")).isDisplayed()){
					System.out.println("Button accept is present");
					driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
					
				}
		else {
				System.out.println("Button accept is NOT present");
				driver.close();
				}
				
		
		}

	
	////////////////////////////////Validate Main Logo
	@Test
	public void test2MainLogo() throws InterruptedException {
		

		//driver.get(baseUrl);
		//Thread.sleep(2000);
		
		boolean logo   = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[2]")).isDisplayed();
		
		if (logo) {
			System.out.println("Page main logo is present");
		}
		else {
			System.out.println("Main Logo is not present");
		}
		
		
	}
	
		
	//////////////////////////Validate Magnifying glass
	@Test
	 
	public void test3MagnifyingGlass() throws InterruptedException {
		
		//driver.get(baseUrl);
		//Thread.sleep(2000);
		
		 //Validate Welcome pop up window is present
		if (driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]")).isDisplayed()) {
			System.out.println("Element is present");
			
		}
		else {
			System.out.println("Element is NOT present");
			driver.close();
		}
		
		//Validate Dismiss button is present and click
		
		if (driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).isDisplayed()){
			System.out.println("Button is present");
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).click();
		
		}
		else {
			System.out.println("Button is NOT present");
			driver.close();
			
		}
			
		
		////Validate  Coockie Banner
	
		if (driver.findElement(By.xpath("/html/body/div[1]")).isDisplayed()) {
					System.out.println("Cookie element is present");
					
				}
		else {
				System.out.println("Coockie element is NOT present");
				driver.close();
				}
				
		//Validate Me Want it button is present and click
				
		if (driver.findElement(By.xpath("/html/body/div[1]/div/a")).isDisplayed()){
					System.out.println("Button accept is present");
					driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
					
				}
		else {
				System.out.println("Button accept is NOT present");
				driver.close();
				}
				
		/////////////////Validating Magnifying Glass
		
		if (driver.findElement(By.id("searchQuery")).isDisplayed()) 
			{
				System.out.println("Magnifyin glass is present");
				driver.findElement(By.id("searchQuery")).click();
				Thread.sleep(1000);
				
				//Find text field
				if(driver.findElement(By.xpath("//*[@id=\"searchQuery\"]/mat-form-field/div/div[1]")).isDisplayed())
					{
					System.out.println("Text Field is displayed");
					driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("banana" + Keys.ENTER);
					}
				else {
					System.out.println("I could enter text");
					}
				
				

				///Validate if the Search Results has what I entered
				WebElement searchField = driver.findElement(By.id("searchValue"));
				String elementText = searchField.getText();
				System.out.println("Text element: " + elementText);
		
		
				if(elementText.equals("banana")) {
					System.out.println("Search value is equal to data entered");
				}
				else {
					System.out.println("Values are not matching");
				}
				
				//Validate name of the product is equal to data entered
				WebElement productName = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile/div/mat-card/div[1]/div[2]/div[1]"));
				String productLabel = productName.getText();
				
				if(productLabel.contains("banana")) {
					System.out.println("Product label contains word entered");
					
				}else {
					System.out.println("Product name does not has correct word");//HERE I THINK I HAVE AN ERROR--->>>
				}
				
																			
			}
		
		else 
			{
			System.out.println("Magnifying glass not present");
			}
		}

	
		//Login FAILED Validation with incorrect password and email ////accountButton
		@Test
		public void test4LoginValidatoin() throws InterruptedException{
			
			
			 //Validate Welcome pop up window is present
			if (driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]")).isDisplayed()) {
				System.out.println("Element is present");
				
			}
			else {
				System.out.println("Element is NOT present");
				driver.close();
			}
			
			//Validate Dismiss button is present and click
			
			if (driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).isDisplayed()){
				System.out.println("Button is present");
				driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/app-welcome-banner/div/div[2]/button[2]")).click();
			
			}
			else {
				System.out.println("Button is NOT present");
				driver.close();
				
			}
				
			
			////Validate  Coockie Banner
		
			if (driver.findElement(By.xpath("/html/body/div[1]")).isDisplayed()) {
						System.out.println("Cookie element is present");
						
					}
			else {
					System.out.println("Coockie element is NOT present");
					driver.close();
					}
					
			//Validate Me Want it button is present and click
					
			if (driver.findElement(By.xpath("/html/body/div[1]/div/a")).isDisplayed()){
						System.out.println("Button accept is present");
						driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
						
					}
			else {
					System.out.println("Button accept is NOT present");
					driver.close();
					}
			
			
			//Find Account button and click
			driver.findElement(By.id("navbarAccount")).click();
			Thread.sleep(1000);
			
			
			//Validate if Login button is displayed
			if(driver.findElement(By.id("mat-menu-panel-0")).isDisplayed()) {
				driver.findElement(By.id("mat-menu-panel-0")).click();
			}
			else {
				System.out.println("Login button not displayed");
				driver.quit();
			}
			
			//Verify Login box container is displayed
			if(driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-login/div/mat-card")).isDisplayed())
			{
				//Validate Email text box is displayed send email
				if(driver.findElement(By.id("email")).isDisplayed())
				{
					driver.findElement(By.id("email")).sendKeys("email@emmail.com");
				}
				else
				{
					System.out.println("Email field not present");
					driver.quit();
				}
				
				//Validate Password field is present
				if(driver.findElement(By.id("password")).isDisplayed())
				{
					driver.findElement(By.id("password")).sendKeys("Password");
				}
				else
				{
					System.out.println("Password field not present");
					driver.quit();
				}
				
				//Validate Login button is enable and click
				if (driver.findElement(By.id("loginButton")).isEnabled()) 
				{
					driver.findElement(By.id("loginButton")).click();
				}
				else
				{
					System.out.println("Login button is not enable");
				}
				
				//Validate "Invalid email or password." message is displayed
				WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-login/div/mat-card/div[1]"));
				String redError = errorMessage.getText();
				System.out.println("Text element: " + redError);
		
		
				if(redError.equals("Invalid email or password.")) 
				{
					System.out.println("Validaton pass correct message displayed");
				}
				else
				{
					System.out.println("Warning message not displayed");
					driver.quit();
				}
								
			}
			else
			{
				System.out.println("Login module section is not present");
				driver.quit();
			}
				
			
			
			
			
		
		}

	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
