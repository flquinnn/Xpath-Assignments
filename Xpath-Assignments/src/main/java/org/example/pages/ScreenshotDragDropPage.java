package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class ScreenshotDragDropPage {
    private final Page page;

    private static final String dragElement = "//div[@id='draggable']";
    private static final String dropElement = "//div[@id='droppable']";

    public ScreenshotDragDropPage(Page page) {
        this.page = page;
    }

    public void dragAndDropElement() {
        page.locator(dragElement).dragTo(page.locator(dropElement));
    }

    public String getDropSuccessMessage() {
        return page.locator(dropElement).innerText();
    }

    public void takeScreenshot(String fileName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("Screenshots/" + fileName + ".png")));
    }
}