package org.example.pages;

import com.microsoft.playwright.Page;

public class BasicAuthPage {
    private final Page page;

    private static final String successMessage = "//p[@class='alert alert-success']/b";

    public BasicAuthPage(Page page) {
        this.page = page;
    }

    public boolean isSuccessMessageVisible(String partialMessage) {
        String xpath = String.format(successMessage, partialMessage);
        return page.locator(xpath).isVisible();
    }
}