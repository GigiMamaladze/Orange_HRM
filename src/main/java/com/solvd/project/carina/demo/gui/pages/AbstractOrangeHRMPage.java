package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.components.enums.utils.Platform;
import com.solvd.project.carina.demo.components.utils.SystemUtil;
import com.solvd.project.carina.demo.gui.components.LeftBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
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

    @FindBy(xpath = "//*[text() = 'No Records Found']")
    private ExtendedWebElement noRecordsFoundMessage;

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

    public boolean isNoRecordsFoundMessagePresent() {
        return noRecordsFoundMessage.isElementPresent();
    }

    public void clearTextField(WebElement textField) {
        Platform platform = SystemUtil.getSystemOSName();
        int count = 0;
        do {
            if (platform == Platform.WINDOWS || platform == Platform.LINUX) {
                textField.sendKeys(Keys.CONTROL + "a");
            } else if (platform == Platform.MAC) {
                textField.sendKeys(Keys.COMMAND + "a");
            }
            textField.sendKeys(Keys.DELETE);
            count++;
            if (count >= 5) {
                break;
            }
        } while (!textField.getAttribute("value").isEmpty());
    }

    public LeftBarMenu getLeftBarMenu() {
        return leftBarMenu;
    }
}
