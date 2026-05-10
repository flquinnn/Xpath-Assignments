package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotDragDropPage {
    private final Page page;
    private int screenshotIndex = 1;

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

    public String createFileName() {
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = dtFormat.format(LocalDateTime.now());

        return String.format("%02d_%s.png", screenshotIndex++, timestamp);
    }

    public void takeFullPageScreenshot(){
        page.screenshot(new Page.ScreenshotOptions()
                .setFullPage(true)
                .setPath(Paths.get("Screenshots/" + createFileName())));
    }

    public void takeElementScreenshot(){
        page.locator(dropElement).screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("Screenshots/" + createFileName())));
    }

    public void takeScreenshot() {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("Screenshots/"  + createFileName())));
    }
}