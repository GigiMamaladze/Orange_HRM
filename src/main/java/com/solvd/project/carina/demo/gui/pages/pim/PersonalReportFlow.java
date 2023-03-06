package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.project.carina.demo.components.enums.PersonalReportColumnTitle;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalReportFlow extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = '%s']")
    private ExtendedWebElement reportTitle;

    @FindBy(xpath = "//*[@class = 'header-content'][text() = \"%s\"]")
    private ExtendedWebElement columnTitle;

    @FindBy(css = ".scroll-rgCol")
    private ExtendedWebElement reportForm;

    public PersonalReportFlow(WebDriver driver) {
        super(driver);
    }

    public boolean isReportTitlePresent(String title) {
        return reportTitle.format(title).isElementPresent();
    }

    public boolean isColumnTitlePresent(PersonalReportColumnTitle personalReportColumnTitle) {
        return columnTitle.format(personalReportColumnTitle.getColumnTitle()).isElementPresent();
    }

    public void scrollToLastColumns() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", reportForm.getElement());
    }
}
