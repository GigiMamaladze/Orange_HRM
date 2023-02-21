package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.NavBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPage {

    @FindBy(css = ".oxd-topbar-header-userarea")
    public TopBarMenu topBarMenu;

    @FindBy(css = ".oxd-navbar-nav")
    public NavBarMenu navBarMenu;

    @FindBy(xpath = "//*[@class = 'oxd-topbar-header-breadcrumb']//*[text() = 'Dashboard']")
    private ExtendedWebElement pageTitle;

    public DashboardPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }

    public TopBarMenu getTopBarMenu() {
        return topBarMenu;
    }

    public NavBarMenu getNavBarMenu() {
        return navBarMenu;
    }
}
