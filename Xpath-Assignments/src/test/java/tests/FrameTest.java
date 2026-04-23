package tests;

import com.microsoft.playwright.Page;
import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramePage;

public class FrameTest extends BaseTest {


    @Test
    public void Scenario1_VerifyIframe1() {
        FramePage framePage = new FramePage(page);
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        framePage.navigateToFramesCategory();

        // Click link in Iframe 1 and verify new tab
        Page newTab = framePage.clickLinkInFrame("Iframe 1");
        newTab.waitForLoadState();

        Assert.assertEquals(newTab.url(),"https://www.tutorialspoint.com/selenium/index.htm", "URL is wrong!");

        newTab.close();
    }

    @Test
    public void Scenario2_VerifyIframe2() {
        FramePage framePage = new FramePage(page);
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        framePage.navigateToFramesCategory();

        // Click link in Iframe 2
        Page newTab = framePage.clickLinkInFrame("Iframe 2");
        newTab.waitForLoadState();

        Assert.assertEquals(newTab.url(),"https://www.tutorialspoint.com/selenium/index.htm", "URL is wrong!");
        newTab.close();
    }
}