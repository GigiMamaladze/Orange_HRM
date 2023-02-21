package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.pages.*;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMTest;
import com.solvd.project.carina.demo.gui_components.enums.UserRole;
import com.solvd.project.carina.demo.gui_components.enums.UserStatus;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void logInTest() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page is opened");
        logInPage.typeUserName(R.TESTDATA.get("userName"));
        logInPage.typePassword(R.TESTDATA.get("password"));
        DashboardPage dashboardPage = logInPage.clickLogInButton();
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard Page is not opened. user is not logged in");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void resetPasswordTest() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page is opened");
        PasswordResetCodePage passwordResetCodePage = logInPage.clickForgotYourPasswordBtn();
        Assert.assertTrue(passwordResetCodePage.isPageOpened(), "Password reset page is not opened");
        passwordResetCodePage.typeUserName(R.TESTDATA.get("userName"));
        SendPasswordResetPage sendPasswordResetPage = passwordResetCodePage.clickResetPasswordBtn();
        Assert.assertTrue(sendPasswordResetPage.isResetPasswordLinkSent(), "Reset password link is not sent");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void changePasswordTest() {
        DashboardPage dashboardPage = authUtil.logIn(R.TESTDATA.get("userName"),
                R.TESTDATA.get("password"));
        dashboardPage.topBarMenu.clickUserNameArrowIcon();
        UpdatePasswordPage updatePasswordPage = dashboardPage.getTopBarMenu().clickChangePasswordBtn();
        Assert.assertTrue(updatePasswordPage.isPageOpened(), "Update password page is not opened");
        updatePasswordPage.typeCurrentPassword(R.TESTDATA.get("password"));
        updatePasswordPage.typeNewPassword(R.TESTDATA.get("newPassword"));
        updatePasswordPage.confirmPassword(R.TESTDATA.get("newPassword"));
        updatePasswordPage.clickSaveBtn();
        Assert.assertTrue(updatePasswordPage.isSuccessSaveMessage(), "Password is not changed successfully");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void addUserTest() {
        DashboardPage dashboardPage = authUtil.logIn(R.TESTDATA.get("userName"),
                R.TESTDATA.get("password"));
        UserManagementPage userManagementPage = dashboardPage.getNavBarMenu().clickAdminLabel();
        Assert.assertTrue(userManagementPage.isPageOpened(), "User management page is not opened");
        AddUserPage addUserPage = userManagementPage.clickAddUserBtn();
        Assert.assertTrue(addUserPage.isPageOpened(), "Add user page is not opened");
        addUserPage.typeUserName(randomUtil.generateRandomString(10));
        addUserPage.typeEmployeeName(R.TESTDATA.get("employee"));
        addUserPage.clickSearchedEmployee(R.TESTDATA.get("employee"));
        addUserPage.clickUserRoleArrowDownBtn();
        addUserPage.clickUserRole(UserRole.ADMIN);
        addUserPage.clickUserStatusArrowDownBtn();
        addUserPage.clickUserStatus(UserStatus.ENABLED);
        addUserPage.typePassword(R.TESTDATA.get("newPassword"));
        addUserPage.typeConfirmPassword(R.TESTDATA.get("newPassword"));
        addUserPage.clickSaveBtn();
        Assert.assertTrue(addUserPage.isSuccessSaveMessage(), "User is not added");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void systemUserSearchTest() {
        DashboardPage dashboardPage = authUtil.logIn(R.TESTDATA.get("userName"),
                R.TESTDATA.get("password"));
        UserManagementPage userManagementPage = dashboardPage.getNavBarMenu().clickAdminLabel();
        Assert.assertTrue(userManagementPage.isPageOpened(), "User management page is not opened");
        String userName = "Admin";
        userManagementPage.typeUserName(userName);
        userManagementPage.clickSearchBtn();
        Assert.assertTrue(userManagementPage.isUserPresent(userName), "User is not founded");
    }
}
