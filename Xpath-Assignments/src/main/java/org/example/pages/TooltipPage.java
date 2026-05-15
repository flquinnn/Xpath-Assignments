package org.example.pages;

import com.microsoft.playwright.Page;

public class TooltipPage {

    private final Page page;
    public TooltipPage(Page page) {
        this.page=page;
    }

    private static final String tooltipBtn = "//button[normalize-space(text())='%s']";

    public void hoverOnTooltipButton(String buttonText) {
        page.hover(String.format(tooltipBtn, buttonText));
    }

    public String getTooltipInnerText() {
        return page.locator("//div[@class='tooltip-inner']").innerText().trim();
    }
}