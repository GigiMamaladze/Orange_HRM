package com.solvd.project.carina.demo.components.utils;


import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui.components.LeftBarMenu;
import com.solvd.project.carina.demo.gui.components.TopBarMenu;
import com.solvd.project.carina.demo.gui.pages.AbstractOrangeHRMPage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.organization.GeneralInformationPage;
import com.solvd.project.carina.demo.gui.pages.admin.usermenagement.UserManagementPage;
import com.solvd.project.carina.demo.gui.pages.myinfo.PersonalDetailsPage;
import com.solvd.project.carina.demo.gui.pages.pim.AddEmployeePage;
import com.solvd.project.carina.demo.gui.pages.pim.EmployeeListPage;
import com.solvd.project.carina.demo.gui.pages.pim.ReportsPage;
import com.solvd.project.carina.demo.gui.pages.recruitment.CandidatesPage;
import com.solvd.project.carina.demo.gui.pages.recruitment.VacanciesPage;

public class NavigationUtil extends AbstractTest {

    public AbstractOrangeHRMPage open(MenuOption menuOption) throws NoPageExistInMenuException {
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
            case PIM_REPORTS:
                leftBarMenu.clickMenuOption(MenuOption.PIM);
                topBarMenu.clickSection(MenuOption.PIM_REPORTS);
                return new ReportsPage(getDriver());
            case RECRUITMENT:
                leftBarMenu.clickMenuOption(MenuOption.RECRUITMENT);
                return new CandidatesPage(getDriver());
            case RECRUITMENT_VACANCIES:
                leftBarMenu.clickMenuOption(MenuOption.RECRUITMENT);
                topBarMenu.clickSection(MenuOption.RECRUITMENT_VACANCIES);
                return new VacanciesPage(getDriver());
            case MY_INFO:
                leftBarMenu.clickMenuOption(MenuOption.MY_INFO);
                return new PersonalDetailsPage(getDriver());
            default:
                throw new NoPageExistInMenuException("Menu is not exist");
        }
    }
}
