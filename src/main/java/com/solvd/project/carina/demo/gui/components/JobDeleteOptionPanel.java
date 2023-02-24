package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class JobDeleteOptionPanel extends AbstractUIObject {

    @FindBy(xpath = "//button[text() = ' Yes, Delete ']")
    private ExtendedWebElement yesDeleteBtn;

    public JobDeleteOptionPanel(WebDriver driver) {
        super(driver);
    }

    public JobDeleteOptionPanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickYesDeleteBtn() {
        yesDeleteBtn.click();
    }
}
