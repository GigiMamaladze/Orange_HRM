package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.pages.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends AbstractOrangeHRMTest {

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
        DashboardPage dashboardPage = authUtil.logInDefaultUser();
        dashboardPage.getTopBarMenu().clickUserNameArrowIcon();
        UpdatePasswordPage updatePasswordPage = dashboardPage.getTopBarMenu().clickChangePasswordBtn();
        Assert.assertTrue(updatePasswordPage.isPageOpened(), "Update password page is not opened");
        updatePasswordPage.typeCurrentPassword(R.TESTDATA.get("password"));
        updatePasswordPage.typeNewPassword(R.TESTDATA.get("newPassword"));
        updatePasswordPage.confirmPassword(R.TESTDATA.get("newPassword"));
        updatePasswordPage.clickSaveBtn();
        Assert.assertTrue(updatePasswordPage.isSuccessSaveMessagePresent(), "Password is not changed successfully");
    }
}
