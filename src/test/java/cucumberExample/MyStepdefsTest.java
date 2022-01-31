package cucumberExample;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



public class MyStepdefsTest {
    @Given("User open mobile app Parcel Tracker")
    public void userOpenMobileAppParcelTracker() {
    }

    @When("User fills form with parameters")
    public void userFillsFormWithParameters() {
    }

    @And("User submits form")
    public void userSubmitsForm() {
    }

    @And("User returns to main page after redirection")
    public void userReturnsToMainPageAfterRedirection() {
    }

    @Then("New parcel tracker appears with tracking id {string} and packer company {string}")
    public void newParcelTrackerAppearsWithTrackingIdAndPackerCompany(String arg0, String arg1) {
    }

    @And("User delete parcel with tracking id {string} and packer company {string}")
    public void userDeleteParcelWithTrackingIdAndPackerCompany(String arg0, String arg1) {
    }

    @And("Parcel with tracking id {string} and packer company {string} appears in archive")
    public void ParcelWithTrackingIdAndPackerCompanyAppearsInArchive(String arg0, String arg1) {
    }

    @And("Click on edit button")
    public void clickOnEditButton() {
    }

    @And("Clear input field")
    public void clearInputField() {
    }

    @And("Write new shipment name")
    public void writeNewShipmentName() {
    }

    @And("Click on ok button")
    public void clickOnOkButton() {
    }

    @Then("Check if parcel with such name exists")
    public void checkIfParcelWithSuchNameExists() {
    }
}
