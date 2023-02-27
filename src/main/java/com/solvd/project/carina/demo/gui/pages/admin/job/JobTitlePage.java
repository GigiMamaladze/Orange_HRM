package com.solvd.project.carina.demo.gui.pages.admin.job;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.DeleteJobConfirmationAlert;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class JobTitlePage extends AbstractOrangeHRMPage {

    @FindBy(css = ".oxd-dialog-sheet--shadow")
    private DeleteJobConfirmationAlert deleteJobConfirmationAlert;

    @FindBy(xpath = "//*[@class = 'oxd-text oxd-text--h6 orangehrm-main-title'][text() = 'Job Titles']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = ' Add ']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-cell oxd-padding-cell']//*[text() = '%s']")
    private ExtendedWebElement jobTitle;

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

    public boolean isJobTitlePresent(String title) {
        return jobTitle.format(title).isElementPresent(5);
    }

    public void scrollToJobTitle(String title) {
        jobTitle.format(title).scrollTo();
    }

    public void deleteJobTitle(String jobTitle) {
        jobTitleTrashBtn.format(jobTitle).click();
    }

    public DeleteJobConfirmationAlert getDeleteJobConfirmationAlert() {
        return deleteJobConfirmationAlert;
    }
}
