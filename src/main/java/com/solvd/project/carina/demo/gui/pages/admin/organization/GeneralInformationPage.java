package com.solvd.project.carina.demo.gui.pages.admin.organization;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.components.exceptions.UnknownOsException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'General Information']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".oxd-switch-input")
    private ExtendedWebElement editSwitchBtn;

    @FindBy(xpath = "//*[text() = 'Registration Number']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement registrationNumberTextField;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement saveBtn;

    public GeneralInformationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void clickEditSwitchBtn() {
        editSwitchBtn.scrollTo();
        editSwitchBtn.click();
    }

    public void clearRegistrationNumber() throws UnknownOsException {
        clearTextField(registrationNumberTextField.getElement());
    }

    public void typeRegistrationNumber(String number) {
        registrationNumberTextField.type(number);
    }

    public void clickSaveBtn() {
        saveBtn.scrollTo();
        saveBtn.click();
    }

    public void scrollToRegistrationTextField() {
        registrationNumberTextField.scrollTo();
    }

    public String getRegistrationNumber() {
        return registrationNumberTextField.getAttribute("value");
    }
}
