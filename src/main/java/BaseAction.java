import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class BaseAction extends AF_CORE{
    WebDriver webDriver = null ;

    //Input webDriver name , Eg : Chrome , Firefox , Edge
    public WebDriver setDriver(String driverName){
        switch (driverName){
            case "Chrome" :
                System.setProperty("webdriver.chrome.driver","D:\\automation_jenkin\\driver\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "Firefox" :
                System.setProperty("webdriver.gecko.driver","D:\\automation_jenkin\\driver\\geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            case  "Edge"   :
                System.setProperty("webdriver.ie.driver", "D:\\automation_jenkin\\driver\\edgedriver.exe");
                webDriver = new EdgeDriver();
                break;
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
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
                    File fileDir = new File("D:\\automation_jenkin\\object_repositories");
                    File[] listOfFiles = fileDir.listFiles();
                    for (int i = 0; i < listOfFiles.length ; i++) {
                File objFile = new File(String.valueOf(listOfFiles[i]));
                BufferedReader br = new BufferedReader(new FileReader(objFile));
                String st;
                while ((st = br.readLine()) != null){
                    String[] allLine = st.split("\n");
                    for (int j = 0; j < allLine.length; j++) {
                        String eachLine = allLine[j];
                        String[] seperateLine = eachLine.split("\\=", 2);

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

    public byte[] captureScreenshot(){
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }

    public void openPageInOtherBr(){
        String parentWinHandle = webDriver.getWindowHandle();
        System.out.println(parentWinHandle);
        Set<String> allWinHandle = webDriver.getWindowHandles();
        System.out.println(allWinHandle.size());
//        for (String winHandle : allWinHandle){
//            System.out.println(winHandle);
//            webDriver.switchTo().window(winHandle);
//        }
    }

    public void switchToTab(int index){
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(index));
    }
}
