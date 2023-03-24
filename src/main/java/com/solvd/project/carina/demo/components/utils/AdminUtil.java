package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.gui.pages.admin.job.AddJobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import com.solvd.project.carina.demo.gui.pages.maintenance.AdministratorAccessPage;
import com.solvd.project.carina.demo.gui.pages.maintenance.MaintenancePage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;

public class AdminUtil extends AbstractTest {

    public void addJobTitle(String jobTitle) {
        JobTitlePage jobTitlePage = (JobTitlePage) new NavigationUtil().open(MenuOption.ADMIN_JOB_TITLE);
        AddJobTitlePage addJobTitlePage = jobTitlePage.clickAddBtn();
        addJobTitlePage.typeJobTitle(jobTitle);
        addJobTitlePage.clickSaveBtn();
        Assert.assertTrue(addJobTitlePage.isSuccessSaveMessagePresent(), "Job is not created");
    }

    public MaintenancePage openMaintenancePage() {
        NavigationUtil navigationUtil = new NavigationUtil();
        AdministratorAccessPage administratorAccessPage = (AdministratorAccessPage) navigationUtil.open(MenuOption.MAINTENANCE);
        Assert.assertTrue(administratorAccessPage.isPageOpened(), "Administration access page is not opened");
        administratorAccessPage.typePassword(R.TESTDATA.get("password"));
        return administratorAccessPage.clickConfirmButton();
    }
}
