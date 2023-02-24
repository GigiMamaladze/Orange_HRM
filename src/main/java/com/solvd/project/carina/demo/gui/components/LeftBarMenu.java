package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.UserManagementPage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LeftBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'oxd-main-menu-item']//*[text() = 'Admin']")
    private ExtendedWebElement adminLabel;

    @FindBy(xpath = "//*[@class = 'oxd-main-menu-item']//*[text() = 'PIM']")
    private ExtendedWebElement pimLabel;

    public LeftBarMenu(WebDriver driver) {
        super(driver);
    }

    public LeftBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public UserManagementPage clickAdminLabel() {
        adminLabel.click();
        return new UserManagementPage(getDriver());
    }

    public EmployeeListPage clickPimLabel() {
        pimLabel.click();
        return new EmployeeListPage(getDriver());
    }

}
