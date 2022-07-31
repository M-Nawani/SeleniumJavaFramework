package com.mystore.baseclass;

import com.mystore.utilities.ExtentReportSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties property;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeSuite(groups = {"Smoke","Sanity","Regression"})
    public void loadConfig(){
        property = new Properties();
        // ExtentReportSetup.setupReport();
        try{
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/Configuration/Config.properties");
            property.load(file);
        }
        catch (FileNotFoundException e){
            System.out.println("Error message" + e.getMessage());
            e.printStackTrace();
        }
        catch(IOException e){
            System.out.println("Error message" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void launchApp(String browser){
        // String browser = property.getProperty("browser");
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        else if(browser.equalsIgnoreCase("Safari")){
            WebDriverManager.safaridriver().setup();
            driver.set(new SafariDriver());
        }

        getDriver().get(property.getProperty("url"));
        getDriver().manage().window().maximize();

    }

}
