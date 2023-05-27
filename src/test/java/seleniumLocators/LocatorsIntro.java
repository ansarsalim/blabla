package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        //Locators-->is a way to locate(find) element and manipulate om it

        //ID locators

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.navigate().to("file:///Users/sold/Downloads/Techtorial.html");
        driver.manage().window().maximize();

        WebElement heaeder= driver.findElement(By.id("techtorial1"));


        String actualheader=heaeder.getText().trim();// it grts text from element

        String expectedHeader= "Techtorial Academy";

        System.out.println(heaeder.getText());
        System.out.println(actualheader.equals(expectedHeader)? "passed":"failled");

        WebElement header1= driver.findElement(By.id("details2"));
        System.out.println(header1.getText());

        //name locators
        WebElement firsrName= driver.findElement(By.name("firstName"));

        firsrName.sendKeys("Ansar");
        System.out.println(firsrName);

        WebElement lastName= driver.findElement(By.name("lastName"));
        lastName.sendKeys("Salim");
        System.out.println(lastName);

        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("8739729");
        System.out.println(phone);

        WebElement email= driver.findElement(By.name("userName"));

        email.sendKeys("ansar097@gmail.com");
        System.out.println(email);

        WebElement address= driver.findElement(By.name("address1"));
        address.sendKeys("6224 n street ave");
        System.out.println(address);

        WebElement city= driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        System.out.println(city);

        WebElement state= driver.findElement(By.name("state"));

        state.sendKeys("IL");
        System.out.println(state);

        WebElement country= driver.findElement(By.name("country"));
        country.sendKeys("United State");
        System.out.println(country);

        //class locators

        WebElement allTools= driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox= driver.findElement(By.id("cond1"));

        if(javaBox.isDisplayed()&& !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isDisplayed()?"selected":"not selected");

        WebElement javaBox1= driver.findElement(By.id("cond3"));
        if (javaBox1.isDisplayed()&& !javaBox1.isSelected()){
            javaBox1.click();
        }
        System.out.println(javaBox1.isDisplayed()?"selected":"not selected");

        WebElement javaBox2= driver.findElement(By.id("cond4"));
        if (javaBox2.isDisplayed()&& !javaBox2.isSelected()){
            javaBox2.click();
        }
        System.out.println(javaBox2.isDisplayed()?"selected":"not selected");


        //TAGS NAME LOCATORS

        WebElement header2= driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText());

        WebElement header3= driver.findElement(By.tagName("u"));
        System.out.println(header3.getText());

        Thread.sleep(2000);

        driver.quit();












    }
}
