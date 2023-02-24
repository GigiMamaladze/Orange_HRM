package com.solvd.project.carina.demo.gui.pages.admin.organization;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import com.solvd.project.carina.demo.gui_components.utils.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends AbstractOrangeHRMPage {

    private static final Logger LOGGER = LogManager.getLogger(GeneralInformationPage.class);

    @FindBy(xpath = "//*[@class ='oxd-text oxd-text--h6 orangehrm-main-title'][text() = 'General Information']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".oxd-switch-input ")
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
        String osName = SystemUtil.getSystemOsName();
        if (osName.equals("Windows") || osName.equals("Linux")) {
            registrationNumberTextField.getElement().sendKeys(Keys.CONTROL + "a");
        } else {
            registrationNumberTextField.getElement().sendKeys(Keys.COMMAND + "a");
        }
        registrationNumberTextField.getElement().sendKeys(Keys.DELETE);
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
