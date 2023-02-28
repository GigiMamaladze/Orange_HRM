package com.solvd.project.carina.demo.gui.pages.pim;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Personal Details']")
    private ExtendedWebElement formTitle;

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }
}
