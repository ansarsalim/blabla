package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BrowserUtils {
    public static String getText(WebElement element){
        return element.getText();
    }
    public static void selectBy(WebElement location, String value, String mehtodName){
        Select select= new Select(location);
        switch (mehtodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your method name is not correct");
                Assert.assertTrue(false);
        }
    }
}
