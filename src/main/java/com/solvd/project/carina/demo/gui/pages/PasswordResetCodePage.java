package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PasswordResetCodePage extends AbstractPage {

    @FindBy(css = ".orangehrm-forgot-password-title")
    private ExtendedWebElement resetPasswordFormTitle;

    @FindBy(css = ".oxd-input")
    private ExtendedWebElement userNameTextField;

    @FindBy(css = ".orangehrm-forgot-password-button--reset")
    private ExtendedWebElement resetPasswordBtn;

    public PasswordResetCodePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return resetPasswordFormTitle.isElementPresent();
    }

    public void typeUserName(String userName) {
        userNameTextField.type(userName);
    }

    public SendPasswordResetPage clickResetPasswordBtn() {
        resetPasswordBtn.click();
        return new SendPasswordResetPage(getDriver());
    }
}
