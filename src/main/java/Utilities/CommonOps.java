package Utilities;

import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.jsoup.nodes.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base
{
    public static String getData(String nodeName)
    {
        DocumentBuilder dBuilder;
        org.w3c.dom.Document doc = null;
        File fXmlFile = new File("Configuration/dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType)
    {
        if (browserType.equalsIgnoreCase("chrome"))
            driver=initChromedriver();
        else if  (browserType.equalsIgnoreCase("firefox"))
            driver=initFFdriver();
        else if  (browserType.equalsIgnoreCase("ie"))
            driver=initIEdriver();
        else
            throw new RuntimeException("Invalid browserType name stated");
        driver.manage().window().maximize();
        driver.get(getData("Url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        action=new Actions(driver);
    }

    public static WebDriver initChromedriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFdriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEdriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver=new InternetExplorerDriver();
        return driver;
    }

    public static void initApi()
    {
        RestAssured.baseURI=getData("url_api");
        httpRequest=RestAssured.given().auth().preemptive().basic(getData("user"),getData("password"));
    }

    @BeforeClass
    public void startSession()
    {

        if (getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
//        else if (getData("PlatformName").equalsIgnoreCase("mobile")
//             initMobile();
        else if(getData("PlatformName").equalsIgnoreCase("api"))
            initApi();
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
    }



    @AfterClass
    public void closeSession()
    {
        if(!getData("PlatformName").equalsIgnoreCase("api"))
            driver.quit();
    }

    @AfterMethod
    public void afterMethod()
    {
        if(!getData("PlatformName").equalsIgnoreCase("api"))
        driver.get(getData("Url"));
    }
}
