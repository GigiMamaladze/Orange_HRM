package com.solvd.project.carina.demo.gui.pages.recruitment;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditVacancyPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Edit Vacancy']")
    private ExtendedWebElement formTitle;

    public EditVacancyPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }
}
