package com.solvd.project.carina.demo.gui.pages.admin.job;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddJobTitlePage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//*[text() = 'Add Job Title']")
    private ExtendedWebElement formTitle;

    @FindBy(xpath = "//*[text() = 'Successfully Saved']")
    private ExtendedWebElement successSaveMessage;

    @FindBy(xpath = "//*[text() = 'Job Title']/ancestor::div[contains(@class, 'oxd-input-field')]//input")
    private ExtendedWebElement jobTitleTextField;

    @FindBy(xpath = "//*[text() = ' Save ']")
    private ExtendedWebElement saveBtn;

    public AddJobTitlePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void typeJobTitle(String jobTitle) {
        jobTitleTextField.type(jobTitle);
    }

    public void clickSaveBtn() {
        saveBtn.click();
    }
}
