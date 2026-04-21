package org.example.pages.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    //Actions
    protected void click(String xpath) {
        page.locator(xpath).click();
    }

    protected void fill(String xpath, String value) {
        page.locator(xpath).fill(value);
    }

    protected void selectOption(String xpath, String value) {
        page.locator(xpath).selectOption(value);
    }

    //Upload File function
    public void uploadFile(String selector, String relativePath) {
        Path filePath = Paths.get(relativePath);
        if (!Files.exists(filePath)) {
            throw new RuntimeException("CRITICAL: File doesn't exist: " + filePath.toAbsolutePath());
        }
        page.setInputFiles(selector, filePath);
    }
}
