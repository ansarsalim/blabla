package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathLocators {

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver= new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/");

            WebElement abTesting= driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
            abTesting.click();

            WebElement header = driver.findElement(By.xpath("html/body/div[2]/div/div/h3"));
            System.out.println(driver.getTitle());

            WebElement paragraph= driver.findElement(By.xpath("//a[contains(text),'A/B Testing'"));
            paragraph.click();
            Thread.sleep(3000);

            WebElement elemnt= driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
            Thread.sleep(3000);
            elemnt.click();








    }
}
