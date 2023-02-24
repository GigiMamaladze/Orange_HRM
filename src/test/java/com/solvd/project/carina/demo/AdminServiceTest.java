package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.components.DeleteHobConfirmationAlert;
import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.admin.job.AddJobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.organization.GeneralInformationPage;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.AddUserPage;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.UserManagementPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import com.solvd.project.carina.demo.gui_components.enums.UserRole;
import com.solvd.project.carina.demo.gui_components.enums.UserStatus;
import com.solvd.project.carina.demo.gui_components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addUserTest() {
        DashboardPage dashboardPage = authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = dashboardPage.getLeftBarMenu()
                .clickAdminLabel();
        Assert.assertTrue(userManagementPage.isPageOpened(), "User management page is not opened");
        AddUserPage addUserPage = userManagementPage.clickAddUserBtn();
        Assert.assertTrue(addUserPage.isPageOpened(), "Add user page is not opened");
        addUserPage.typeUserName(randomUtil.generateRandomString(10));
        addUserPage.typeEmployeeName(R.TESTDATA.get("employeeName"));
        addUserPage.clickSearchedEmployee(R.TESTDATA.get("employeeName"));
        addUserPage.clickUserRoleArrowDownBtn();
        addUserPage.clickUserRole(UserRole.ADMIN);
        addUserPage.clickUserStatusArrowDownBtn();
        addUserPage.clickUserStatus(UserStatus.ENABLED);
        addUserPage.typePassword(R.TESTDATA.get("newPassword"));
        addUserPage.typeConfirmPassword(R.TESTDATA.get("newPassword"));
        addUserPage.clickSaveBtn();
        Assert.assertTrue(addUserPage.isSuccessSaveMessagePresent(), "User is not added");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void systemUserSearchTest() throws NoPageExistInMenuException {
        authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = (UserManagementPage) navigationUtil.openPage(MenuOption.ADMIN_DEFAULT);
        String userName = "Admin";
        userManagementPage.typeUserName(userName);
        userManagementPage.clickSearchBtn();
        Assert.assertTrue(userManagementPage.isUserPresent(userName), "User is not founded");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void addJobTitleTest() throws NoPageExistInMenuException {
        authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = (UserManagementPage) navigationUtil.openPage(MenuOption.ADMIN_DEFAULT);
        userManagementPage.getTopBarMenu().clickJobSection();
        JobTitlePage jobTitlePage = userManagementPage.getTopBarMenu()
                .clickJobTitleLabel();
        Assert.assertTrue(jobTitlePage.isPageOpened(), "Job Title page is not opened");
        AddJobTitlePage addJobTitlePage = jobTitlePage.clickAddBtn();
        Assert.assertTrue(addJobTitlePage.isPageOpened(), "Add job title page is not opened");
        String jobTitle = randomUtil.generateRandomString(8);
        addJobTitlePage.typeJobTitle(jobTitle);
        addJobTitlePage.clickSaveBtn();
        Assert.assertTrue(addJobTitlePage.isSuccessSaveMessagePresent(), "Job is not created");
        Assert.assertTrue(jobTitlePage.isJobTitlePresent(jobTitle), "Job title is not exist in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void deleteJobTitle() throws NoPageExistInMenuException {
        authUtil.logInDefaultUser();
        String jobTitle = randomUtil.generateRandomString(9);
        JobTitlePage jobTitlePage = (JobTitlePage) navigationUtil.openPage(MenuOption.ADMIN_JOB_TITLE);
        AddJobTitlePage addJobTitlePage = jobTitlePage.clickAddBtn();
        Assert.assertTrue(addJobTitlePage.isPageOpened(), "Add job title page is not opened");
        adminUtil.addJobTitle(jobTitle);
        Assert.assertTrue(jobTitlePage.isJobTitlePresent(jobTitle), "Job title is not exist in list");
        jobTitlePage.scrollToJobTitle(jobTitle);
        jobTitlePage.deleteJobTitle(jobTitle);
        DeleteHobConfirmationAlert deleteHobConfirmationAlert = new DeleteHobConfirmationAlert(getDriver());
        deleteHobConfirmationAlert.clickYesDeleteBtn();
        Assert.assertTrue(jobTitlePage.isSuccessDeleteMessagePresent(), "Job is not deleted");
        Assert.assertFalse(jobTitlePage.isJobTitlePresent(jobTitle), "Job title exist in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void generalInformationEditTest() throws NoPageExistInMenuException, UnknownOsException {
        authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = (UserManagementPage) navigationUtil.openPage(MenuOption.ADMIN_DEFAULT);
        userManagementPage.getTopBarMenu().clickOrganizationSection();
        GeneralInformationPage generalInformationPage = userManagementPage.getTopBarMenu()
                .clickGeneralInformationLabel();
        Assert.assertTrue(generalInformationPage.isPageOpened(), "General information page is not opened");
        generalInformationPage.clickEditSwitchBtn();
        String registrationNumber = "1234";
        generalInformationPage.clearRegistrationNumber();
        generalInformationPage.typeRegistrationNumber(registrationNumber);
        generalInformationPage.clickSaveBtn();
        Assert.assertTrue(generalInformationPage.isSuccessUpdateMessagePresent(),
                "General Information is not changed");
        generalInformationPage.scrollToRegistrationTextField();
        Assert.assertEquals(generalInformationPage.getRegistrationNumber(), registrationNumber,
                "Registration number is not changed");
    }
}
