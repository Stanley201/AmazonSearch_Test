package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchPage_Test {

    //Import the selenium Webdriver
    private WebDriver driver;

    //function before test commence
    @BeforeClass

    //Class
    public void setUp() throws InterruptedException {

        // setup the location of the chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //launch the chromedriver
        driver = new ChromeDriver();

        // Input the website URL "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        //wait for 5 seconds for the page to load
        Thread.sleep(5000);

        //Maximize the page
        driver.manage().window().maximize();

        // Get the page title
        System.out.println(driver.getTitle());

        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Test annotation
    @Test
    public void SearchPageTest() throws InterruptedException {
        //Locate the searchBox and input "shoes".
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" shoes");
        //Click on search Button
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Wait for 5 seconds to see the page is loaded
        Thread.sleep(5000);
        //test to confirm that the page loads the shoes succesfully
        if(driver.getCurrentUrl ().contains ("shoes")) {
            System.out.println ("PASSED - the page has successfully load");
        }else{
            System.out.println ("FAILED - The page was unable to load successfully");
        }

        Thread.sleep (5000);

    }
    // function after the test commence
    @AfterTest
    //Close the Browser
    public void CloseBrowser() throws InterruptedException{
        driver.close();
    }

}
