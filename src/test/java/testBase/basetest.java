package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger; //log file
import org.apache.logging.log4j.LogManager;  //log file
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.beust.jcommander.Parameter;


public class basetest {
	
	public Properties p;

	public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();;
	public Logger logger;
	public JavascriptExecutor js;
	public static WebDriver getDriver() {
        return driver.get();
    }
	
	@BeforeMethod
	@Parameters({"browser","os"})
	public void login(String br, String os) throws IOException {
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		WebDriver localDriver = null;
		

		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities cap = new DesiredCapabilities();
			switch(os) {
			case "Windows": cap.setPlatform(Platform.WIN11);break;
			case "mac": cap.setPlatform(Platform.MAC);break;
			case "linux": cap.setPlatform(Platform.LINUX);break;
			default :System.out.println("No matching os"); return;		    }
			switch(br.toLowerCase()) {
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default :System.out.println("No matching browser"); return;	
			
			}
			localDriver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);

		}
		
		
			if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		switch(br.toLowerCase()) {
		case "chrome" : localDriver =new ChromeDriver(); break;
		case "edge" : localDriver =new EdgeDriver(); break;
		default :System.out.println("invalid browser"); return;
		
		
		}
			}
		
			driver.set(localDriver);
		WebDriverWait mywait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
	
		getDriver().get(p.getProperty("appurl1"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js= (JavascriptExecutor) getDriver();
		}
		
	
	
	
	

	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	
	public String RandomString() {
		String RandomStr=RandomStringUtils.randomAlphabetic(6);
		return RandomStr;
	}
	
	public String RandomNumber()
	{
		String RandomNum=RandomStringUtils.randomNumeric(8);
		return RandomNum;
	}
	

	public String RandomAlphaNumber()
	{
		String RandomAlpha=RandomStringUtils.randomAlphanumeric(9);
		return RandomAlpha;
	}
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

	
	
	
	
	
	
	
	
	
}
