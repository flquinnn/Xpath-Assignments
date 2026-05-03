package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropdownPage {
    private final Page page;
    public DropdownPage(Page page) {
        this.page=page;
    }

    public void navigateToSelectMenu() {
        page.click("//h2[normalize-space(.)='Widgets']");
        page.click("//a[normalize-space(.)='Select Menu']");
    }

    public void selectMultipleOptions(String labelName, List<String> options) {
        String inputXpath = String.format("//h6[normalize-space(.)='%s']/following-sibling::div//input", labelName);

        //Open
        page.locator(inputXpath).click(new com.microsoft.playwright.Locator.ClickOptions().setForce(true));

        for (String option : options) {
            page.click("//div[@role='listbox']/descendant::div[normalize-space(.)='" + option + "']");
        }

        //Close
        page.locator(inputXpath).click(new com.microsoft.playwright.Locator.ClickOptions().setForce(true));
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