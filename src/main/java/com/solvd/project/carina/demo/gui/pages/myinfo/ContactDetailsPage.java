package com.solvd.project.carina.demo.gui.pages.myinfo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.UserInformationMenu;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Contact Details']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//h6[text() = 'Address']")
    private ExtendedWebElement addressSection;

    @FindBy(css = ".orangehrm-tabs")
    private UserInformationMenu userInformationMenu;

    @FindBy(xpath = "//*[text() = 'Street 1']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement street1TextField;

    @FindBy(xpath = "//*[text() = 'City']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement cityTextField;

    @FindBy(xpath = "//*[text() = 'Home']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement homeTelephoneNumber;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Save ']")
    private ExtendedWebElement saveBtn;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public UserInformationMenu getUserInformationMenu() {
        return userInformationMenu;
    }

    public void clearStreet1TextField() {
        clearTextField(street1TextField.getElement());
    }

    public void typeStreet1(String street) {
        street1TextField.type(street);
    }

    public void clearCityTextField() {
        clearTextField(cityTextField.getElement());
    }

    public void typeCity(String city) {
        cityTextField.type(city);
    }

    public void clearHomeTelephoneNumberTextField() {
        clearTextField(homeTelephoneNumber.getElement());
    }

    public void typeHomeTelephoneNumber(String number) {
        homeTelephoneNumber.type(number);
    }

    public void clickSaveButton() {
        saveBtn.scrollTo();
        saveBtn.click();
    }

    public String getStreet1() {
        return street1TextField.getAttribute("value");
    }
    
    public String getCity() {
        return cityTextField.getAttribute("value");
    }

    public String getHomeTelephoneNumber() {
        return homeTelephoneNumber.getAttribute("value");
    }
}
