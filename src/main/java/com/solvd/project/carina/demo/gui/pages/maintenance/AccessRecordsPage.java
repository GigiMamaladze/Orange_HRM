package com.solvd.project.carina.demo.gui.pages.maintenance;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccessRecordsPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//*[text() = 'Employee Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement employeeFullNameTextField;

    @FindBy(xpath = "//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement suggestedEmployee;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Search ']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Download ']")
    private ExtendedWebElement downloadBtn;

    public AccessRecordsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(employeeFullNameTextField);
    }

    public void typeEmployeeFullName(String employeeFullName) {
        employeeFullNameTextField.type(employeeFullName);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public void selectSuggestedEmployee(String employee) {
        suggestedEmployee.format(employee).click();
    }

    public void clickDownloadButton() {
        downloadBtn.click();
    }
}
