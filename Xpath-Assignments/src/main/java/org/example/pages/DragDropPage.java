package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DragDropPage {
    private final Page page;

    private static final String dragElement = "//div[@id='draggable']";
    private static final String dropElement = "//div[@id='droppable']";

    public DragDropPage(Page page) {
        this.page = page;
    }

    public void dragAndDropElement() {
        page.locator(dragElement).dragTo(page.locator(dropElement));
    }

    public String getDropSuccessMessage() {
        return page.locator(dropElement).innerText();
    }
}