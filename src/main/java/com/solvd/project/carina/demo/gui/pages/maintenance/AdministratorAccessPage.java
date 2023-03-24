package com.solvd.project.carina.demo.gui.pages.maintenance;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AdministratorAccessPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Administrator Access']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[@name = 'password']")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Confirm ']")
    private ExtendedWebElement confirmBtn;

    public AdministratorAccessPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typePassword(String password) {
        passwordTextField.type(password);
    }

    public MaintenancePage clickConfirmButton() {
        confirmBtn.click();
        return new MaintenancePage(getDriver());
    }
}
