package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LeftBarMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@class = 'oxd-main-menu-item-wrapper']//*[text() = '%s']")
    private ExtendedWebElement menu;

    public LeftBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LeftBarMenu(WebDriver driver) {
        super(driver);
    }

    public void clickMenuOption(MenuOption menuOption) {
        menu.format(menuOption.getMenuOption()).click();
    }
}
