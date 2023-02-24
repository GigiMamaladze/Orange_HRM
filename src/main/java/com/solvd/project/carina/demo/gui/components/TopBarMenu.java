package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.UpdatePasswordPage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.organization.GeneralInformationPage;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui_components.enums.sections.AdminSection;
import com.solvd.project.carina.demo.gui_components.enums.sections.PimSection;
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

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickUserNameArrowIcon() {
        userNameArrowIcon.click();
    }

    public UpdatePasswordPage clickChangePasswordBtn() {
        changePasswordBtn.click();
        return new UpdatePasswordPage(getDriver());
    }

    public void clickOrganizationSection() {
        sections.format(AdminSection.ORGANIZATION.getSection()).click();
    }

    public void clickJobSection() {
        sections.format(AdminSection.JOB.getSection()).click();
    }

    public JobTitlePage clickJobTitleLabel() {
        subSection.format(AdminSection.AdminSubSection.JOB_JOB_TITLE.getSubsection()).click();
        return new JobTitlePage(getDriver());
    }

    public GeneralInformationPage clickGeneralInformationLabel() {
        subSection.format(AdminSection.AdminSubSection.ORGANIZATION_GENERAL_INFORMATION.getSubsection()).click();
        return new GeneralInformationPage(getDriver());
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
