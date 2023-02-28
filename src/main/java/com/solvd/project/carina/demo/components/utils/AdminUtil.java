package com.solvd.project.carina.demo.components.utils;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui.pages.admin.job.AddJobTitlePage;
import org.testng.Assert;

public class AdminUtil extends AbstractTest {

    public void addJobTitle(String jobTitle) {
        AddJobTitlePage addJobTitlePage = new AddJobTitlePage(getDriver());
        addJobTitlePage.typeJobTitle(jobTitle);
        addJobTitlePage.clickSaveBtn();
        Assert.assertTrue(addJobTitlePage.isSuccessSaveMessagePresent(), "Job is not created");
    }
}
