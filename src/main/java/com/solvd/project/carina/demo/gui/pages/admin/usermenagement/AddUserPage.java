package com.solvd.project.carina.demo.gui.pages.admin.usermenagement;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui_components.enums.UserRole;
import com.solvd.project.carina.demo.gui_components.enums.UserStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Add User']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Employee Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement employeeNameTextField;

    @FindBy(xpath = "//*[text() = 'Employee Name']/ancestor::div[contains(@class, 'oxd-input-field')]//div[@role = 'listbox']//*[text() = '%s']")
    private ExtendedWebElement searchedEmployee;

    @FindBy(xpath = "//*[text() = 'Username']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement userNameTextField;

    @FindBy(xpath = "//*[text() = 'User Role']/ancestor::div[contains(@class, 'oxd-input-field')]//div[@role = 'listbox']//*[text() = '%s']")
    private ExtendedWebElement userRoles;

    @FindBy(xpath = "//*[text() = 'User Role']/ancestor::div[contains(@class, 'oxd-input-field')]//div[@class ='oxd-select-text--after']")
    private ExtendedWebElement userRoleArrowDownBtn;

    @FindBy(xpath = "//*[text() = 'Status']/ancestor::div[contains(@class, 'oxd-input-field')]//div[@class ='oxd-select-text--after']")
    private ExtendedWebElement userStatusArrowDownBtn;

    @FindBy(xpath = "//*[text() = 'Status']/ancestor::div[contains(@class, 'oxd-input-field')]//div[@role = 'listbox']//*[text() = '%s']")
    private ExtendedWebElement userStatus;

    @FindBy(xpath = "//*[text() = 'Password']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//*[text() = 'Confirm Password']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement confirmPasswordTextField;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement saveBtn;

    public AddUserPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void clickUserRoleArrowDownBtn() {
        userRoleArrowDownBtn.click();
    }

    public void clickUserRole(UserRole userRole) {
        userRoles.format(userRole.getRole()).click();
    }

    public void clickUserStatusArrowDownBtn() {
        userStatusArrowDownBtn.click();
    }

    public void clickUserStatus(UserStatus status) {
        userStatus.format(status.getStatus()).click();
    }

    public void typeUserName(String userName) {
        userNameTextField.type(userName);
    }

    public void clickSearchedEmployee(String employee) {
        searchedEmployee.format(employee).click();
    }

    public void typeEmployeeName(String name) {
        employeeNameTextField.type(name);
    }

    public void typePassword(String password) {
        passwordTextField.type(password);
    }

    public void typeConfirmPassword(String password) {
        confirmPasswordTextField.type(password);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }
}
