package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathRealHealthProject {
    public static void main(String[] args) {
          /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com/");


        WebElement Appoint= driver.findElement(By.id("btn-make-appointment"));
        Appoint.click();

        WebElement id= driver.findElement(By.id("txt-username"));
        id.sendKeys("John Doe");

        WebElement password= driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement lognin= driver.findElement(By.id("btn-login"));
        lognin.click();

        WebElement facility= driver.findElement(By.id("combo_facility"));

        WebElement aply= driver.findElement(By.id("chk_hospotal_readmission"));
        aply.click();

        WebElement HealtCare= driver.findElement(By.id("radio_program_medicaid"));
        HealtCare.click();

     WebElement date= driver.findElement(By.id("txt_visit_date"));
     date.sendKeys("05/17/2030");

     WebElement comment= driver.findElement(By.id("txt_comment"));
     comment.sendKeys("i would like make appointment on that day");

     WebElement book= driver.findElement(By.id("btn-book-appointment"));
     book.click();

        WebElement head= driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));

        String Actual= head.getText();
        String expect= "Appointment Confirmation";
        System.out.println(Actual.equals(expect)?"pass Head": "Failled head");

        WebElement facility1= driver.findElement(By.id("facility"));

        String Actual1= facility1.getText();
        String expect1= "Tokyo CURA Healthcare Center";
        System.out.println(Actual1.equals(expect1)?"pass facility": "Failled facility");

        WebElement apply= driver.findElement(By.id("hospital_readmission"));

        String Actual2= apply.getText();
        String expect2= "Yes";
        System.out.println(Actual2.equals(expect2)?"pass apply": "Failled apply");


        WebElement program= driver.findElement(By.id("program"));

        String Actual3= program.getText();
        String expect3= "Medicaid";
        System.out.println(Actual3.equals(expect3)?"pass program": "Failled program");


        WebElement date1= driver.findElement(By.id("visit_date"));

        String Actual4= date1.getText();
        String expect4= "05/05/2030";
        System.out.println(Actual4.equals(expect4)?"pass date": "Failled date");

        WebElement comment1= driver.findElement(By.id("comment"));

        String Actual5= comment1.getText();
        String expect5= "i would like make appointment on that day";
        System.out.println(Actual5.equals(expect5)?"pass comment1": "Failled comment1");


        WebElement homepage= driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homepage.click();

        WebElement homepageHeader= driver.findElement(By.xpath("//h1[.='CURA Healthcare Service']"));

        String Actual6= homepageHeader.getText();
        String expect6="CURA Healthcare Service";
        System.out.println(Actual6.equals(expect6)?"passed Homepage":"failed homepage");

        driver.close();














    }
}
