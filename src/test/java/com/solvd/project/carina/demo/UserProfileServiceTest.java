package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.enums.Month;
import com.solvd.project.carina.demo.components.enums.UserInformationMenuItem;
import com.solvd.project.carina.demo.components.utils.DataFormatUtil;
import com.solvd.project.carina.demo.gui.pages.myinfo.ContactDetailsPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.EmergencyContactPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.PersonalDetailsPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void personalDetailsEditTest() {
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

    @Test
    @MethodOwner(owner = "Gigi")
    public void contactDetailsEditTest() {
        authUtil.logInDefaultUser();
        PersonalDetailsPage personalDetailsPage = (PersonalDetailsPage) navigationUtil.open(MenuOption.MY_INFO);
        ContactDetailsPage contactDetailsPage = (ContactDetailsPage) personalDetailsPage.getUserInformationMenu()
                .open(UserInformationMenuItem.CONTACT_DETAILS);
        Assert.assertTrue(contactDetailsPage.isPageOpened(), "Candidate Page is not opened");
        String street1 = randomUtil.getRandomString(8);
        String city = randomUtil.getRandomString(5);
        String homeTelephoneNumber = randomUtil.getRandomNumber(8);
        contactDetailsPage.clearStreet1TextField();
        contactDetailsPage.typeStreet1(street1);
        contactDetailsPage.clearCityTextField();
        contactDetailsPage.typeCity(city);
        contactDetailsPage.clearHomeTelephoneNumberTextField();
        contactDetailsPage.typeHomeTelephoneNumber(homeTelephoneNumber);
        contactDetailsPage.clickSaveButton();
        Assert.assertTrue(contactDetailsPage.isSuccessUpdateMessagePresent(), "Success Updated message is not present");
        Assert.assertEquals(contactDetailsPage.getStreet1(), street1, "Street 1 is not changed");
        Assert.assertEquals(contactDetailsPage.getCity(), city, "City is not changed");
        Assert.assertEquals(contactDetailsPage.getHomeTelephoneNumber(), homeTelephoneNumber,
                "Home telephone number is not changed");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void emergencyContactEditTest() {
        authUtil.logInDefaultUser();
        PersonalDetailsPage personalDetailsPage = (PersonalDetailsPage) navigationUtil.open(MenuOption.MY_INFO);
        EmergencyContactPage emergencyContactPage = (EmergencyContactPage) personalDetailsPage.getUserInformationMenu()
                .open(UserInformationMenuItem.EMERGENCY_CONTRACT);
        Assert.assertTrue(emergencyContactPage.isPageOpened(), "Emergency Contact page is not opened");
        emergencyContactPage.clickAssignedEmergencyContactsAddButton();
        Assert.assertTrue(emergencyContactPage.isEmergencyContactFormPresent(), "Emergency Contact form is not present");
        String name = randomUtil.getRandomString(5);
        String relationship = randomUtil.getRandomString(12);
        String homeTelephone = randomUtil.getRandomNumber(8);
        emergencyContactPage.clearNameTextField();
        emergencyContactPage.typeName(name);
        emergencyContactPage.clearRelationshipTextField();
        emergencyContactPage.typeRelationship(relationship);
        emergencyContactPage.clearHomeTelephoneTextField();
        emergencyContactPage.typeHomeTelephone(homeTelephone);
        emergencyContactPage.clickSaveButton();
        Assert.assertTrue(emergencyContactPage.isNamePresentInContact(name), "Name is not present in contact");
        Assert.assertTrue(emergencyContactPage.isRelationshipPresentInContact(relationship),
                "Relationship is not present in contact");
        Assert.assertTrue(emergencyContactPage.isHomeTelephonePresentInContact(homeTelephone),
                "Home telephone is not present in contact");
    }
}
