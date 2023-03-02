package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.components.utils.*;

public abstract class AbstractOrangeHRMTest extends AbstractTest {

    public AuthUtil authUtil = new AuthUtil();

    public RandomUtil randomUtil = new RandomUtil();

    public AdminUtil adminUtil = new AdminUtil();

    public NavigationUtil navigationUtil = new NavigationUtil();

    public ManageEmployeeUtil manageEmployeeUtil = new ManageEmployeeUtil();

    public RecruitmentUtil recruitmentUtil = new RecruitmentUtil();
}
