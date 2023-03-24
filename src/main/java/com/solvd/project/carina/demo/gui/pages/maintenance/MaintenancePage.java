package com.solvd.project.carina.demo.gui.pages.maintenance;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MaintenancePage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Purge Employee Records']")
    private ExtendedWebElement formTitle;

    public MaintenancePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }
}
