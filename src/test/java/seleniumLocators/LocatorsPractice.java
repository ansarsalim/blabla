package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement header= driver.findElement(By.linkText("Techlistic" ));

        String ActualHeader= header.getText();
        String ExpectdHeader="Techlistic";
        System.out.println(ActualHeader.equals(ExpectdHeader)? "passed":"failled");

        WebElement FirstName= driver.findElement(By.name("firstname"));

        FirstName.sendKeys("Ansar");
        System.out.println(FirstName);

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Salim");
        System.out.println(lastName);
        Thread.sleep(3000);

        WebElement Gender= driver.findElement(By.id("sex-0"));
        Gender.click();

        WebElement yearExperiance= driver.findElement(By.id("exp-2"));

        yearExperiance.click();

        WebElement Dtae= driver.findElement(By.id("datepicker"));
        Dtae.sendKeys("12/05/2023");


        WebElement profession= driver.findElement(By.id("profession-0"));
        profession.click();

        WebElement contonent= driver.findElement(By.id("continents"));
        contonent.sendKeys("Euroup");

        WebElement button= driver.findElement(By.id("submit"));
        button.click();

        driver.quit();






    }
}
