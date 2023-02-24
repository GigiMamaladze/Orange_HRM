package com.solvd.project.carina.demo.gui_components.classes;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NotificationMessage extends AbstractUIObject {

    @FindBy(xpath = "//*[text() = 'Successfully Saved']")
    private ExtendedWebElement successSaveMessage;

    @FindBy(xpath = "//*[text() = 'Successfully Deleted']")
    private ExtendedWebElement successDeleteMessage;

    @FindBy(xpath = "//*[text() = 'Successfully Updated']")
    private ExtendedWebElement successUpdateMessage;

    public NotificationMessage(WebDriver driver) {
        super(driver);
    }

    public NotificationMessage(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSuccessSaveMessagePresent() {
        return successSaveMessage.isElementPresent();
    }

    public boolean isSuccessDeleteMessagePresent() {
        return successDeleteMessage.isElementPresent();
    }

    public boolean isSuccessUpdateMessagePresent() {
        return successUpdateMessage.isElementPresent();
    }
}
