package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("file:///Users/sold/Downloads/Techtorial.html");

        //LinkText locators
        WebElement java= driver.findElement(By.linkText("Java"));
        java.click();

        WebElement JavaHeader= driver.findElement(By.tagName("h1"));

        String Actual= JavaHeader.getText().trim();
        String expected="Java";
        System.out.println(Actual.equals(expected)?"passed":"failled");

        WebElement Selenium= driver.findElement(By.linkText("Selenium"));
        Selenium.click();

        WebElement SeleniumHeader= driver.findElement(By.tagName("h1"));

        String Actual1= SeleniumHeader.getText().trim();
        String expected1="Selenium automates browsers. That's it!";
        System.out.println(Actual1.equals(expected1)?"passed":"failled");

        WebElement Cucumber = driver.findElement(By.linkText("Cucumber"));
        Cucumber.click();

        WebElement CucumberHeader= driver.findElement(By.tagName("h1"));

        String Actual2= CucumberHeader.getText().trim();
        String expected2="Tools & techniques that elevate teams to greatness";
        System.out.println(Actual2.equals(expected2)?"passed":"failled");

        WebElement TestNG = driver.findElement(By.linkText("TestNG "));
        TestNG.click();

        WebElement TestNGHeader= driver.findElement(By.tagName("h2"));

        String Actual3= TestNGHeader.getText().trim();
        String expected3="TestNG";
        System.out.println(Actual3.equals(expected3)?"passed":"failled");

        driver.close();

        // LOCATORS PARTIALLINK TEXT

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));

        restApi.click();
        System.out.println(driver.getTitle());




    }
}
