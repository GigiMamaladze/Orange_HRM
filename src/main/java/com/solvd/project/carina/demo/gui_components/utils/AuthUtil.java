package com.solvd.project.carina.demo.gui_components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.LogInPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;

public class AuthUtil extends AbstractTest {

    public DashboardPage logIn(String userName, String password) {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page is not opened");
        logInPage.typeUserName(userName);
        logInPage.typePassword(password);
        DashboardPage dashboardPage = logInPage.clickLogInButton();
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard page is not opened. user is not logged in");
        return dashboardPage;
    }

    public DashboardPage logInDefaultUser() {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page is not opened");
        logInPage.typeUserName(R.TESTDATA.get("userName"));
        logInPage.typePassword(R.TESTDATA.get("password"));
        DashboardPage dashboardPage = logInPage.clickLogInButton();
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard page is not opened. user is not logged in");
        return dashboardPage;
    }
}
