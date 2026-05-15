package org.example.pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class NestedFramePage {

        private final Page page;

        public NestedFramePage(Page page) {
            this.page = page;
        }

    private String parentFrameXpath() {
        return "//iframe[@id='parent_iframe']";
    }

    private String childFrameXpath() {
        return "//iframe[@id='iframe1']";
    }

    private String clickHereBtnXpath() {
        return "//button[normalize-space(.)='Click Here']";
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void clickInsideNestedFrame() {
        FrameLocator parentFrame = page.frameLocator(parentFrameXpath());
        FrameLocator childFrame = parentFrame.frameLocator(childFrameXpath());

        childFrame.locator(clickHereBtnXpath()).click();
        parentFrame.locator(clickHereBtnXpath()).click();
    }

    public String getChildFrameProcessingText() {
        return page.frameLocator(parentFrameXpath())
                .frameLocator(childFrameXpath())
                .locator("//p[@id='processing']")
                .innerText().trim();
    }

    public String getParentFrameProcessingText() {
        return page.frameLocator(parentFrameXpath())
                .locator("//p[@id='processing']")
                .innerText().trim();
    }

}