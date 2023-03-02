package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VacanciesPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h5[text() = 'Vacancies']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[@type = 'button'][text() = ' Add ']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-card']//*[text() = '%s']")
    private ExtendedWebElement vacancyInList;

    public VacanciesPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public AddVacancyPage clickAddButton() {
        addBtn.click();
        return new AddVacancyPage(getDriver());
    }

    public boolean isVacancyPresentInList(String vacancyName) {
        return vacancyInList.format(vacancyName).isElementPresent();
    }
}
