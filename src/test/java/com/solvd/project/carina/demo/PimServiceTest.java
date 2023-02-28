package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui.pages.pim.PersonalDetailsPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import com.solvd.project.carina.demo.gui_components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui_components.exceptions.UnknownOsException;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addEmployeeTest() throws UnknownOsException, NoPageExistInMenuException {
        authUtil.logInDefaultUser();
        AddEmployeePage addEmployeePage = (AddEmployeePage) navigationUtil.openPage(MenuOption.PIM_ADD_EMPLOYEE);
        Assert.assertTrue(addEmployeePage.isPageOpened(), "Add employee page is not opened");
        String firstName = randomUtil.getRandomString(4);
        String lastName = randomUtil.getRandomString(8);
        String id = randomUtil.getRandomNumber(4);
        addEmployeePage.typeFirstName(firstName);
        addEmployeePage.typeLastName(lastName);
        addEmployeePage.clearEmployeeIdTextField();
        addEmployeePage.typeEmployeeId(id);
        PersonalDetailsPage personalDetailsPage = addEmployeePage.clickSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessagePresent(), "Employee is not saved");
        Assert.assertTrue(personalDetailsPage.isPageOpened(), "Personal details page is not opened");
        EmployeeListPage employeeListPage = (EmployeeListPage) navigationUtil.openPage(MenuOption.PIM);
        Assert.assertTrue(employeeListPage.isPageOpened(), "Employee List page is not opened");
        Assert.assertTrue(employeeListPage.isEmployeeIdPresent(id), "Employee is not present in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void searchEmployeeTest() throws NoPageExistInMenuException, UnknownOsException {
        authUtil.logInDefaultUser();
        String employeeName = randomUtil.getRandomString(5);
        String employeeSurname = randomUtil.getRandomString(7);
        manageEmployeeUtil.addEmployee(employeeName, employeeSurname);
        EmployeeListPage employeeListPage = (EmployeeListPage) navigationUtil.openPage(MenuOption.PIM);
        employeeListPage.typeEmployeeFullName(employeeName + "  " + employeeSurname);
        employeeListPage.clickSearchBtn();
        Assert.assertTrue(employeeListPage.isSearchedEmployeePresent(employeeName), "Employee is not present in list");
    }
}
