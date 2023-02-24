package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.navbars.PimNavBarMenu;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage extends AbstractOrangeHRMPage {

    @FindBy(css = ".oxd-topbar-body-nav")
    private PimNavBarMenu pimNavBarMenu;

    @FindBy(xpath = "//h6[text() = 'Add Employee']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".orangehrm-firstname")
    private ExtendedWebElement firstNameTextField;

    @FindBy(css = ".orangehrm-middlename")
    private ExtendedWebElement middleNameTextField;

    @FindBy(css = ".orangehrm-lastname")
    private ExtendedWebElement lastNameTextField;

    @FindBy(xpath = "//*[text() = 'Employee Id']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement employeeIdTextField;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement saveBtn;

    public AddEmployeePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public String getEmployeeId() {
        return employeeIdTextField.getText();
    }

    public PimNavBarMenu getPimNavBarMenu() {
        return pimNavBarMenu;
    }

    public void typeFirstName(String firstName) {
        firstNameTextField.type(firstName);
    }

    public void typeMiddleName(String middleName) {
        middleNameTextField.type(middleName);
    }

    public void typeLastName(String lastName) {
        lastNameTextField.type(lastName);
    }

    public PersonalDetailsPage clickSaveBtn() {
        saveBtn.click();
        return new PersonalDetailsPage(getDriver());
    }
}
