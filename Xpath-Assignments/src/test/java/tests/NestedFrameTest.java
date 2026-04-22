package tests;

import org.example.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.NestedFramePage;

public class NestedFrameTest extends BaseTest {

    @Test
    public void TC01_HandleNestedFrames() {
        NestedFramePage nestedPage = new NestedFramePage(page);
        nestedPage.navigate("https://www.dezlearn.com/nested-iframes-example/");

        nestedPage.clickInsideNestedFrame();

        String resultText = nestedPage.getProcessingText();
        System.out.println("Text Result: " + resultText);

        Assert.assertTrue(resultText.contains("Clicked"), "Text verify is wrong!");
    }
}