package com.solvd.project.carina.demo;

import com.solvd.project.carina.demo.components.enums.MenuOption;
import com.solvd.project.carina.demo.components.enums.selectboxlist.Location;
import com.solvd.project.carina.demo.gui.pages.directory.DirectoryPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DirectoryServiceTest extends AbstractOrangeHRMTest {

    @Test
    @MethodOwner(owner = "Gigi")
    public void directorySearchTest() {
        authUtil.logInDefaultUser();
        DirectoryPage directoryPage = (DirectoryPage) navigationUtil.open(MenuOption.DIRECTORY);
        Assert.assertTrue(directoryPage.isPageOpened(), "Directory Page is not opened");
        Location location = Location.HQ_CA_USA;
        directoryPage.selectLocation(location);
        Assert.assertTrue(directoryPage.isEmployeePresentInLocation(location), "Any employee is not found in this location");
    }
}
