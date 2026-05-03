package org.example.pages;

import com.microsoft.playwright.Page;

public class TooltipPage {

    private final Page page;
    public TooltipPage(Page page) {
        this.page=page;
    }

    public void navigateToTooltipsCategory() {
        page.click("//h2[normalize-space(.)='Widgets']");
        page.click("//a[normalize-space(.)='Tool Tips']");
    }

    public void hoverOnTooltipButton(String placement) {
        page.hover("//button[@data-bs-placement='" + placement + "']");
    }

    public String getTooltipInnerText() {
        return page.locator("//div[@class='tooltip-inner']").innerText().trim();
    }
}