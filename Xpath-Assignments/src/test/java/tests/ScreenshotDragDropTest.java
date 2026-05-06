package tests;

import org.example.base.BaseTest;
import org.example.pages.ScreenshotDragDropPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;

public class ScreenshotDragDropTest extends BaseTest {
    private ScreenshotDragDropPage dragDropPage;

    @BeforeMethod
    public void setupTest() {
        dragDropPage = new ScreenshotDragDropPage(page);

        File folder = new File("Screenshots");
        if (!folder.exists()) {
            folder.mkdir();
        }

        page.navigate("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void TC01_VerifyDragDropWithScreenshots() {
        //Screenshot before Drag and Drop
        dragDropPage.takeScreenshot("01_Before_Drop");

        //Drag and Drop
        dragDropPage.dragAndDropElement();
        String successMsg = dragDropPage.getDropSuccessMessage();
        Assert.assertEquals(successMsg, "Dropped!", "Error: Drop isn't successful");

        //Screenshot after Drag and Drop
        dragDropPage.takeScreenshot("02_After_Drop_Success");
    }
}