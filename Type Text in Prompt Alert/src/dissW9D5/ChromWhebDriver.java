/**
 * @author Mawaddah Hanbali
 */
package dissW9D5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromWhebDriver {
	public WebDriver driver;

	/**
	 * Set up browser settings and open the application
	 * 
	 * @throws InterruptedException
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {
		// The path for open WebSite
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");

		// Open browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000); // To load the page
		System.out.println("Website Title: "+driver.getTitle());
	}

	/**
	 * Type-Text-in-Prompt-alert
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void LearnEnglishWebSite() throws InterruptedException {
		// String
		String text = "GOOD JOB Mawaddah";

		// Write script code
		String script = "function jsPrompt() {\n" + "var c = prompt('I am a JS prompt','" + text + "');\n"
				+ "log('You entered: ' + c);\n" + "}\n" + "  function log(msg) {\n"
				+ "    var result = document.getElementById('result');\n" + "    result.innerHTML = msg;\n" + "  }\n";

		// Create JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Add script in DOM (Document Object Model)
		js.executeScript("var s=window.document.createElement('script');" + "s.type = 'text/javascript';" + "s.text = "
				+ script + "window.document.head.appendChild(s);");

		// Find button element
		WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));

		// SetAttribute for button
		js.executeScript("arguments[0].setAttribute('onclick', 'jsPrompt()')", jsPrompt);

		// Click on the button
		js.executeScript("arguments[0].click()", jsPrompt);

		// Switch to prompt alert
		driver.switchTo().alert();

		Thread.sleep(2000); // to see the result

		// Take Alert message
		String messageText = driver.switchTo().alert().getText();

		// Click on "Ok" button
		driver.switchTo().alert().accept();

		Thread.sleep(2000); // to see the result

		// Print Alert message
		System.out.println("My Alert message is: " + messageText);
		System.out.println("My Text in message is: " + text);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterTest
	public void terminateBrowser() {
		// Close the browser
		driver.close();

		// Quite the selenium
		driver.quit();
	}
}
