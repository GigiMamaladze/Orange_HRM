package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.gui.pages.recruitment.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void addVacancyTest() {
        authUtil.logInDefaultUser();
        String employeeName = randomUtil.getRandomString(5);
        String employeeLastName = randomUtil.getRandomString(8);
        manageEmployeeUtil.addEmployee(employeeName, employeeLastName);
        String jobTitle = randomUtil.getRandomString(5);
        adminUtil.addJobTitle(jobTitle);
        VacanciesPage vacanciesPage = (VacanciesPage) navigationUtil.open(MenuOption.RECRUITMENT_VACANCIES);
        Assert.assertTrue(vacanciesPage.isPageOpened(), "Vacancies Page is not opened");
        AddVacancyPage addVacancyPage = vacanciesPage.clickAddButton();
        Assert.assertTrue(addVacancyPage.isPageOpened(), "Add vacancy page is not opened");
        String vacancyName = randomUtil.getRandomString(7);
        addVacancyPage.typeVacancyName(vacancyName);
        addVacancyPage.selectJobTitle(jobTitle);
        addVacancyPage.typeHiringManagerAndSelectEmployee(employeeName + "  " + employeeLastName);
        EditVacancyPage editVacancyPage = addVacancyPage.clickSaveButton();
        Assert.assertTrue(editVacancyPage.isPageOpened(), "Edit vacancy page is opened");
        navigationUtil.open(MenuOption.RECRUITMENT_VACANCIES);
        Assert.assertTrue(vacanciesPage.isVacancyPresentInList(vacancyName), "Vacancy is not exist in list");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void addCandidateTest() {
        authUtil.logInDefaultUser();
        String employeeFirstName = randomUtil.getRandomString(5);
        String employeeLastName = randomUtil.getRandomString(8);
        manageEmployeeUtil.addEmployee(employeeFirstName, employeeLastName);
        String jobTitle = randomUtil.getRandomString(5);
        adminUtil.addJobTitle(jobTitle);
        String vacancyName = randomUtil.getRandomString(4);
        recruitmentUtil.addVacancy(vacancyName, jobTitle, employeeFirstName + "  " + employeeLastName);
        CandidatesPage candidatesPage = (CandidatesPage) navigationUtil.open(MenuOption.RECRUITMENT);
        Assert.assertTrue(candidatesPage.isPageOpened(), "Candidates page is not opened");
        AddCandidatePage addCandidatePage = candidatesPage.clickAddButton();
        Assert.assertTrue(addCandidatePage.isPageOpened(), "Add candidate page is not opened");
        String candidateFirstName = randomUtil.getRandomString(4);
        String candidateLastName = randomUtil.getRandomString(4);
        addCandidatePage.typeFirstName(candidateFirstName);
        addCandidatePage.typeLastName(candidateLastName);
        addCandidatePage.selectVacancy(vacancyName);
        addCandidatePage.typeEmail(randomUtil.getRandomString(5) + "@" + randomUtil.getRandomString(3)
                + "." + randomUtil.getRandomString(3));
        CreatedCandidatePage createdCandidatePage = addCandidatePage.clickSaveBtn();
        Assert.assertTrue(addCandidatePage.isSuccessSaveMessagePresent(), "Save success message is not shown");
        Assert.assertTrue(createdCandidatePage.isPageOpened(), "Created candidate page is opened");
        navigationUtil.open(MenuOption.RECRUITMENT);
        Assert.assertTrue(candidatesPage.isCandidatePresentInList(candidateFirstName + "  " + candidateLastName), "Candidate is not exist in list");
    }
}
