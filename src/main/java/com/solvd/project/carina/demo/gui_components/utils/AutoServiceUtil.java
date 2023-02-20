package com.solvd.project.carina.demo.gui_components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.LogInPage;
import org.testng.Assert;

public class AutoServiceUtil extends AbstractTest {

    public DashboardPage logIn(String userName, String password) {
        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.open();
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page is opened");
        logInPage.typeUserName(userName);
        logInPage.typePassword(password);
        DashboardPage dashboardPage = logInPage.clickLogInButton();
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard page is not opened. user is not logged in");
        return dashboardPage;
    }
}
