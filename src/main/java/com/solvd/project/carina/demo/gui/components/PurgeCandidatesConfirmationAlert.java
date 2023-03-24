package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PurgeCandidatesConfirmationAlert extends AbstractUIObject {

    @FindBy(xpath = "//*[@type = 'button'][text() = ' Yes, Purge ']")
    private ExtendedWebElement yesPurgeButton;

    public PurgeCandidatesConfirmationAlert(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isConfirmationAlertPresent() {
        return yesPurgeButton.isElementPresent();
    }

    public void clickYesPurgeButton() {
        yesPurgeButton.click();
    }
}
