package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'oxd-topbar-header-breadcrumb']//*[text() = 'User Management']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//button[text() = ' Add ']")
    private ExtendedWebElement addUserBtn;

    @FindBy(xpath = "//*[text() = 'Username']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement systemUserNameTextField;

    @FindBy(xpath = "//*[@class = 'oxd-table-body']//*[text() = '%s']")
    private ExtendedWebElement searchedUser;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement searchBtn;

    public UserManagementPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public AddUserPage clickAddUserBtn() {
        addUserBtn.click();
        return new AddUserPage(getDriver());
    }

    public void typeUserName(String userName) {
        systemUserNameTextField.type(userName);
    }

    public boolean isUserPresent(String userName) {
        return searchedUser.format(userName).isElementPresent();
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }
}
