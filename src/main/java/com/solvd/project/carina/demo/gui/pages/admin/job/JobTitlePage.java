package com.solvd.project.carina.demo.gui.pages.admin.job;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.JobDeleteOptionPanel;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class JobTitlePage extends AbstractOrangeHRMPage {

    @FindBy(css = ".oxd-dialog-sheet--shadow")
    private JobDeleteOptionPanel jobDeleteOptionPanel;

    @FindBy(xpath = "//*[@class = 'oxd-text oxd-text--h6 orangehrm-main-title'][text() = 'Job Titles']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = ' Add ']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-cell oxd-padding-cell']//*[text() = '%s']")
    private ExtendedWebElement jobTitles;

    @FindBy(xpath = "//*[text() = '%s']/ancestor::div[contains(@class, 'oxd-table-row')]//*[@class = 'oxd-icon bi-trash']")
    private ExtendedWebElement jobTitleTrashBtn;

    public JobTitlePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public AddJobTitlePage clickAddBtn() {
        addBtn.click();
        return new AddJobTitlePage(getDriver());
    }

    public boolean isJobTitlePresent(String jobTitle) {
        return jobTitles.format(jobTitle).isElementPresent(5);
    }

    public void scrollToJobTitle(String jobTitle) {
        jobTitles.format(jobTitle).scrollTo();
    }

    public void deleteJobTitle(String jobTitle) {
        jobTitleTrashBtn.format(jobTitle).click();
    }

    public JobDeleteOptionPanel getJobDeleteOptionPanel() {
        return jobDeleteOptionPanel;
    }
}
