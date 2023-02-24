package com.solvd.project.carina.demo.gui.components.navbars;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui_components.enums.sections.PimSection;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PimNavBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'oxd-topbar-body-nav-tab-item'][text() = '%s']")
    private ExtendedWebElement sections;

    public PimNavBarMenu(WebDriver driver) {
        super(driver);
    }

    public PimNavBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AddEmployeePage clickAddEmployeeSection() {
        sections.format(PimSection.ADD_EMPLOYEE.getSection()).click();
        return new AddEmployeePage(getDriver());
    }

    public EmployeeListPage clickEmployeeListSection() {
        sections.format(PimSection.EMPLOYEE_LIST.getSection()).click();
        return new EmployeeListPage(getDriver());
    }
}
