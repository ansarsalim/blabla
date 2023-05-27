package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hw1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Ansar Salim");

        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
       email.sendKeys("ansar994@gmail.com");

        WebElement address= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("7565 N Troy st, Chicago, IL 60659");

        WebElement perminent= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        perminent.sendKeys("7565 N Devon st, Chicago, IL 60659");

        WebElement submit= driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(3000);

        WebElement name= driver.findElement(By.xpath("//p[@id='name']"));
        if (name.isDisplayed()){
            System.out.println(name.getText());
        }
        WebElement emailValid= driver.findElement(By.xpath("//p[@id='email']"));
        if (emailValid.isDisplayed()){
            System.out.println(emailValid.getText());
        }
        WebElement CurrentAdlValid= driver.findElement(By.xpath("//p[@id='currentAddress']"));
        if (CurrentAdlValid.isDisplayed()){
            System.out.println(CurrentAdlValid.getText());
        }
        WebElement parmenantAdlValid= driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        if (parmenantAdlValid.isDisplayed()){
            System.out.println(parmenantAdlValid.getText());
        }

        driver.close();




    }
}
