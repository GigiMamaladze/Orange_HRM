package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreatedCandidatePage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Candidate Profile']")
    private ExtendedWebElement candidateProfileFormTitle;

    public CreatedCandidatePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(candidateProfileFormTitle);
    }
}
