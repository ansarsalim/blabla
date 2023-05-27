package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectPractice {
    @Test
   public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///Users/sold/Downloads/Techtorial.html");
        WebElement countryBox= driver.findElement(By.xpath("//select[@name='country']"));

        Select option= new Select(countryBox);
        String actualOption= option.getFirstSelectedOption().getText().trim();
        String expectedOption="UNITED STATES";
        Assert.assertEquals(actualOption,expectedOption);

        List<WebElement>allCoutries= option.getOptions();
        int count=0;
        for (int i=0;i<allCoutries.size();i++){
            count++;
            System.out.println(allCoutries.get(i).getText());

        }
        System.out.println(count);

        option.selectByVisibleText("ALGERIA ");
        Thread.sleep(Long.parseLong("200"));

       option.selectByValue("10");
       option.selectByIndex(Integer.parseInt("9"));


    }
}
