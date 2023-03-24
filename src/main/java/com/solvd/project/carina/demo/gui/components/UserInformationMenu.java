package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.components.enums.UserInformationMenuItem;
import com.solvd.project.carina.demo.components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.ContactDetailsPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.EmergencyContactPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.PersonalDetailsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserInformationMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@role ='tab']//*[text() = '%s']")
    private ExtendedWebElement menuItem;

    public UserInformationMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AbstractOrangeHRMPage open(UserInformationMenuItem userInformationMenuItem) {
        menuItem.format(userInformationMenuItem.getMenuItem()).click();
        switch (userInformationMenuItem) {
            case CONTACT_DETAILS:
                return new ContactDetailsPage(getDriver());
            case PERSONA_DETAILS:
                return new PersonalDetailsPage(getDriver());
            case EMERGENCY_CONTRACT:
                return new EmergencyContactPage(getDriver());
            default:
                throw new NoPageExistInMenuException("No such menu in list");
        }
    }
}
