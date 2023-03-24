package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.enums.selectboxlist.FieldGroupListItem;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.AddReportPage;
import com.solvd.project.carina.demo.gui.pages.pim.PersonalDetailsPage;
import com.solvd.project.carina.demo.gui.pages.pim.ReportsPage;
import org.testng.Assert;

public class ManageEmployeeUtil extends AbstractTest {

    public void addEmployee(String firstName, String lastName) {
        AddEmployeePage addEmployeePage = (AddEmployeePage) new NavigationUtil().open(MenuOption.PIM_ADD_EMPLOYEE);
        Assert.assertTrue(addEmployeePage.isPageOpened(), "Add employee page is not opened");
        String id = new RandomUtil().getRandomNumber(4);
        addEmployeePage.typeFirstName(firstName);
        addEmployeePage.typeLastName(lastName);
        addEmployeePage.clearEmployeeIdTextField();
        addEmployeePage.typeEmployeeId(id);
        PersonalDetailsPage personalDetailsPage = addEmployeePage.clickSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessagePresent(), "Successfully saved' message is bot shown");
        Assert.assertTrue(personalDetailsPage.isPageOpened(), "Personal details page is not opened");
    }

    public void addPersonalReportFlow(String reportName) {
        ReportsPage reportsPage = (ReportsPage) new NavigationUtil().open(MenuOption.PIM_REPORTS);
        Assert.assertTrue(reportsPage.isPageOpened(), "Reports page is not opened");
        AddReportPage addReportPage = reportsPage.clickAddButton();
        Assert.assertTrue(addReportPage.isPageOpened(), "Add report page is not opened");
        addReportPage.typeReportName(reportName);
        addReportPage.selectFieldGroup(FieldGroupListItem.REPORTS_FIELD_GROUP_PERSONAL);
        addReportPage.clickDisplayFieldPlusButton();
        addReportPage.clickSaveBtn();
    }
}
