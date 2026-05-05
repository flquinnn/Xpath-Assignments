package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;

public class DropdownPage {
    private final Page page;
    public DropdownPage(Page page) {
        this.page=page;
    }

    private static final String selectOptionXpath = "//div[@role='listbox']//div[normalize-space(.)='%s']";

    public void navigateToSelectMenu() {
        page.click("//h2[normalize-space(.)='Widgets']");
        page.click("//a[normalize-space(.)='Select Menu']");
    }

    public void selectMultipleOptions(String labelName, List<String> options) {
        String inputXpath = String.format("//h6[normalize-space(.)='%s']/following-sibling::div//label", labelName);
        Locator inputLocator = page.locator(inputXpath);

        //Open
        inputLocator.scrollIntoViewIfNeeded();
        inputLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        inputLocator.click();

        for (String option : options) {
            String optionXpath = String.format("//div[@role='listbox']/descendant::div[normalize-space(.)='%s']", option);
            page.locator(optionXpath).click();
        }

        //Close
        page.keyboard().press("Escape");
    }

    public void selectSingleOption(String labelName, String optionLabel) {
        String xpath = String.format("//h6[normalize-space(.)='%s']/following-sibling::div/select", labelName);

        page.selectOption(xpath, new SelectOption().setLabel(optionLabel));
    }

    public String getSelectSingleResult(String labelName) {
        String xpath = String.format("//h6[normalize-space(.)='%s']/following-sibling::div/descendant::select", labelName);
        return page.locator(xpath).inputValue();
    }
}