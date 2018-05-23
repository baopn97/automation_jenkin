import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.logging.Logger;

public class BaseStep extends AF_CORE{
    private WebDriver driver = null ;
    private static Logger logger  = Logger.getLogger("");

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
