package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PasswordResetCodePage extends AbstractOrangeHRMPage {

    @FindBy(css = ".orangehrm-forgot-password-title")
    private ExtendedWebElement resetPasswordFormTitle;

    @FindBy(css = ".oxd-input")
    private ExtendedWebElement userNameTextField;

    @FindBy(css = ".orangehrm-forgot-password-button--reset")
    private ExtendedWebElement resetPasswordBtn;

    public PasswordResetCodePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(resetPasswordFormTitle);
    }

    public void typeUserName(String userName) {
        userNameTextField.type(userName);
    }

    public SendPasswordResetPage clickResetPasswordBtn() {
        resetPasswordBtn.click();
        return new SendPasswordResetPage(getDriver());
    }
}
