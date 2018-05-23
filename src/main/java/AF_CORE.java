import io.tapack.allure.jbehave.AllureReporter;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class AF_CORE extends JUnitStories{

    private WebDriver driver = null ;
//    private static Logger logger  = Logger.getLogger("");

    public void readVCFFile(){
        try {
            File contactFile = new File("C:\\Users\\baopn.VPBANK\\Downloads\\MyContacts-2018-05-19-192456-1071.vcf");
            BufferedReader bf = new BufferedReader(new FileReader(contactFile));
            String st ;
            while((st = bf.readLine()) != null){
                String[] telephoneLine = st.split("\n");
                for (int i = 0; i < telephoneLine.length; i++) {
                    if(telephoneLine[i].contains(".TEL")){
                        System.out.println(telephoneLine[i].split("\\:")[1]);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Input driver name , Eg : Chrome , Firefox , Edge
    public WebDriver setDriver(String driverName){
        switch (driverName){
            case "Chrome" :
                System.setProperty("webdriver.chrome.driver","D:\\Framework\\Automation_CI_Example\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox" :
                System.setProperty("webdriver.gecko.driver","D:\\Framework\\Automation_CI_Example\\driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case  "Edge"   :
                System.setProperty("webdriver.ie.driver", "D:\\Framework\\Automation_CI_Example\\driver\\edgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }



    @Override
    public Configuration configuration() {
        if (super.hasConfiguration()) {
            return super.configuration();
        }
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE)
                        .withReporters(new AllureReporter()));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("OutLook.story");
    }

    @Override
    @Test
    public void run() throws Throwable {
        super.run();
    }
}
