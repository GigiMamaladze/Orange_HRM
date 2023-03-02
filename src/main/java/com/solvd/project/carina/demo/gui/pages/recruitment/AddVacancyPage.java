package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddVacancyPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Add Vacancy']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Vacancy Name']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement vacancyNameTextField;

    @FindBy(xpath = "//*[text() = 'Job Title']//ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-select-wrapper']")
    private ExtendedWebElement jobTitleComboBox;

    @FindBy(xpath = "//*[text() = 'Job Title']//ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-select-wrapper']//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement jobTitleListItem;

    @FindBy(xpath = "//*[text() = 'Hiring Manager']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement hiringManagerTextField;

    @FindBy(xpath = "//*[text() = 'Hiring Manager']/ancestor::div[contains(@class, 'oxd-input-field')]//*[@role = 'listbox']//*[text() = '%s']")
    private ExtendedWebElement suggestedHiringManagerListEmployee;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Save ']")
    private ExtendedWebElement saveBtn;

    public AddVacancyPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typeVacancyName(String vacancyName) {
        vacancyNameTextField.type(vacancyName);
    }

    public void selectJobTitle(String jobTitle) {
        jobTitleComboBox.click();
        jobTitleListItem.format(jobTitle).click();
    }

    public void typeHiringManagerAndSelectEmployee(String employee) {
        hiringManagerTextField.type(employee);
        suggestedHiringManagerListEmployee.format(employee).click();
    }

    public EditVacancyPage clickSaveButton() {
        saveBtn.click();
        return new EditVacancyPage(getDriver());
    }
}
