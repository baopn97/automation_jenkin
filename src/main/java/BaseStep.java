import org.jbehave.core.annotations.*;

import java.util.concurrent.TimeUnit;


public class BaseStep extends BaseAction {

    @Given("application browser \"$browserName\" is set")
    public void applicationBrowserIsOpened(String browserName){
        setDriver(browserName);
    }

    @When("open page \"$url\" in browser")
    public void openPageInBrowser(String url){
        navigate(url);
    }

    @Then("field \"$objPath\" should be displayed")
    public void elementShouldBeDisplayed(String objPath) {
        checkDisplayed(objPath);
    }

    @When("field \"$objPath\" is filled with \"$value\"")
    public void fieldIsFilledWith(String objPath, String value){
        type(objPath,value);
    }

    @When ("field \"$objPath\" is clicked")
    @Then ("field \"$objPath\" is clicked")
    public void fieldIsClicked(String objPath){
        click(objPath);
    }




    @AfterScenario
    public void afterScenario(){
        closeWebDriver();
    }


}
