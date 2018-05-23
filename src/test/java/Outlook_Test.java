import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Outlook_Test extends BaseStep {
    private WebDriver webDriver = null;

    @Given("application browser is opened")
    public void giveApplicationBrowserIsOpened(){
        webDriver = setDriver("Chrome");
    }

    @When("open page outlook in browser")
    public void openPageOutlookInBrowser(){
        webDriver.get("https://outlook.office365.com/owa/");
    }

    @Then("\"emailAddress\" should be displayed")
    public void elementShouldBeDisplayed(){
        webDriver.findElement(By.xpath(getXpath("Outlook.Input_EmailAddress")));
    }

}
