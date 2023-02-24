package com.solvd.project.carina.demo.gui.components.navbars;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.organization.GeneralInformationPage;
import com.solvd.project.carina.demo.gui_components.enums.sections.AdminSection;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdminNavBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'oxd-topbar-body-nav-tab-item'][text() = '%s']")
    private ExtendedWebElement sections;

    @FindBy(xpath = "//*[@class = 'oxd-dropdown-menu']//*[text() = '%s']")
    private ExtendedWebElement subSection;

    public AdminNavBarMenu(WebDriver driver) {
        super(driver);
    }

    public AdminNavBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickJobSection() {
        sections.format(AdminSection.JOB.getSection()).click();
    }

    public JobTitlePage clickJobTitleLabel() {
        subSection.format(AdminSection.AdminSubSection.JOB_JOB_TITLE.getSubsection()).click();
        return new JobTitlePage(getDriver());
    }

    public void clickOrganizationSection() {
        sections.format(AdminSection.ORGANIZATION.getSection()).click();
    }

    public GeneralInformationPage clickGeneralInformation() {
        subSection.format(AdminSection.AdminSubSection.ORGANIZATION_GENERAL_INFORMATION.getSubsection()).click();
        return new GeneralInformationPage(getDriver());
    }
}
