package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.enums.Month;
import com.solvd.project.carina.demo.components.utils.DataFormatUtil;
import com.solvd.project.carina.demo.gui.pages.myinfo.PersonalDetailsPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    private void personalDetailsEditTest() {
        authUtil.logInDefaultUser();
        PersonalDetailsPage personalDetailsPage = (PersonalDetailsPage) navigationUtil.open(MenuOption.MY_INFO);
        Assert.assertTrue(personalDetailsPage.isPageOpened(), "Personal details page is opened");
        String firstName = randomUtil.getRandomString(6);
        String lastName = randomUtil.getRandomString(5);
        int day = 28;
        Month month = Month.FEBRUARY;
        int year = 2002;
        personalDetailsPage.clearFirstNameTextField();
        personalDetailsPage.typeFirstName(firstName);
        personalDetailsPage.clearLastNameTextField();
        personalDetailsPage.typeLastName(lastName);
        personalDetailsPage.scrollToDateOfBirthCalendar();
        personalDetailsPage.clickDateOfBirthCalendarIcon();
        personalDetailsPage.selectMonth(month);
        personalDetailsPage.selectYear(year);
        personalDetailsPage.selectDay(day);
        personalDetailsPage.clickPersonalDetailsSaveButton();
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName, "First Name is not changed");
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName, "Last name is not changed");
        Assert.assertEquals(personalDetailsPage.getDateOfBirth(), DataFormatUtil.formatToDate(year, month, day));
    }
}
