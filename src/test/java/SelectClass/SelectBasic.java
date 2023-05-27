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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasic {
    @Test
    public void SelectMehtod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropdwon= driver.findElement(By.linkText("Dropdown"));
        dropdwon.click();
        WebElement optionBox= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select choice= new Select(optionBox);// it means I will choose an option from that box
        String actiualDefaultOption=choice.getFirstSelectedOption().getText().trim();
        String exepectedDefaultOption= "Please select an option";
        Assert.assertEquals(actiualDefaultOption,exepectedDefaultOption);

        choice.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        choice.selectByValue("1");
        Thread.sleep(2000);
        choice.selectByIndex(2);
        Thread.sleep(2000);

        List<WebElement> allOption=choice.getOptions();

        List<String>expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2");
        for (int i=0;i<allOption.size();i++){
            Assert.assertEquals(allOption.get(i).getText().trim(),expectedOptions.get(i).trim());
        }




    }

}
