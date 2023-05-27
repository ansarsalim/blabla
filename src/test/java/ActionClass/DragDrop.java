package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDrop {
    @Test
    public void DragandDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement OrangeBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String Actual = OrangeBox.getText().trim();
        String expected = "... Or here.";
        Assert.assertEquals(Actual, expected);
        String actualBcolor = OrangeBox.getCssValue("background-color");
        String ecpectedBcolor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBcolor, ecpectedBcolor);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);


        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, OrangeBox).perform();
        Thread.sleep(2000);
        OrangeBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String acrtualdropDrag = BrowserUtils.getText(OrangeBox);
        String expecteddropanddrag = "You did great!";
        Assert.assertEquals(acrtualdropDrag, expecteddropanddrag);


    }

    @Test
    public void DragandDrop1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement BlueBox = driver.findElement(By.xpath("//*[@id=\"droptarget\"]/div[1]"));
        String Actual = BlueBox.getText().trim();
        String expected = "Drag the small circle here ...";
        Assert.assertEquals(Actual, expected);
        String actualBcolor = BlueBox.getCssValue("background-color");
        String ecpectedBcolor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBcolor, ecpectedBcolor);

        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);


        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, BlueBox).perform();
        Thread.sleep(2000);
        BlueBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String acrtualdropDrag = BrowserUtils.getText(BlueBox);
        String expecteddropanddrag = "You did great!";
        Assert.assertEquals(acrtualdropDrag, expecteddropanddrag);


    }
    @Test

    public void DragandDrop2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement drage= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']"));

        Actions actions= new Actions(driver);

        actions.dragAndDrop(drage,dropBox).perform();
        WebElement dropped= driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
        String actual= dropped.getText().trim();
        String expected= "Dropped!";
        Assert.assertEquals(actual,expected);
        String ActualColor= drage.getCssValue("background-color");
        String Expectedcolor="rgba(0, 0, 0, 0)";

        Assert.assertEquals(ActualColor,Expectedcolor);

        WebElement accept= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();

        WebElement notAccept= driver.findElement(By.xpath("//*[@id=\"notAcceptable\"]"));
        String actual1= notAccept.getText().trim();
        String expected1="Not Acceptable";
        Assert.assertEquals(actual1,expected1);
        Thread.sleep(2000);

        Actions actions1= new Actions(driver);
        Thread.sleep(2000);
        actions1.clickAndHold(notAccept).moveToElement(dropped);

    }
    @Test
    public void dragandHOld() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement accept= driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        accept.click();
        Thread.sleep(2000);

        WebElement notAccept= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actual1= notAccept.getText().trim();
        String expected1="Not Acceptable";
        Assert.assertEquals(actual1,expected1);

        WebElement dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@class='drop-box ui-droppable']"));


        Actions actions1= new Actions(driver);
        actions1.clickAndHold(notAccept).moveToElement(dropBox).perform();
    }
}
