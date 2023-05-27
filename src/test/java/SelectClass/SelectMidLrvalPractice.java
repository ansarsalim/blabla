package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectMidLrvalPractice {
   /* 1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
            5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
            11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
            "After flight finder - No Seats Avaialble"

    NOTE:Your test should fail and say available is not matching with Available.
    NOTE2:You can use any select method*/
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement selectBox= driver.findElement(By.xpath("//input[@value='oneway']"));
        selectBox.click();
        Thread.sleep(2000);
        WebElement passenger= driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passenger,"4","value");

        WebElement deperting= driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select option1= new Select(deperting);
        option1.getFirstSelectedOption();
        option1.selectByValue("Paris");

        WebElement month= driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(month,"8","value");

        WebElement date= driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(date,"15","value");

        WebElement arriving= driver.findElement(By.xpath("//select[@name='toPort']"));

        Select option4=new Select(arriving);
        option4.selectByValue("San Francisco");

        WebElement arivingMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select choose= new Select(arivingMonth);
        choose.selectByValue("12");

        WebElement arivingDate= driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dateChoose= new Select(arivingDate);
        dateChoose.selectByValue("15");

        WebElement type= driver.findElement(By.xpath("//input[@value='First']"));
        type.click();
        Thread.sleep(2000);

        WebElement Airline= driver.findElement(By.xpath("//select[@name='airline']"));
        List<String> expectedOptions=Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        Select allOptions= new Select(Airline);
        List<WebElement>opt= allOptions.getOptions();
        for (int i=0;i<opt.size();i++){
            Assert.assertEquals(opt.get(i).getText().trim(),expectedOptions.get(i));
        }
        Thread.sleep(2000);
        allOptions.selectByIndex(2);

        WebElement Continue= driver.findElement(By.xpath("//input[@name='findFlights']"));
        Continue.click();

        WebElement head= driver.findElement(By.xpath("//font[@size='4']"));
        String actualHead= head.getText();
        String expectedHead="After flight finder - No Seats avaialble";
        Assert.assertEquals(actualHead,expectedHead);
        System.out.println(head.getText());


    }


}
