package tests;

import com.microsoft.playwright.Page;
import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.AlertAndWindowPage;

public class AlertAndWindowTest extends BaseTest {

    @Test
    public void TC01_HandleAlerts() {
        AlertAndWindowPage alertPage = new AlertAndWindowPage(page);
        alertPage.navigate("https://testautomationpractice.blogspot.com/");

        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "I am an alert box!");
            dialog.accept();
        });
        alertPage.handleAlert("Simple Text");

        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "Press a button!");
            dialog.dismiss();
        });
        alertPage.handleAlert("Confirmation Alert");

        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "Please enter your name:");
            dialog.accept("Harry");
        });
        alertPage.handleAlert("Prompt Alert");
    }

    @Test
    public void TC02_HandleNewWindows() {
        AlertAndWindowPage alertPage = new AlertAndWindowPage(page);
        alertPage.navigate("https://testautomationpractice.blogspot.com/");

        //Click New Tab and check
        Page newTab = alertPage.clickForNewWindow("New Tab");
        newTab.waitForLoadState();

        Assert.assertFalse(newTab.title().isEmpty());
        newTab.close();

        //Click Popup Window
        Page popup = alertPage.clickForNewWindow("Popup Windows");
        popup.waitForLoadState();
        Assert.assertNotNull(popup);
        popup.close();
    }
}