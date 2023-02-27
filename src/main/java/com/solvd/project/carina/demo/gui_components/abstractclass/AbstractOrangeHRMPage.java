package com.solvd.project.carina.demo.gui_components.abstractclass;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.LeftBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import com.solvd.project.carina.demo.gui_components.utils.SystemUtil;
import com.solvd.project.carina.demo.gui_components.utils.enums.Platform;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void clearTextField(WebElement textField) throws UnknownOsException {
        Platform platform = SystemUtil.getSystemOSName();
        if (platform == Platform.WINDOWS || platform == Platform.LINUX) {
            textField.sendKeys(Keys.CONTROL + "a");
        } else if (platform == Platform.MAC) {
            textField.sendKeys(Keys.COMMAND + "a");
        }
        textField.sendKeys(Keys.DELETE);
    }

    public LeftBarMenu getLeftBarMenu() {
        return leftBarMenu;
    }
}
