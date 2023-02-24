package com.solvd.project.carina.demo.gui_components.abstractclass;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_components.classes.NotificationMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractOrangeHRMPage extends AbstractPage {

    @FindBy(css = ".oxd-text--toast-message")
    private NotificationMessage notificationMessage;

    public AbstractOrangeHRMPage(WebDriver driver) {
        super(driver);
    }

    public NotificationMessage getNotificationMessage() {
        return notificationMessage;
    }
}
