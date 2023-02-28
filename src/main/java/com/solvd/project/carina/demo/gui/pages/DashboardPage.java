package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//*[@class = 'oxd-topbar-header-breadcrumb']//*[text() = 'Dashboard']")
    private ExtendedWebElement pageTitle;

    public DashboardPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }
}
