package com.solvd.project.carina.demo.gui_components.abstractclass;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.project.carina.demo.gui_components.utils.AutoServiceUtil;
import com.solvd.project.carina.demo.gui_components.utils.RandomServiceUtil;

public abstract class AbstractOrangeHRMTest extends AbstractTest {

    public AutoServiceUtil autoServiceUtil = new AutoServiceUtil();

    public RandomServiceUtil randomServiceUtil = new RandomServiceUtil();
}
