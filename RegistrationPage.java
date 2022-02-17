package SeleniumHomework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-register")).click();

        driver.findElement(By.xpath("//*[@id=\"gender\"]/span[2]/label")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Khyati");//customised Xpath
        driver.findElement(By.xpath("//input[contains(@id, 'LastName')]")).sendKeys("Patel");//customised Xpath

        WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));

        Select select = new Select(day);
        select.selectByIndex(21);
        Thread.sleep(1000);

        Select select1 = new Select(month);
        select1.selectByVisibleText("September");
        Thread.sleep(1000);

        Select select2 = new Select(year);
        select2.selectByValue("2000");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;//by pixel
        js.executeScript(("window.scrollBy(0,500)"));

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("patelkhyati2009@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.id("Company")).sendKeys("Unify Testing");
        Thread.sleep(1000);

        //driver.findElement(By.className("//*[@id=\"Newsletter\"]")).click();
       // Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Dhaval86");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("Dhaval86");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();

        driver.quit();
    }

    }







