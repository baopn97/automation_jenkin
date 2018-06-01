import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class BaseAction extends AF_CORE{
    public static WebDriver webDriver = null ;

    //Input webDriver name , Eg : Chrome , Firefox , Edge
    public WebDriver setDriver(String driverName){
        switch (driverName){
            case "Chrome" :
                System.setProperty("webdriver.chrome.webDriver","D:\\Framework\\Automation_CI_Example\\webDriver\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "Firefox" :
                System.setProperty("webdriver.gecko.webDriver","D:\\Framework\\Automation_CI_Example\\webDriver\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case  "Edge"   :
                System.setProperty("webdriver.ie.webDriver", "D:\\Framework\\Automation_CI_Example\\webDriver\\edgedriver.exe");
                webDriver = new EdgeDriver();
                break;
        }
        return webDriver;
    }

    public WebElement getElement(String objPath){
        WebElement targetdEle = webDriver.findElement(By.xpath(getXpath(objPath)));
        return targetdEle;
    }

    public static String getXpath(String objPath){
        String xpath = "";
        try {
            LinkedHashMap<String , String> objRepo = new LinkedHashMap<>();
            File fileDir = new File("D:\\Framework\\Automation_CI_Example\\object_repositories");
            File[] listOfFiles = fileDir.listFiles();
            for (int i = 0; i < listOfFiles.length ; i++) {
                File objFile = new File(String.valueOf(listOfFiles[i]));
                BufferedReader br = new BufferedReader(new FileReader(objFile));
                String st;
                while ((st = br.readLine()) != null){
                    String[] allLine = st.split("\n");
                    for (int j = 0; j < allLine.length; j++) {
                        String eachLine = allLine[j];
                        String[] seperateLine = eachLine.split("\\=");

                        if(seperateLine[0].trim().endsWith(".XPath")){
                            for (int k = 0; k < seperateLine.length; k++) {
                                objRepo.put(seperateLine[0].replace(".XPath","").trim(),seperateLine[1].trim());
                            }
                        }else {
//                            logger.warning("Wrong XPath format , please check");
                        }
                    }
                }
                xpath = objRepo.get(objPath);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return xpath;
    }

    public void click(String objPath){
        try {
            getElement(objPath).click();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void type(String objPath , String text){
        try {
            getElement(objPath).clear();
            getElement(objPath).sendKeys(text);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkDisplayed(String objPath){
        try {
            getElement(objPath).isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void navigate(String url){
        try {
            webDriver.get(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeWebDriver(){
        try {
            webDriver.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
