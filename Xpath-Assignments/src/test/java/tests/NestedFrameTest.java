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

        //Check Text in ParentFrame
        String parentResult = nestedPage.getParentFrameProcessingText();
        System.out.println("Parent Text Result: " + parentResult);

        Assert.assertEquals(parentResult, "Hooray..! You clicked the button from iframe 1", "Text Verify is wrong!");

        //Check Text in ChildFrame
        String childResult = nestedPage.getChildFrameProcessingText();
        System.out.println("Child Text Result: " + childResult);

        Assert.assertEquals(childResult, "Hooray..! You clicked the button from iframe 2", "Text Verify is wrong!");}
}