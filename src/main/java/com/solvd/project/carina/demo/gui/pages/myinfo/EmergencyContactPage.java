package com.solvd.project.carina.demo.gui.pages.myinfo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmergencyContactPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Assigned Emergency Contacts']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//h6[text() = 'Save Emergency Contact']")
    private ExtendedWebElement emergencyContactFormTitle;

    @FindBy(xpath = "//h6[text() = 'Assigned Emergency Contacts']/ancestor::div[@class = 'orangehrm-action-header']//button")
    private ExtendedWebElement assignedEmergencyContactsAddBtn;

    @FindBy(xpath = "//*[text() = 'Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement nameTextField;

    @FindBy(xpath = "//*[text() = 'Relationship']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement relationshipTextField;

    @FindBy(xpath = "//*[text() = 'Home Telephone']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement homeTelephoneTextField;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Save ']")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-card']//*[text() = '%s']")
    private ExtendedWebElement createdEmergencyContactDetails;

    public EmergencyContactPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void clickAssignedEmergencyContactsAddButton() {
        assignedEmergencyContactsAddBtn.click();
    }

    public boolean isEmergencyContactFormPresent() {
        return emergencyContactFormTitle.isElementPresent();
    }

    public void clearNameTextField() {
        clearTextField(nameTextField.getElement());
    }

    public void typeName(String name) {
        nameTextField.type(name);
    }

    public void clearRelationshipTextField() {
        clearTextField(relationshipTextField.getElement());
    }

    public void typeRelationship(String relationship) {
        relationshipTextField.type(relationship);
    }

    public void clearHomeTelephoneTextField() {
        clearTextField(homeTelephoneTextField.getElement());
    }

    public void typeHomeTelephone(String homeTelephone) {
        homeTelephoneTextField.type(homeTelephone);
    }

    public void clickSaveButton() {
        saveBtn.click();
    }

    public boolean isNamePresentInContact(String name) {
        return createdEmergencyContactDetails.format(name).isElementPresent();
    }

    public boolean isRelationshipPresentInContact(String relationship) {
        return createdEmergencyContactDetails.format(relationship).isElementPresent();
    }

    public boolean isHomeTelephonePresentInContact(String homeTelephone) {
        return createdEmergencyContactDetails.format(homeTelephone).isElementPresent();
    }
}
