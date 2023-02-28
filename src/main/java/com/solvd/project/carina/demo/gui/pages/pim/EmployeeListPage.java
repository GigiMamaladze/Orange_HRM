package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h5[text() = 'Employee Information']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Employee Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement employeeFullNameTextField;

    @FindBy(xpath = "//*[text() = '%s']")
    private ExtendedWebElement employeeIdInList;

    @FindBy(xpath = "//*[@class = 'oxd-table-body']//*[text() = '%s ']")
    private ExtendedWebElement searchedEmployeeName;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement searchBtn;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public boolean isEmployeeIdPresent(String id) {
        return employeeIdInList.format(id).isElementPresent();
    }

    public void typeEmployeeFullName(String employee) {
        employeeFullNameTextField.type(employee);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public boolean isSearchedEmployeePresent(String employeeName) {
        return searchedEmployeeName.format(employeeName).isElementPresent();
    }
}
