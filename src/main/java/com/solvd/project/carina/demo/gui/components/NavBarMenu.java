package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.UserManagementPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'oxd-main-menu-item']//*[text() = 'Admin']")
    private ExtendedWebElement adminLabel;

    public NavBarMenu(WebDriver driver) {
        super(driver);
    }

    public NavBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public UserManagementPage clickAdminLabel() {
        adminLabel.click();
        return new UserManagementPage(getDriver());
    }
}
