package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.enums.selectboxlist.FieldGroupListItem;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddReportPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Add Report']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Report Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement reportNameTextField;

    @FindBy(xpath = "//*[text() = 'Select Display Field Group']//ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-select-wrapper']")
    private ExtendedWebElement fieldGroupComboBox;

    @FindBy(xpath = "//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement fieldGroupComboBoxListItem;

    @FindBy(xpath = "//*[text() = 'Select Display Field']//ancestor::div[contains(@class, 'oxd-grid-item')]//*[@class = 'oxd-icon bi-plus']")
    private ExtendedWebElement displayFieldPlusBtn;

    @FindBy(xpath = "//*[@type = 'submit']")
    private ExtendedWebElement saveBtn;

    public AddReportPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typeReportName(String reportName) {
        reportNameTextField.type(reportName);
    }

    public PersonalReportFlow clickSaveBtn() {
        saveBtn.click();
        return new PersonalReportFlow(getDriver());
    }

    public void selectFieldGroup(FieldGroupListItem fieldGroupListItem) {
        fieldGroupComboBox.click();
        fieldGroupComboBoxListItem.format(fieldGroupListItem.getListItem()).click();
    }

    public void clickDisplayFieldPlusButton() {
        displayFieldPlusBtn.click();
    }
}
