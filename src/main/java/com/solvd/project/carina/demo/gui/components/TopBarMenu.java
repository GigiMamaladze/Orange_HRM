package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.UpdatePasswordPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends AbstractUIObject {

    @FindBy(css = ".oxd-userdropdown-icon")
    private ExtendedWebElement userNameArrowIcon;

    @FindBy(xpath = "//*[text() = 'Change Password']")
    private ExtendedWebElement changePasswordBtn;

    @FindBy(xpath = "//*[@class = 'oxd-topbar-body-nav-tab-item'][text() = '%s']")
    private ExtendedWebElement sections;

    @FindBy(xpath = "//*[@class = 'oxd-dropdown-menu']//*[text() = '%s']")
    private ExtendedWebElement subSection;

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    public void clickUserNameArrowIcon() {
        userNameArrowIcon.click();
    }

    public UpdatePasswordPage clickChangePasswordBtn() {
        changePasswordBtn.click();
        return new UpdatePasswordPage(getDriver());
    }

    public void clickSection(MenuOption menuOption) {
        sections.format(menuOption.getMenuOption()).click();
    }

    public void clickSubSection(MenuOption menuOption) {
        subSection.format(menuOption.getMenuOption()).click();
    }
}
