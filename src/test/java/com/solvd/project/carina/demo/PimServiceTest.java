package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.enums.PersonalReportColumnTitle;
import com.solvd.project.carina.demo.components.enums.comboboxlist.FieldGroupListItem;
import com.solvd.project.carina.demo.gui.pages.pim.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PimServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addEmployeeTest() {
        authUtil.logInDefaultUser();
        AddEmployeePage addEmployeePage = (AddEmployeePage) navigationUtil.open(MenuOption.PIM_ADD_EMPLOYEE);
        Assert.assertTrue(addEmployeePage.isPageOpened(), "Add employee page is not opened");
        String firstName = randomUtil.getRandomString(4);
        String lastName = randomUtil.getRandomString(8);
        String id = randomUtil.getRandomNumber(4);
        addEmployeePage.typeFirstName(firstName);
        addEmployeePage.typeLastName(lastName);
        addEmployeePage.clearEmployeeIdTextField();
        addEmployeePage.typeEmployeeId(id);
        PersonalDetailsPage personalDetailsPage = addEmployeePage.clickSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessagePresent(), "Successfully saved message is not shown");
        Assert.assertTrue(personalDetailsPage.isPageOpened(), "Personal details page is not opened");
        EmployeeListPage employeeListPage = (EmployeeListPage) navigationUtil.open(MenuOption.PIM);
        Assert.assertTrue(employeeListPage.isPageOpened(), "Employee List page is not opened");
        Assert.assertTrue(employeeListPage.isEmployeeIdPresent(id), "Employee is not present in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void searchEmployeeTest() {
        authUtil.logInDefaultUser();
        String employeeName = randomUtil.getRandomString(5);
        String employeeSurname = randomUtil.getRandomString(7);
        manageEmployeeUtil.addEmployee(employeeName, employeeSurname);
        EmployeeListPage employeeListPage = (EmployeeListPage) navigationUtil.open(MenuOption.PIM);
        employeeListPage.typeEmployeeFullName(employeeName + "  " + employeeSurname);
        employeeListPage.clickSearchBtn();
        Assert.assertTrue(employeeListPage.isSearchedEmployeePresent(employeeName), "Employee is not present in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void addPersonalReportFlowTest() {
        authUtil.logInDefaultUser();
        ReportsPage reportsPage = (ReportsPage) navigationUtil.open(MenuOption.PIM_REPORTS);
        Assert.assertTrue(reportsPage.isPageOpened(), "Reports page is not opened");
        AddReportPage addReportPage = reportsPage.clickAddButton();
        Assert.assertTrue(addReportPage.isPageOpened(), "Add report page is not opened");
        String reportName = randomUtil.getRandomString(6);
        addReportPage.typeReportName(reportName);
        addReportPage.selectFieldGroup(FieldGroupListItem.REPORTS_FIELD_GROUP_PERSONAL);
        addReportPage.clickDisplayFieldPlusButton();
        PersonalReportFlow personalReportFlow = addReportPage.clickSaveBtn();
        Assert.assertTrue(addReportPage.isSuccessSaveMessagePresent(), "Successfully saved message is not shown");
        Assert.assertTrue(personalReportFlow.isReportTitlePresent(reportName), "Report title is not created");
        for (PersonalReportColumnTitle p : PersonalReportColumnTitle.values()) {
            if (p != null && p.getColumnTitle().equals(PersonalReportColumnTitle.MARITAL_STATUS.getColumnTitle())) {
                personalReportFlow.scrollToLastColumns();
            }
            Assert.assertTrue(personalReportFlow.isColumnTitlePresent(p), String.format("%s column is not present", p.getColumnTitle()));
        }
        navigationUtil.open(MenuOption.PIM_REPORTS);
        Assert.assertTrue(reportsPage.isReportPresentInList(reportName), "Report is not exist in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void searchReportTest() {
        authUtil.logInDefaultUser();
        String reportName = randomUtil.getRandomString(5);
        manageEmployeeUtil.addPersonalReportFlow(reportName);
        ReportsPage reportsPage = (ReportsPage) navigationUtil.open(MenuOption.PIM_REPORTS);
        reportsPage.typeReportName(reportName);
        reportsPage.clickSuggestedReportNameItem(reportName);
        reportsPage.clickSearchButton();
        Assert.assertTrue(reportsPage.isReportPresentInList(reportName), "Report is not exist in list");
    }
}
