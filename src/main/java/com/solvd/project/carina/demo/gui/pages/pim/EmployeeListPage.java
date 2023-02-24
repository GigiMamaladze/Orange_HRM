package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.navbars.PimNavBarMenu;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui_components.utils.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends AbstractOrangeHRMPage {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeListPage.class);

    @FindBy(css = ".oxd-topbar-body-nav")
    private PimNavBarMenu pimNavBarMenu;

    @FindBy(xpath = "//*[text() = 'Employee Information']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Employee Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement employeeNameTextField;

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

    public PimNavBarMenu getPimNavBarMenu() {
        return pimNavBarMenu;
    }

    public boolean isEmployeeIdPresent(String id) {
        return employeeIdInList.format(id).isElementPresent();
    }

    public void typeEmployeeName(String employee) {
        employeeNameTextField.type(employee);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public boolean isSearchedEmployeePresent(String employeeName) {
        String name = StringUtil.splitText(employeeName)[0];
        LOGGER.info(name);
        return searchedEmployeeName.format(name).isElementPresent();
    }
}
