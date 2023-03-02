package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui.pages.recruitment.AddVacancyPage;
import com.solvd.project.carina.demo.gui.pages.recruitment.EditVacancyPage;
import com.solvd.project.carina.demo.gui.pages.recruitment.VacanciesPage;
import org.testng.Assert;

public class RecruitmentUtil extends AbstractTest {

    public void addVacancy(String vacancyName, String jobTitle, String hiringManagerFullName) throws NoPageExistInMenuException {
        NavigationUtil navigationUtil = new NavigationUtil();
        VacanciesPage vacanciesPage = (VacanciesPage) navigationUtil.open(MenuOption.RECRUITMENT_VACANCIES);
        Assert.assertTrue(vacanciesPage.isPageOpened(), "Vacancies Page is not opened");
        AddVacancyPage addVacancyPage = vacanciesPage.clickAddButton();
        Assert.assertTrue(addVacancyPage.isPageOpened(), "Add vacancy page is not opened");
        addVacancyPage.typeVacancyName(vacancyName);
        addVacancyPage.selectJobTitle(jobTitle);
        addVacancyPage.typeHiringManagerAndSelectEmployee(hiringManagerFullName);
        EditVacancyPage editVacancyPage = addVacancyPage.clickSaveButton();
        Assert.assertTrue(editVacancyPage.isPageOpened(), "Edit vacancy page is opened");
    }
}
