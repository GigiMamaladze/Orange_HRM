package com.solvd.project.carina.demo.gui_components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.UserManagementPage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import com.solvd.project.carina.demo.gui_components.exceptions.NoPageExistInMenuException;
import org.testng.Assert;

public class NavigationUtil extends AbstractTest {


    private UserManagementPage loadDefaultAdminPage() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard page is not opened. user is not logged in");
        UserManagementPage userManagementPage = dashboardPage.getLeftBarMenu().clickAdminLabel();
        Assert.assertTrue(userManagementPage.isPageOpened(), "User management page is not opened");
        return userManagementPage;
    }

    private JobTitlePage loadJobTitlePage() {
        UserManagementPage userManagementPage = loadDefaultAdminPage();
        userManagementPage.getTopBarMenu().clickJobSection();
        JobTitlePage jobTitlePage = userManagementPage.getTopBarMenu().clickJobTitleLabel();
        Assert.assertTrue(jobTitlePage.isPageOpened(), "Job Title page is not opened");
        return jobTitlePage;
    }

    private EmployeeListPage loadDefaultPimPage() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        EmployeeListPage employeeListPage = dashboardPage.getLeftBarMenu().clickPimLabel();
        Assert.assertTrue(employeeListPage.isPageOpened(), "Employee list page is not opened");
        return employeeListPage;
    }


    public AbstractOrangeHRMPage openPage(MenuOption menuOption) throws NoPageExistInMenuException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isPageOpened(), "Dashboard page is not opened. user is not logged in");
        switch (menuOption) {
            case ADMIN_DEFAULT:
                return loadDefaultAdminPage();
            case ADMIN_JOB_TITLE:
                return loadJobTitlePage();
            case PIM_DEFAULT:
                return loadDefaultPimPage();
            default:
                throw new NoPageExistInMenuException("Page is not exist");
        }
    }
}
