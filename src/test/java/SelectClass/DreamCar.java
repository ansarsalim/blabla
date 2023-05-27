package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
    @Test
    public void Drteamcar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement NewModel= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(NewModel,"new","value");

        WebElement MakeModel= driver.findElement(By.xpath("//*[@id=\"makes\"]"));
      BrowserUtils.selectBy(MakeModel,"Lexus","text");

        WebElement Model= driver.findElement(By.xpath("//*[@id=\"models\"]"));
        BrowserUtils.selectBy(Model,"RX 350","text");

        WebElement Price= driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Price.click();
        Select option= new Select(Price);
        String actual= option.getFirstSelectedOption().getText();
        String expect= "No max price";
        Assert.assertEquals(actual,expect);

        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40 miles","text");

        WebElement zipcode= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");

        WebElement search= driver.findElement(By.xpath("//*[@id=\"by-make-tab\"]/div/div[7]/button"));
        search.click();

        WebElement head= driver.findElement(By.xpath("//h1[contains(text(),'New Lexus RX 350 for sale')]"));
        String actal= head.getText().trim();
        String expt="New Lexus RX 350 for sale";
        Assert.assertEquals(actal,expt);

        WebElement sort= driver.findElement(By.xpath("//*[@id=\"sort-dropdown\"]"));
        sort.click();
        BrowserUtils.selectBy(sort,"Lowest price","text");

        List<WebElement> allLexus= driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement title:allLexus){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
        List<WebElement> allprice= driver.findElements(By.xpath("//div[@class='price-section price-section-vehicle-card']"));
     List<String>ActualPrice= new ArrayList<>();
     List<String>ExpectedPrice=new ArrayList<>();
     for (int i=0;i<allprice.size();i++){
         ActualPrice.add(String.valueOf(Integer.parseInt(allprice.get(i).getText().replace("$",""))));
         ExpectedPrice.add(String.valueOf(Integer.parseInt( allprice.get(i).getText().replace("$",""))));

     }
        System.out.println(ActualPrice);
        Collections.sort(ExpectedPrice);
       Assert.assertEquals(ExpectedPrice,ActualPrice);


    }
}
