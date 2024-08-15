package demo.wrappers;


import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    
    public static void enterString(WebElement name , String text){
        name.sendKeys(text);

    }

    public static void clickRadio(WebDriver driver, String optionText){
        WebElement radioButton = driver.findElement(By.xpath("//span[contains(@class,'OvPDhc') and contains(text(),'" + optionText + "')]/../../..//div[@class='vd3tt']"));
        radioButton.click();
    }

    public static void clickCheckBox(WebDriver driver, String optionTextCheckBox){
        WebElement checkBox = driver.findElement(By.xpath("//span[contains(@class,'n5vBHf') and contains(text(),'" + optionTextCheckBox + "')]/../../preceding-sibling::div[contains(@id,'i')]"));
        checkBox.click();
    }

    public static void dropDownOption(WebDriver driver, String optionTextDropDown){
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'QXL7Te')]//div[@data-value='" + optionTextDropDown + "']"));
        
        dropdown.click();
    }

    public static String dateSevenDaysAgo(){
        LocalDate currentDate = LocalDate.now();
        LocalDate sevenDaysAgo = currentDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = sevenDaysAgo.format(formatter);
        return date;
    }

    public static String currentTime(){
        LocalTime currentTime1 = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String currentTime = currentTime1.format(formatter);
        return currentTime;
    }




}
