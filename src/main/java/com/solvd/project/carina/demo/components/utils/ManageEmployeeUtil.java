package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.components.exceptions.UnknownOsException;
import org.testng.Assert;

public class ManageEmployeeUtil extends AbstractTest {

    public void addEmployee(String firstName, String lastName) throws NoPageExistInMenuException, UnknownOsException {
        NavigationUtil navigationUtil = new NavigationUtil();
        RandomUtil randomUtil = new RandomUtil();
        AddEmployeePage addEmployeePage = (AddEmployeePage) navigationUtil.open(MenuOption.PIM_ADD_EMPLOYEE);
        Assert.assertTrue(addEmployeePage.isPageOpened(), "Add employee page is not opened");
        String id = randomUtil.getRandomNumber(4);
        addEmployeePage.typeFirstName(firstName);
        addEmployeePage.typeLastName(lastName);
        addEmployeePage.clearEmployeeIdTextField();
        addEmployeePage.typeEmployeeId(id);
        addEmployeePage.clickSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessagePresent(), "Successfully saved' message is bot shown");
    }
}