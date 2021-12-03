package cal;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Calculator {

	WebDriver driver;

	@BeforeSuite
	public void init() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.get("https://www.calculator.net/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	// Multiplication-
	@Test(priority = 1)
	public void multi() throws InterruptedException {

		String n1 = "423", n2 = "525";

		eleClick(driver, n1);

		driver.findElement(By.xpath("//span[text()='×']")).click();

		eleClick(driver, n2);

		WebElement res_Text = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
		System.out.println(n1 + " × " + n2 + " is " + res_Text.getText());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='AC']")).click();
	}

	// Division-
	@Test(priority = 2)
	public void div() throws InterruptedException {

		String n1 = "4000", n2 = "200";

		eleClick(driver, n1);

		driver.findElement(By.xpath("//span[text()='/']")).click();

		eleClick(driver, n2);

		WebElement res_Text = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
		System.out.println(n1 + " / " + n2 + " is " + res_Text.getText());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='AC']")).click();
	}
	// Addition-
	@Test(priority = 3)
	public void add() throws InterruptedException {

		String n1 = "-234234", n2 = "345345";

		eleClick(driver, n1);

		driver.findElement(By.xpath("//span[text()='+']")).click();

		eleClick(driver, n2);

		WebElement res_Text = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
		System.out.println(n1 + " + " + n2 + " is " + res_Text.getText());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='AC']")).click();
	}

	// Subtraction-
	@Test(priority = 3)
	public void sub() throws InterruptedException {

		String n1 = "234823", n2 = "-23094823";

		eleClick(driver, n1);

		driver.findElement(By.xpath("//span[contains(text(),'-')]")).click();

		eleClick(driver, n2);

		WebElement res_Text = driver.findElement(By.xpath("//div[@id='sciOutPut']"));
		System.out.println(n1 + " - " + n2 + " is " + res_Text.getText());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='AC']")).click();
	}

	@AfterSuite
	public void exit() {

		driver.close();
	}

	public void eleClick(WebDriver driver, String num){
		
		String[] arr = num.split("");
				
		for(int i=0; i<arr.length; i++){
			
			String ch = arr[i];
			
			if (ch.equals("-")) {
				
				driver.findElement(By.xpath("//span[contains(text(),'–')]")).click();
				
			}else {
				
				WebElement ele = driver.findElement(By.xpath("//span[text()='"+ ch +"']"));
				ele.click();			
			}
		}
	}

}
