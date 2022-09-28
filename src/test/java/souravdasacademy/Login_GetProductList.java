package souravdasacademy;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_GetProductList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sourav92.sd@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Newtown@2060");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Thread.sleep(3000);
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Let's Shop", title);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mb-3')]")));
		List<WebElement> products=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		//System.out.println(products);
		Thread.sleep(3000);
		//java stream
		WebElement addidas=products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original")).findFirst().orElse(null);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
		/*WebElement prod = products.stream()

				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()

				.orElse(null);	*/
		
		Thread.sleep(3000);
	
		//System.out.println(addidas);
	addidas.findElement(By.xpath("//b[text()='adidas original']/following::*[5]")).click();
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	
	WebElement prod = products.stream()

			.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()

			.orElse(null);
	Thread.sleep(3000);
	prod.findElement(By.xpath("//b[text()='zara coat 3']/following::*[5]")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	Thread.sleep(1000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();
	

	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));
	//to verify addias shoe in the cart
	List<WebElement> product_cart=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	//List<WebElement> product_cart=driver.findElements(By.xpath("//div[@class='cartSection']"));
	Thread.sleep(3000);
	System.out.println(product_cart);
	Boolean a=product_cart.stream().anyMatch(product1 -> product1.getText().equalsIgnoreCase("zara coat 3"));
	//System.out.println(a);
	//WebElement prod1=product_cart.stream().filter(product1 -> product1.findElement(By.xpath("//h3")).getText().equalsIgnoreCase("adidas original")).findAny().orElse(null);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));
	//System.out.println(prod1);
	Thread.sleep(3000);
	Assert.assertTrue(a);
	driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Credit Card']"))));
	WebElement credit_card=driver.findElement(By.xpath("//*[text()='Credit Card Number ']/following-sibling::*[1]"));
	Thread.sleep(3000);
	credit_card.clear();
	Thread.sleep(3000);
	credit_card.sendKeys("1111 2222 3333 4444");
	Thread.sleep(3000);
	Select month=new Select(driver.findElement(By.xpath("//div[contains(text(),'Expiry Date')]/following::*[1]")));
	month.selectByVisibleText("07");
	Thread.sleep(3000);
	Select year=new Select(driver.findElement(By.xpath("//div[contains(text(),'CVV Code')]/parent::*[1]/preceding-sibling::*[1]/child::*[3]")));
	year.selectByVisibleText("29");
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
	Actions a1=new Actions(driver);
	a1.sendKeys(element,"India").build().perform();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'ta-results')]")));
	driver.findElement(By.xpath("//section[contains(@class,'ta-results')]/button[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
	Thread.sleep(3000);
	WebElement element1=driver.findElement(By.xpath("//*[contains(text(),'Thankyou for the')]"));
	wait.until(ExpectedConditions.visibilityOf(element1));
	
	String first_order=driver.findElement(By.xpath("(//*[contains(@class,'ng-star-inserted')])[3]")).getText();
	Thread.sleep(3000);
	String second_order=driver.findElement(By.xpath("(//*[contains(@class,'ng-star-inserted')])[4]")).getText();
	
	System.out.println(first_order);
	System.out.println(second_order);
	

	driver.close();
	
	}

}
