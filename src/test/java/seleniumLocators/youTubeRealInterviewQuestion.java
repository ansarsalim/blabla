package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class youTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");

        WebElement swearch= driver.findElement(By.xpath("//input [@name='search_query']"));
        swearch.sendKeys("quavo");
        swearch.sendKeys(Keys.ENTER);
        int count=0;
        Thread.sleep(3000);

        List<WebElement> songs= driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song:songs){
            count++;
            System.out.println(song.getText());

            if (song.getText().equals("Quavo & Takeoff - HOTEL LOBBY | A COLORS SHOW")){
                Thread.sleep(3000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
            }
        }
        System.out.println(count);
        ////a[@id='video-title']"





    }
}
