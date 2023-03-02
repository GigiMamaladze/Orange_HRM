package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddCandidatePage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Add Candidate']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".orangehrm-firstname")
    private ExtendedWebElement firstNameTextField;

    @FindBy(css = ".orangehrm-lastname")
    private ExtendedWebElement lastNameTextField;

    @FindBy(xpath = "//*[text() = 'Vacancy']//ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-select-wrapper']")
    private ExtendedWebElement vacancyComboBox;

    @FindBy(xpath = "//*[text() = 'Vacancy']//ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-select-wrapper']//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement vacancyListItem;

    @FindBy(xpath = "//*[text() = 'Email']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Save ']")
    private ExtendedWebElement saveBtn;

    public AddCandidatePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typeFirstName(String firstName) {
        firstNameTextField.type(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameTextField.type(lastName);
    }

    public void selectVacancy(String vacancy) {
        vacancyComboBox.click();
        vacancyListItem.format(vacancy).click();
    }

    public void typeEmail(String email) {
        emailTextField.type(email);
    }

    public CreatedCandidatePage clickSaveBtn() {
        saveBtn.click();
        return new CreatedCandidatePage(getDriver());
    }
}
