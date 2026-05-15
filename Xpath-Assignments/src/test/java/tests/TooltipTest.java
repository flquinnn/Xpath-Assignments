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
        page.navigate("https://practice.expandtesting.com/tooltips");
    }

    @Test
    public void TC01_VerifyTooltipOnTop() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("Tooltip on top");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on top", "tooltip text is wrong!");
    }

    @Test
    public void TC02_VerifyTooltipOnEnd() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("Tooltip on end");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on end", "tooltip text is wrong!");
    }

    @Test
    public void TC03_VerifyTooltipOnBottom() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("Tooltip on bottom");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on bottom", "tooltip text is wrong!");
    }

    @Test
    public void TC04_VerifyTooltipOnStart() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("Tooltip on start");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip on start", "tooltip text is wrong!");
    }

    @Test
    public void TC05_VerifyTooltipWithHTML() {
        TooltipPage tooltipPage = new TooltipPage(page);
        tooltipPage.hoverOnTooltipButton("Tooltip with HTML");
        String actualText = tooltipPage.getTooltipInnerText();
        Assert.assertEquals(actualText, "Tooltip with HTML", "tooltip text is wrong!");
    }
}