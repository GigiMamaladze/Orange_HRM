package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h5[text() = 'Employee Reports']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//*[text() = 'Report Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement reportNameTextField;

    @FindBy(xpath = "//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement suggestedReportNameItem;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Search ']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[text() = ' Add ']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-card']//*[text() = '%s']")
    private ExtendedWebElement reportInList;

    public ReportsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public AddReportPage clickAddButton() {
        addBtn.click();
        return new AddReportPage(getDriver());
    }

    public boolean isReportPresentInList(String reportName) {
        return reportInList.format(reportName).isElementPresent();
    }

    public void typeReportName(String reportName) {
        reportNameTextField.type(reportName);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public void clickSuggestedReportNameItem(String reportName) {
        suggestedReportNameItem.format(reportName).click();
    }
}
