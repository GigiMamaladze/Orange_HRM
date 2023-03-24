package com.solvd.project.carina.demo.gui.pages.maintenance;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.components.PurgeCandidatesConfirmationAlert;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CandidateRecordsPurgePage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Purge Candidate Records']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".oxd-sheet")
    private PurgeCandidatesConfirmationAlert purgeCandidatesConfirmationAlert;

    @FindBy(xpath = "//*[text() = 'Vacancy']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement vacancyTextField;

    @FindBy(xpath = "//*[@role = 'option']//*[text() = '%s']")
    private ExtendedWebElement suggestedVacancy;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Search ']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@type = 'button'][text() = ' Purge All ']")
    private ExtendedWebElement purgeAll;

    @FindBy(xpath = "//*[@class = 'oxd-table-card']//*[text() = '%s']")
    private ExtendedWebElement candidateInList;

    public CandidateRecordsPurgePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typeVacancy(String vacancy) {
        vacancyTextField.type(vacancy);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public void selectSuggestedVacancy(String vacancyName) {
        suggestedVacancy.format(vacancyName).click();
    }

    public boolean isCandidatePresent(String candidateFullName) {
        return candidateInList.format(candidateFullName).isElementPresent(3);
    }

    public PurgeCandidatesConfirmationAlert getPurgeCandidatesConfirmationAlert() {
        return purgeCandidatesConfirmationAlert;
    }

    public void clickPurgeAllButton() {
        purgeAll.click();
    }
}
