package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//*[@name = 'username']")
    private ExtendedWebElement userNameTextField;

    @FindBy(xpath = "//*[@name = 'password']")
    private ExtendedWebElement passwordTextField;

    @FindBy(css = ".orangehrm-login-button")
    private ExtendedWebElement logInBtn;

    @FindBy(css = ".orangehrm-login-forgot-header")
    private ExtendedWebElement forgotYourPasswordBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserName(String userName) {
        userNameTextField.type(userName);
    }

    public void typePassword(String password) {
        passwordTextField.type(password);
    }

    public DashboardPage clickLogInButton() {
        logInBtn.click();
        return new DashboardPage(getDriver());
    }

    public PasswordResetCodePage clickForgotYourPasswordBtn() {
        forgotYourPasswordBtn.click();
        return new PasswordResetCodePage(getDriver());
    }
}
