package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNG_practice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement usesrname = driver.findElement(By.xpath("//input[@id='input-username']"));
        usesrname.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String actual = header.getText();
        String exepect = "Dashboard";

        Assert.assertEquals(actual, exepect);

    }

    @Test
    public void negative() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement usesrname = driver.findElement(By.xpath("//input[@id='input-username']"));
        usesrname.sendKeys("Demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Demo");

        WebElement login = driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(2000);

        WebElement failed = driver.findElement(By.cssSelector("#alert"));

        String actualError = failed.getText().trim();
        String expect = "No match for Username and/or Password";
        Assert.assertEquals(actualError, expect);

    }

    @Test
    public void ValidateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement usesrname = driver.findElement(By.xpath("//input[@id='input-username']"));
        usesrname.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();
        Thread.sleep(2000);

        WebElement catlog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catlog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed());


    }

    @Test
    public void ascendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement usesrname = driver.findElement(By.xpath("//input[@id='input-username']"));
        usesrname.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        Thread.sleep(2000);
        xButton.click();

        WebElement catlog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catlog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> Box = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < Box.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(Box.get(i).isDisplayed());
            Assert.assertTrue(Box.get(i).isEnabled());
            // Assert.assertTrue(Box.get(i).isSelected());
            Box.get(i).click();
            // Assert.assertTrue(Box.get(i).isSelected());
            Box.get(i).sendKeys(Keys.ARROW_DOWN);

            //WebElement decending= driver.findElement(By.xpath("//a[@class='desc']"));
            // decending.click();

        }
        List<WebElement> allproducts = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualProductOrder = new ArrayList<>();
        List<String> expectedProductOrder = new ArrayList<>();
        for (int j = 1; j < allproducts.size(); j++) {
            actualProductOrder.add(allproducts.get(j).getText().toLowerCase().trim());
            expectedProductOrder.add(allproducts.get(j).getText().toLowerCase().trim());

        }
        Collections.sort(expectedProductOrder);
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder, expectedProductOrder);


    }

@Test
    public void decendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement usesrname = driver.findElement(By.xpath("//input[@id='input-username']"));
        usesrname.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button"));
        login.click();
        Thread.sleep(2000);

        WebElement xButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        xButton.click();
        Thread.sleep(2000);

        WebElement catlog = driver.findElement(By.xpath("//a[.=' Catalog']"));
        catlog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        List<WebElement> Box = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < Box.size(); i++) {
            Thread.sleep(2000);
            Assert.assertTrue(Box.get(i).isDisplayed());
            Assert.assertTrue(Box.get(i).isEnabled());
            // Assert.assertTrue(Box.get(i).isSelected());
            Box.get(i).click();
            // Assert.assertTrue(Box.get(i).isSelected());
            Box.get(i).sendKeys(Keys.ARROW_DOWN);
            List<WebElement> allproducts = driver.findElements(By.xpath("//td[@class='text-start']"));
            List<String> actualProductOrder = new ArrayList<>();
            List<String> expectedProductOrder = new ArrayList<>();
            for (int j = 1; j < allproducts.size(); j++) {
                actualProductOrder.add(allproducts.get(j).getText().toLowerCase().trim());
                expectedProductOrder.add(allproducts.get(j).getText().toLowerCase().trim());

            }
            Collections.sort(expectedProductOrder);
            Collections.reverse(expectedProductOrder);
            System.out.println(actualProductOrder);
            System.out.println(expectedProductOrder);
            Assert.assertEquals(actualProductOrder, expectedProductOrder);



        }
    }
}
