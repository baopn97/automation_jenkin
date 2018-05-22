import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.logging.Logger;

public class BaseStep extends AF_CORE{
    private WebDriver driver = null ;
    private static Logger logger  = Logger.getLogger("");

    public void click(String objPath){
        try {
            WebElement ele = driver.findElement(By.xpath(getXpath(objPath)));
            ele.click();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void type(String objPath , String text){
        try {
            WebElement ele = driver.findElement(By.xpath(getXpath(objPath)));
            ele.clear();
            ele.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkDisplayed(String objPath){
        try {
            WebElement ele = driver.findElement(By.xpath(getXpath(objPath)));
            ele.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
