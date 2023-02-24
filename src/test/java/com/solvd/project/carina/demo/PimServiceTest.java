package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.pages.DashboardPage;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui.pages.pim.PersonalDetailsPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import com.solvd.project.carina.demo.gui_components.exceptions.NoPageExistInMenuException;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addEmployeeTest() {
        DashboardPage dashboardPage = authUtil.logInDefaultUser();
        EmployeeListPage employeeListPage = dashboardPage.getLeftBarMenu().clickPimLabel();
        Assert.assertTrue(employeeListPage.isPageOpened(), "Employee list page is not opened");
        AddEmployeePage addEmployeePage = employeeListPage.getTopBarMenu().clickAddEmployeeSection();
        Assert.assertTrue(addEmployeePage.isPageOpened(), "Add employee page is not opened");
        String firstName = "Gigi";
        String lastName = "Mamaladze";
        addEmployeePage.typeFirstName(firstName);
        addEmployeePage.typeLastName(lastName);
        String id = addEmployeePage.getEmployeeId();
        PersonalDetailsPage personalDetailsPage = addEmployeePage.clickSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessagePresent(), "Employee is not saved");
        Assert.assertTrue(personalDetailsPage.isPageOpened(), "Personal details page is not opened");
        employeeListPage = personalDetailsPage.getTopBarMenu().clickEmployeeListSection();
        Assert.assertTrue(employeeListPage.isPageOpened(), "Employee List page is not opened");
        Assert.assertTrue(employeeListPage.isEmployeeIdPresent(id), "Employee is not present in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void searchEmployeeTest() throws NoPageExistInMenuException {
        authUtil.logInDefaultUser();
        EmployeeListPage employeeListPage = (EmployeeListPage) navigationUtil.openPage(MenuOption.PIM_DEFAULT);
        employeeListPage.typeEmployeeName(R.TESTDATA.get("employeeName"));
        employeeListPage.clickSearchBtn();
        Assert.assertTrue(employeeListPage.isSearchedEmployeePresent(R.TESTDATA.get("employeeName")), "Employee is not present in list");
    }
}
