package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test1 {
    /*
    print pout the names and emails as a key --value pairs
    use ,map interface, try to use accesSelector
     */
    @Test
    public void Test(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement click= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        click.click();

        WebElement select= driver.findElement(By.cssSelector("select[id='maxRows'"));

        BrowserUtils.selectBy(select,"0","index");

        List<WebElement>allanmes= driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement>allEmails= driver.findElements(By.xpath("//tr//td[3]"));

        TreeMap<String, String> map=new TreeMap<>();

        for (int i=0;i<allanmes.size();i++){
            map.put(allanmes.get(i).getText(), allEmails.get(i).getText());

        }
        System.out.println("map= "+map);


    }
    @Test
    public void number() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        WebElement click= driver.findElement(By.xpath("//a[.='Table Pagination']"));
        click.click();

        WebElement select= driver.findElement(By.cssSelector("select[id='maxRows'"));

        BrowserUtils.selectBy(select,"0","index");
        List<WebElement>allanmes= driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement>allPhones= driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String,Long> map1= new TreeMap<>();


        for (int i=0;i<allanmes.size();i++){
            Thread.sleep(2000);
            map1.put(BrowserUtils.getText(allanmes.get(i)),Long.valueOf(BrowserUtils.getText(allPhones.get(i)).replace("-","")));

        }
        System.out.println(map1);



    }
}
