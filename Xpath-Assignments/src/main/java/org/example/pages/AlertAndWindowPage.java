package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Dialog;

public class AlertAndWindowPage {

    private final Page page;
    public AlertAndWindowPage(Page page) {
        this.page = page;
    }

    //Locator button
    private String alertBtnXpath(String type) {
        return String.format("//button[text()='%s']", type);
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void handleAlert(String btnText) {
        page.click(alertBtnXpath(btnText));
    }

    public Page clickForNewWindow(String btnText) {
        return page.waitForPopup(() -> {
            page.locator(alertBtnXpath(btnText)).click();
        });
    }
}