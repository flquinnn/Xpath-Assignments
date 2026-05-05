package org.example.pages;

import com.microsoft.playwright.Page;

public class ColorPage {
    private final Page page;

    private static final String buttonXpath = "//button[normalize-space(.)='%s']";

    public ColorPage(Page page) {
        this.page = page;
    }

    private String getButtonXPath(String buttonName) {
        return String.format(buttonXpath, buttonName);
    }

    public String getButtonColor(String buttonName) {
        String xpath = getButtonXPath(buttonName);
        return (String) page.locator(xpath).evaluate(
                "el => window.getComputedStyle(el).backgroundColor"
        );
    }

    public void hoverButton(String buttonName) {
        String xpath = getButtonXPath(buttonName);
        page.hover(xpath);
    }
}