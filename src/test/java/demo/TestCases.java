package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException{
        Thread.sleep(2000);
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement name = driver.findElement(By.xpath("//div[@class='Xb9hP']/input[@type='text']"));
        Wrappers.enterString(name, "Ashish Sachan");
        Thread.sleep(2000);
        System.out.println("Name Entered");
    }

    @Test
    public void testCase02() throws InterruptedException{
        WebElement practiceAutomation = driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
        String reason = "I want to be the best QA Engineer";
        long epochtime=System.currentTimeMillis()/1000;
        String timeString = String.valueOf(epochtime);
        Thread.sleep(2000);
        Wrappers.enterString(practiceAutomation, reason+" "+timeString);
        Thread.sleep(2000);
    }
     
    @Test
    public void testCase03() throws InterruptedException{
        
        Wrappers.clickRadio(driver, "3 - 5");
        Thread.sleep(2000);
    }

    @Test
    public void testCase04() throws InterruptedException{
        
        Wrappers.clickCheckBox(driver, "Java");
        Thread.sleep(2000);
        Wrappers.clickCheckBox(driver, "Selenium");
        Thread.sleep(2000);
        Wrappers.clickCheckBox(driver, "TestNG");
        Thread.sleep(2000);
    }
    
    @Test
    public void testCase05() throws InterruptedException{
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[contains(@class,'t9kgXb')]"));
        dropDownMenu.click();
        Wrappers.dropDownOption(driver, "Mr");
        Thread.sleep(2000);
    }

    @Test
    public void testCase06() throws InterruptedException{
        WebElement dateOption = driver.findElement(By.xpath("//input[@type='date']"));
        String dateSevenDaysAgo = Wrappers.dateSevenDaysAgo();
        Wrappers.enterString(dateOption, dateSevenDaysAgo);
        Thread.sleep(2000);
    }

    @Test
    public void testCase07() throws InterruptedException{
        String time = Wrappers.currentTime();
        String[] timeFormat = time.split((":"));
        String HH = timeFormat[0];
        String MM = timeFormat[1];
        WebElement hours = driver.findElement(By.xpath("//input[contains(@role,'combobox')]"));
        Wrappers.enterString(hours, HH);
        WebElement min = driver.findElement(By.xpath("(//input[contains(@role,'combobox')])[2]"));
        Wrappers.enterString(min, MM);
        Thread.sleep(2000);
    }

    @Test
    public void testCase8() throws InterruptedException{
    WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
    submit.click();
    Thread.sleep(4000);
    }

    @Test
    public void testCase9() throws InterruptedException{
    WebElement submitsuccess = driver.findElement(By.xpath("//div[@class='vHW8K']"));
    String success= submitsuccess.getText();
    if(submitsuccess.isDisplayed()){
        System.out.println("Thanks for your response, Automation Wizard!");;
    }
    else{
        System.out.println("Submission of form Unsuccessful");
    }
    
    }
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser() throws InterruptedException
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        //driver.quit();

    }
}