package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui_components.utils.AdminUtil;
import com.solvd.project.carina.demo.gui_components.utils.AuthUtil;
import com.solvd.project.carina.demo.gui_components.utils.NavigationUtil;
import com.solvd.project.carina.demo.gui_components.utils.RandomUtil;

public abstract class AbstractOrangeHRMTest extends AbstractTest {

    public AuthUtil authUtil = new AuthUtil();

    public RandomUtil randomUtil = new RandomUtil();

    public AdminUtil adminUtil = new AdminUtil();

    public NavigationUtil navigationUtil = new NavigationUtil();
}
