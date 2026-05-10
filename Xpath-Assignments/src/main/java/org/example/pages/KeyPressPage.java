package org.example.pages;

import com.microsoft.playwright.Page;

public class KeyPressPage {
    private final Page page;

    private static final String keyInput = "//input[@id='target']";
    private static final String textResult = "//p[@id='result']";

    public KeyPressPage(Page page) {
        this.page = page;
    }

    public void pressKey(String key) {
        page.click(keyInput);
        page.keyboard().press(key);
    }

    public String getResultText() {
        return page.innerText(textResult);
    }
}