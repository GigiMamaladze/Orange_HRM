package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UpdatePasswordPage extends AbstractPage {

    @FindBy(xpath = "//*[text() = 'Update Password']")
    private ExtendedWebElement updatePasswordFormTitle;

    @FindBy(xpath = "//*[text() = 'Current Password']/../..//input[@type = 'password']")
    private ExtendedWebElement currentPasswordTextField;

    @FindBy(xpath = "//*[text() = 'Password']/../..//input[@type = 'password']")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//*[text() = 'Confirm Password']/../..//input[@type = 'password']")
    private ExtendedWebElement confirmPasswordTextField;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement saveBtn;

    @FindBy(xpath = "//*[text() = 'Successfully Saved']")
    private ExtendedWebElement successSaveMessage;

    public UpdatePasswordPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(updatePasswordFormTitle);
    }

    public void typeCurrentPassword(String currentPassword) {
        currentPasswordTextField.type(currentPassword);
    }

    public void typeNewPassword(String password) {
        passwordTextField.type(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordTextField.type(password);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }

    public boolean isSuccessSaveMessage() {
        return successSaveMessage.isElementPresent();
    }
}
