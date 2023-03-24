package com.solvd.project.carina.demo.gui.pages.directory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.enums.selectboxlist.Location;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Directory']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Location']/ancestor::div[contains(@class, 'oxd-input-field')]//*[@class ='oxd-select-text-input']")
    private ExtendedWebElement locationSelectBox;

    @FindBy(xpath = "//*[text() = 'Location']/ancestor::div[contains(@class, 'oxd-input-field')]//*[text() = '%s']")
    private ExtendedWebElement locationListItem;

    @FindBy(xpath = "//*[@type = 'submit'][text() = ' Search ']")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//*[@class = 'orangehrm-directory-card-body']//*[text() = '%s']")
    private ExtendedWebElement searchedEmployee;

    public DirectoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void selectLocation(Location location) {
        locationSelectBox.click();
        locationListItem.format(location.getLocation()).click();
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public boolean isEmployeePresentInLocation(Location location) {
        return searchedEmployee.format(location.getLocation()).isElementPresent();
    }
}
