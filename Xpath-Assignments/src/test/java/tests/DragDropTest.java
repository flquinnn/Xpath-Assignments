package tests;

import org.example.base.BaseTest;
import org.example.pages.DragDropPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {
    private DragDropPage dragDropPage;

    @BeforeMethod
    public void setupTest() {
        dragDropPage = new DragDropPage(page);
        page.navigate("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void TC10_VerifyDragAndDrop() {
        dragDropPage.dragAndDropElement();

        String successMsg = dragDropPage.getDropSuccessMessage();

        System.out.println("The success message: " + successMsg);
        Assert.assertEquals(successMsg, "Dropped!", "Error: Drop isn't successful!");
    }
}