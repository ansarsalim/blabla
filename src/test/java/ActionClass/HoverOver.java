package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoverOver {
    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
     List<WebElement>usersimg= driver.findElements(By.xpath("//img[@alt='User Avatar']"));
     List<WebElement>allnames=driver.findElements(By.xpath("//h5"));

     List<String>actualnames=new ArrayList<>();
     List<String>expectednames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions= new Actions(driver);
        for (int i=0;i< usersimg.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(usersimg.get(i)).perform();
            actualnames.add(allnames.get(i).getText().trim());
        }
        Assert.assertEquals(actualnames,expectednames);
        System.out.println(actualnames);
        System.out.println(expectednames);


    }
}
