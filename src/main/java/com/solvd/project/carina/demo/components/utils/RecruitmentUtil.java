package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.gui.pages.recruitment.*;
import org.testng.Assert;

public class RecruitmentUtil extends AbstractTest {

    public void addVacancy(String vacancyName, String jobTitle, String hiringManagerFullName) {
        VacanciesPage vacanciesPage = (VacanciesPage) new NavigationUtil().open(MenuOption.RECRUITMENT_VACANCIES);
        Assert.assertTrue(vacanciesPage.isPageOpened(), "Vacancies Page is not opened");
        AddVacancyPage addVacancyPage = vacanciesPage.clickAddButton();
        Assert.assertTrue(addVacancyPage.isPageOpened(), "Add vacancy page is not opened");
        addVacancyPage.typeVacancyName(vacancyName);
        addVacancyPage.selectJobTitle(jobTitle);
        addVacancyPage.typeHiringManagerAndSelectEmployee(hiringManagerFullName);
        EditVacancyPage editVacancyPage = addVacancyPage.clickSaveButton();
        Assert.assertTrue(editVacancyPage.isPageOpened(), "Edit vacancy page is opened");
    }

    public void addCandidate(String candidateFirstName, String candidateLastName, String vacancyName, String email) {
        CandidatesPage candidatesPage = (CandidatesPage) new NavigationUtil().open(MenuOption.RECRUITMENT);
        Assert.assertTrue(candidatesPage.isPageOpened(), "Candidates page is not opened");
        AddCandidatePage addCandidatePage = candidatesPage.clickAddButton();
        Assert.assertTrue(addCandidatePage.isPageOpened(), "Add candidate page is not opened");
        addCandidatePage.typeFirstName(candidateFirstName);
        addCandidatePage.typeLastName(candidateLastName);
        addCandidatePage.selectVacancy(vacancyName);
        addCandidatePage.typeEmail(email);
        CreatedCandidatePage createdCandidatePage = addCandidatePage.clickSaveBtn();
        Assert.assertTrue(addCandidatePage.isSuccessSaveMessagePresent(), "Save success message is not shown");
        Assert.assertTrue(createdCandidatePage.isPageOpened(), "Created candidate page is opened");
    }
}
