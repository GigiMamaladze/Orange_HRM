package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.pages.UpdatePasswordPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends AbstractUIObject {

    @FindBy(css = ".oxd-userdropdown-icon")
    private ExtendedWebElement userNameArrowIcon;

    @FindBy(xpath = "//*[text() = 'Change Password']")
    private ExtendedWebElement changePasswordBtn;

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickUserNameArrowIcon() {
        userNameArrowIcon.click();
    }

    public UpdatePasswordPage clickChangePasswordBtn() {
        changePasswordBtn.click();
        return new UpdatePasswordPage(getDriver());
    }
}
