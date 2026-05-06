package tests;

import org.example.base.BaseTest;
import org.example.pages.KeyPressPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressTest extends BaseTest {
    private KeyPressPage keyPressPage;

    @BeforeMethod
    public void setupTest() {
        keyPressPage = new KeyPressPage(page);
        page.navigate("https://practice.expandtesting.com/key-presses");
    }

    @Test
    public void TC01_PressAlphabetKey() {
        keyPressPage.pressKey("A");
        Assert.assertEquals(keyPressPage.getResultText(), "You entered: A");
    }

    @Test
    public void TC02_PressNumberKey() {
        keyPressPage.pressKey("5");
        Assert.assertEquals(keyPressPage.getResultText(), "You entered: 5");
    }

    @Test
    public void TC03_PressSpecialKey() {
        keyPressPage.pressKey("Enter");
        Assert.assertEquals(keyPressPage.getResultText(), "You entered: ENTER");
    }

    @Test
    public void TC04_PressEscapeKey() {
        keyPressPage.pressKey("Escape");
        Assert.assertEquals(keyPressPage.getResultText(), "You entered: ESCAPE");
    }
}