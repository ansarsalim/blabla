package Selenuim_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMehtods {

    //Driver.get()
    //Driver.manage.windows.maximize()
    //driver.getTitle
    //driver.getCurrentURL
    //driver.navigate.refresh()
    //driver.navigate.back()
    //driver.navigate.forward()

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();// it maximize the screen

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.navigate().back();// it will go to google back

        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward();// it will go to YouTube again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.navigate().refresh();// it  will refresh the page

        System.out.println(driver.getPageSource());// ot gets the html structure page on console

        driver.quit();// it wil close the all pages opened  from, one automation



    }
}
