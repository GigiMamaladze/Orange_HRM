package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.gui.pages.maintenance.AccessRecordsPage;
import com.solvd.project.carina.demo.gui.pages.maintenance.AdministratorAccessPage;
import com.solvd.project.carina.demo.gui.pages.maintenance.CandidateRecordsPurgePage;
import com.solvd.project.carina.demo.gui.pages.maintenance.MaintenancePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class MaintenanceServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void maintenancePageTest() {
        authUtil.logInDefaultUser();
        AdministratorAccessPage administratorAccessPage = (AdministratorAccessPage) navigationUtil.open(MenuOption.MAINTENANCE);
        Assert.assertTrue(administratorAccessPage.isPageOpened(), "Administration access page is not opened");
        administratorAccessPage.typePassword(R.TESTDATA.get("password"));
        MaintenancePage maintenancePage = administratorAccessPage.clickConfirmButton();
        Assert.assertTrue(maintenancePage.isPageOpened(), "Maintenance Page is not opened");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void candidateRecordsPurgeTest() {
        authUtil.logInDefaultUser();
        String employeeFirstName = randomUtil.getRandomString(5);
        String employeeLastName = randomUtil.getRandomString(8);
        manageEmployeeUtil.addEmployee(employeeFirstName, employeeLastName);
        String jobTitle = randomUtil.getRandomString(5);
        adminUtil.addJobTitle(jobTitle);
        String vacancyName = randomUtil.getRandomString(4);
        recruitmentUtil.addVacancy(vacancyName, jobTitle, employeeFirstName + "  " + employeeLastName);
        String candidateFirstName = randomUtil.getRandomString(4);
        String candidateLastName = randomUtil.getRandomString(4);
        String email = randomUtil.getRandomString(5) + "@" + randomUtil.getRandomString(3)
                + "." + randomUtil.getRandomString(3);
        recruitmentUtil.addCandidate(candidateFirstName, candidateLastName, vacancyName, email);
        MaintenancePage maintenancePage = adminUtil.openMaintenancePage();
        Assert.assertTrue(maintenancePage.isPageOpened(), "Maintenance page is not opened");
        CandidateRecordsPurgePage candidateRecordsPurgePage = (CandidateRecordsPurgePage) navigationUtil
                .open(MenuOption.MAINTENANCE_PURGE_RECORDS_CANDIDATE_RECORDS);
        Assert.assertTrue(candidateRecordsPurgePage.isPageOpened(), "Candidate Records purge page is not opened");
        candidateRecordsPurgePage.typeVacancy(vacancyName);
        candidateRecordsPurgePage.selectSuggestedVacancy(vacancyName);
        candidateRecordsPurgePage.clickSearchButton();
        Assert.assertTrue(candidateRecordsPurgePage.isCandidatePresent(candidateFirstName + " " + candidateLastName),
                "Candidate is not present in list");
        candidateRecordsPurgePage.clickPurgeAllButton();
        Assert.assertTrue(candidateRecordsPurgePage.getPurgeCandidatesConfirmationAlert().isConfirmationAlertPresent(),
                "Confirmation alert is not present");
        candidateRecordsPurgePage.getPurgeCandidatesConfirmationAlert().clickYesPurgeButton();
        candidateRecordsPurgePage.clickSearchButton();
        Assert.assertTrue(candidateRecordsPurgePage.isNoRecordsFoundMessagePresent(),
                "No Records Found massage is not present");
        Assert.assertFalse(candidateRecordsPurgePage.isCandidatePresent(candidateFirstName + " " + candidateLastName),
                "The candidate is in the list, the purge did not work");
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void accessRecordsDownloadingTest() throws InterruptedException {
        authUtil.logInDefaultUser();
        String employeeFirstName = randomUtil.getRandomString(5);
        String employeeLastName = randomUtil.getRandomString(8);
        manageEmployeeUtil.addEmployee(employeeFirstName, employeeLastName);
        MaintenancePage maintenancePage = adminUtil.openMaintenancePage();
        Assert.assertTrue(maintenancePage.isPageOpened(), "Maintenance page is not opened");
        AccessRecordsPage accessRecordsPage = (AccessRecordsPage) navigationUtil.open(MenuOption.MAINTENANCE_ACCESS_RECORDS);
        Assert.assertTrue(accessRecordsPage.isPageOpened(), "Access Records page is not opened");
        accessRecordsPage.typeEmployeeFullName(employeeFirstName + " " + employeeLastName);
        accessRecordsPage.selectSuggestedEmployee(employeeFirstName + "  " + employeeLastName);
        accessRecordsPage.clickSearchButton();
        String downloadDirectory = "/Users/gigimamaladze/Downloads";
        accessRecordsPage.clickDownloadButton();
        String filename = employeeFirstName + "  " + employeeLastName + ".json";
        File downloadedFile = new File(downloadDirectory + "/" + filename);
        Assert.assertTrue(downloadedFile.exists(), "File is not downloaded");
    }
}
