package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	
	@BeforeClass
	public void bc() throws IOException {
		String browserName = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
        
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Launch the browser");
		driver.get(url);
		System.out.println("Navigate to the URL");
	}
	
	@AfterClass
	public void ac() {
		driver.quit();
		System.out.println("Close the browser");
	}
	

}
