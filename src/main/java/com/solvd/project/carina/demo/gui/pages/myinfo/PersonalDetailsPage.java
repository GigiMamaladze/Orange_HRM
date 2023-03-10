package com.solvd.project.carina.demo.gui.pages.myinfo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.project.carina.demo.components.enums.Month;
import com.solvd.project.carina.demo.components.exceptions.OutDayRangeException;
import com.solvd.project.carina.demo.components.exceptions.OutYearRangeException;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Year;

public class PersonalDetailsPage extends AbstractOrangeHRMPage {

    @FindBy(xpath = "//h6[text() = 'Personal Details']")
    private ExtendedWebElement formTitle;

    @FindBy(css = ".orangehrm-firstname")
    private ExtendedWebElement firstNameTextField;

    @FindBy(css = ".orangehrm-lastname")
    private ExtendedWebElement lastNameTextField;

    @FindBy(xpath = "//*[text() = 'Date of Birth']/ancestor::div[contains(@class, 'oxd-input-field')]//*[@class = 'oxd-date-wrapper']//input")
    private ExtendedWebElement dateOfBirthCalendarTextField;

    @FindBy(css = ".oxd-calendar-selector-month")
    private ExtendedWebElement monthDropDownBtn;

    @FindBy(css = ".oxd-calendar-selector-year")
    private ExtendedWebElement yearDropDownBtn;

    @FindBy(xpath = "//h6[text() = 'Personal Details']/..//*[text() = ' Save ']")
    private ExtendedWebElement personalDetailsFormSaveBtn;

    @FindBy(xpath = "//*[@class = '--active oxd-calendar-selector-month']//ul[@role  = 'menu']/li[text() = '%s']")
    private ExtendedWebElement monthElement;

    @FindBy(xpath = "//*[@class = 'oxd-calendar-selector-month-selected']")
    private ExtendedWebElement selectedMonth;

    @FindBy(xpath = "//*[@class = '--active oxd-calendar-selector-year']//ul[@role  = 'menu']/li[text() = '%s']")
    private ExtendedWebElement yearElement;

    @FindBy(xpath = "//*[@class = 'oxd-calendar-dates-grid']//*[contains(@class, 'oxd-calendar-date-wrapper')]//*[text() = '%s']")
    private ExtendedWebElement dayElement;

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(formTitle);
    }

    public void clearFirstNameTextField() {
        clearTextField(firstNameTextField.getElement());
    }

    public void typeFirstName(String firstName) {
        firstNameTextField.type(firstName);
    }

    public void clearLastNameTextField() {
        clearTextField(lastNameTextField.getElement());
    }

    public void typeLastName(String lastName) {
        lastNameTextField.type(lastName);
    }

    public void scrollToDateOfBirthCalendar() {
        dateOfBirthCalendarTextField.scrollTo();
    }

    public void clickDateOfBirthCalendarIcon() {
        dateOfBirthCalendarTextField.click();
    }

    public void selectMonth(Month month) {
        monthDropDownBtn.click();
        this.monthElement.format(month.getMonthName()).click();
    }

    public void selectYear(int year) {
        yearDropDownBtn.click();
        int currentYear = Year.now().getValue();
        if (year < 1970 || year > currentYear) {
            throw new OutYearRangeException("Year is not in range");
        } else {
            this.yearElement.format(String.valueOf(year)).click();
        }
    }

    public void selectDay(int day) {
        String monthText = selectedMonth.getText().toUpperCase();
        Month monthEnum = Month.valueOf(monthText);
        if (monthEnum == Month.FEBRUARY && day > 28) {
            throw new OutDayRangeException("Day is out of range");
        } else if ((monthEnum == Month.APRIL || monthEnum == Month.JUNE || monthEnum == Month.SEPTEMBER || monthEnum == Month.NOVEMBER) && day > 30) {
            throw new OutDayRangeException("Day is out of range");
        } else if (day > 31) {
            throw new OutDayRangeException("Day is out of range");
        } else {
            dayElement.format(String.valueOf(day)).click();
        }
    }

    public void clickPersonalDetailsSaveButton() {
        personalDetailsFormSaveBtn.scrollTo();
        personalDetailsFormSaveBtn.click();
    }

    public String getFirstName() {
        return firstNameTextField.getAttribute("value");
    }

    public String getLastName() {
        return lastNameTextField.getAttribute("value");
    }

    public String getDateOfBirth() {
        return dateOfBirthCalendarTextField.getAttribute("value");
    }
}
