package tests;

import org.example.base.BaseTest;
import org.example.pages.ColorPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ColorTest extends BaseTest {

    private ColorPage colorPage;

    @BeforeMethod
    public void setupTest() {
        colorPage = new ColorPage(page);
        page.navigate("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void TC08_GetColorAndHover() {
        String finalButton = "START";

        String colorBefore = colorPage.getButtonColor(finalButton);
        System.out.println("Color before hovering: " + colorBefore);

        colorPage.hoverButton(finalButton);
        page.waitForTimeout(1000);

        //After hover
        String colorAfter = colorPage.getButtonColor(finalButton);
        System.out.println("Color after hovering: " + colorAfter);
    }
}