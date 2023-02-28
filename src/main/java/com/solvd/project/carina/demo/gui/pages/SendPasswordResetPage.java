package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SendPasswordResetPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//*[text() = 'Reset Password link sent successfully']")
    private ExtendedWebElement linkSentSuccessMessage;

    public SendPasswordResetPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResetPasswordLinkSent() {
        return linkSentSuccessMessage.isElementPresent();
    }
}
