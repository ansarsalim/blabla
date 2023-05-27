package Selenuim_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumBasic {
    //FIRST STEP is setting up your automation
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //then create your driver to start automation
        WebDriver driver= new ChromeDriver(options);
//        driver.get("https://www.amazon.com/");
//
//        System.out.println(driver.getTitle());
//
//        String actualtitle= driver.getTitle();
//        String expectedTitle="Amazon.com. Spend less. Smile more.";
//        if (actualtitle.equals(expectedTitle)){
//            System.out.println("Passed");
//        }else {
//            System.out.println("Failed");
//        }
//        String actualUrl= driver.getCurrentUrl();
//        String expectedURL= "https://www.amazon.com/";
//        if(actualUrl.equals(expectedURL)){
//            System.out.println("URL passed ");
//        }else {
//            System.out.println("URL failed");
//        }
//        driver.close();

        driver.get("https://www.godaddy.com/");

        String actual= driver.getTitle();
        String expected="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if (actual.equals(expected)){
            System.out.println("Passed");
        }else {
            System.out.println("failed");
        }
        String ActualURL= driver.getCurrentUrl();
        String expectedURL= "https://www.godaddy.com/";
        if (ActualURL.equals(expectedURL)){
            System.out.println("URL passed");
        }else {
            System.out.println("URL failed");
        }
        driver.close();


    }


}
