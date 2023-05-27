package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class findElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks= driver.findElements(By.xpath("//li"));

        int count=0;

        for (WebElement i:allLinks){
            //System.out.println(i.getText());
            if (i.getText().length()>=12){
                System.out.println(i.getText());
                count++;
            }
        }
       System.out.println(count);
//        System.out.println(allBoxes.size());

    }
}
