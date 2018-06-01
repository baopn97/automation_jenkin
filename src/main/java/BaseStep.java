import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class BaseStep extends BaseAction {

    @Given("application browser \"$browserName\" is opened")
    public void applicationBrowserIsOpened(String browserName){
        webDriver = setDriver(browserName);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }

    @When("open page \"$url\" in browser")
    public void openPageInBrowser(String url){
        navigate(url);
    }

    @Then("\"$objPath\" should be displayed")
    public void elementShouldBeDisplayed(String objPath) {
        checkDisplayed(objPath);
    }

    @Then("field \"$objPath\" is filled with \"$value\"")
    public void fieldIsFilledWith(String objPath, String value){
        type(objPath,value);
    }


    @AfterScenario
    public void closeWebDriver(){
        closeWebDriver();
    }

}
