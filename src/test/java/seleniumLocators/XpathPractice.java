package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Ansar");

        WebElement last6nbame= driver.findElement(By.xpath("//input[@name='lastname']"));
        last6nbame.sendKeys("Salim");

        WebElement email= driver.findElement(By.xpath("//input[@name='email']"));
       email.sendKeys("Salim@gmail.com");

        WebElement phone= driver.findElement(By.xpath("//input[@name='telephone']"));
        phone.sendKeys("984542627");

        WebElement password= driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Ansar2554");

        WebElement confirm= driver.findElement(By.xpath("//input[@name='confirm']"));
        confirm.sendKeys("Ansar2554");

        WebElement polycy= driver.findElement(By.xpath("//input[@name='agree']"));
        polycy.click();

        WebElement conti= driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        conti.click();








    }
}
