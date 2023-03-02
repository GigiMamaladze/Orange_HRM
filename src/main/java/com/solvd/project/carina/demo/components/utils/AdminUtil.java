package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.exceptions.NoPageExistInMenuException;
import com.solvd.project.carina.demo.gui.pages.admin.job.AddJobTitlePage;
import com.solvd.project.carina.demo.gui.pages.admin.job.JobTitlePage;
import org.testng.Assert;

public class AdminUtil extends AbstractTest {

    public void addJobTitle(String jobTitle) throws NoPageExistInMenuException {
        NavigationUtil navigationUtil = new NavigationUtil();
        JobTitlePage jobTitlePage = (JobTitlePage) navigationUtil.open(MenuOption.ADMIN_JOB_TITLE);
        AddJobTitlePage addJobTitlePage = jobTitlePage.clickAddBtn();
        addJobTitlePage.typeJobTitle(jobTitle);
        addJobTitlePage.clickSaveBtn();
        Assert.assertTrue(addJobTitlePage.isSuccessSaveMessagePresent(), "Job is not created");
    }
}
