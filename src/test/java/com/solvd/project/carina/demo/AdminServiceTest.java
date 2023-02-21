package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.pages.AddUserPage;
import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.UserManagementPage;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMTest;
import com.solvd.project.carina.demo.gui_components.enums.UserRole;
import com.solvd.project.carina.demo.gui_components.enums.UserStatus;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addUserTest() {
        DashboardPage dashboardPage = authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = dashboardPage.getNavBarMenu().clickAdminLabel();
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
        Assert.assertTrue(addUserPage.isSuccessSaveMessage(), "User is not added");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void systemUserSearchTest() {
        DashboardPage dashboardPage = authUtil.logInDefaultUser();
        UserManagementPage userManagementPage = dashboardPage.getNavBarMenu().clickAdminLabel();
        Assert.assertTrue(userManagementPage.isPageOpened(), "User management page is not opened");
        String userName = "Admin";
        userManagementPage.typeUserName(userName);
        userManagementPage.clickSearchBtn();
        Assert.assertTrue(userManagementPage.isUserPresent(userName), "User is not founded");
    }
}
