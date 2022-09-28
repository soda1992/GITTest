package souravdasacademy;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Demo {

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
		System.out.println(" Soda");
		System.out.println("Soda is busy");
		System.out.println("Git");
		
		System.out.println("Git");
		System.out.println("Git");
		System.out.println("Git");
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	
	WebElement prod = products.stream()

			.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()

			.orElse(null);
	Thread.sleep(3000);
	prod.findElement(By.xpath("//b[text()='zara coat 3']/following::*[5]")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@routerlink='/dashboard/cart']")).click();
	

	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));
	//to verify addias shoe in the cart
	//List<WebElement> product_cart=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
List<WebElement> product_cart=driver.findElements(By.xpath("//div[@class='cartSection']"));
	Thread.sleep(3000);
	//System.out.println(product_cart);
	//Boolean a=product_cart.stream().anyMatch(product1 -> product1.getText().equalsIgnoreCase("zara coat 3"));
	//System.out.println(a);
	
	
//mySet=driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
//System.out.println(a);
	//WebElement prod1=product_cart.stream().filter(product1 -> product1.findElement(By.xpath("//h3")).getText().equalsIgnoreCase("adidas original")).findAny().orElse(null);
	WebElement prod1=product_cart.stream().filter(product1 -> product1.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
	System.out.println(prod1.getText());
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cartSection']/h3")));
	//System.out.println(prod1);
	Thread.sleep(3000);
	//Assert.assertTrue(a);
	driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	Thread.sleep(3000);
	driver.close();
	
	}

}
