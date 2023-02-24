package com.solvd.project.carina.demo.gui_components.abstractclass;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.LeftBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractOrangeHRMPage extends AbstractPage {
    
    @FindBy(css = ".oxd-topbar-header-userarea")
    private TopBarMenu topBarMenu;

    @FindBy(css = ".oxd-navbar-nav")
    private LeftBarMenu leftBarMenu;

    @FindBy(xpath = "//*[text() = 'Successfully Saved']")
    private ExtendedWebElement successSaveMessage;

    @FindBy(xpath = "//*[text() = 'Successfully Deleted']")
    private ExtendedWebElement successDeleteMessage;

    @FindBy(xpath = "//*[text() = 'Successfully Updated']")
    private ExtendedWebElement successUpdateMessage;

    public AbstractOrangeHRMPage(WebDriver driver) {
        super(driver);
    }


    public TopBarMenu getTopBarMenu() {
        return topBarMenu;
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

    public LeftBarMenu getLeftBarMenu() {
        return leftBarMenu;
    }
}
