package tests;

import org.example.base.BaseTest;
import org.example.pages.TooltipPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TooltipTest extends BaseTest {

    @BeforeMethod
    public void setupTest() {
        TooltipPage tooltipPage = new TooltipPage(page);
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        tooltipPage.navigateToTooltipsCategory();
    }

    @Test
    public void TC01_VerifyTooltipOnTop() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("top");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on top", "Top tooltip text is wrong!");
    }

    @Test
    public void TC02_VerifyTooltipOnRight() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("right");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on right", "Right tooltip text is wrong!");
    }

    @Test
    public void TC03_VerifyTooltipOnBottom() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("bottom");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on bottom", "Bottom tooltip text is wrong!");
    }

    @Test
    public void TC04_VerifyTooltipOnLeft() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("left");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on left", "Left tooltip text is wrong!");
    }
}