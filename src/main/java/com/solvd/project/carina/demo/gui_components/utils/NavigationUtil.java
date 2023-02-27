package com.solvd.project.carina.demo.gui_components.utils;


import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.components.LeftBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.organization.GeneralInformationPage;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.UserManagementPage;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui_components.abstractclass.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui_components.enums.MenuOption;
import com.solvd.project.carina.demo.gui_components.exceptions.NoPageExistInMenuException;

public class NavigationUtil extends AbstractTest {

    public AbstractOrangeHRMPage openPage(MenuOption menuOption) throws NoPageExistInMenuException {
        LeftBarMenu leftBarMenu = new LeftBarMenu(getDriver());
        TopBarMenu topBarMenu = new TopBarMenu(getDriver());
        switch (menuOption) {
            case ADMIN:
                leftBarMenu.clickMenuOption(MenuOption.ADMIN);
                return new UserManagementPage(getDriver());
            case ADMIN_JOB_TITLE:
                leftBarMenu.clickMenuOption(MenuOption.ADMIN);
                topBarMenu.clickSection(MenuOption.ADMIN_JOB);
                topBarMenu.clickSubSection(MenuOption.ADMIN_JOB_TITLE);
                return new JobTitlePage(getDriver());
            case ADMIN_ORGANIZATION_GENERAL_INFORMATION:
                leftBarMenu.clickMenuOption(MenuOption.ADMIN);
                topBarMenu.clickSection(MenuOption.ADMIN_ORGANIZATION);
                topBarMenu.clickSubSection(MenuOption.ADMIN_ORGANIZATION_GENERAL_INFORMATION);
                return new GeneralInformationPage(getDriver());
            case PIM:
                leftBarMenu.clickMenuOption(MenuOption.PIM);
                return new EmployeeListPage(getDriver());
            case PIM_ADD_EMPLOYEE:
                leftBarMenu.clickMenuOption(MenuOption.PIM);
                topBarMenu.clickSection(MenuOption.PIM_ADD_EMPLOYEE);
                return new AddEmployeePage(getDriver());
            default:
                throw new NoPageExistInMenuException("Page is not exist");
        }
    }
}
