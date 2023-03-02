package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h5[text() = 'Candidates']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[@type = 'button'][text() = ' Add ']")
    private ExtendedWebElement addBtn;

    @FindBy(xpath = "//*[@class = 'oxd-table-card']//*[text() = '%s']")
    private ExtendedWebElement candidateInList;

    public CandidatesPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public AddCandidatePage clickAddButton() {
        addBtn.click();
        return new AddCandidatePage(getDriver());
    }

    public boolean isCandidatePresentInList(String candidate) {
        return candidateInList.format(candidate).isElementPresent();
    }
}
