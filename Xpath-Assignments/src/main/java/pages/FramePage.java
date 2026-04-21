package pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class FramePage {

    private final Page page;

    public FramePage(Page page) {
        this.page = page;
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    // Locator for Iframe
    private String iframeXpath(String frameName) {
        return String.format("//h2[text()='%s']/following-sibling::iframe[1]", frameName);
    }

    private String seleniumLinkXpath() {
        return "//a[normalize-space(.)='Selenium Tutorial']";
    }

    //Scenario: Click link and verify new tab
    public Page clickLinkInFrame(String frameName) {
        FrameLocator frame = page.frameLocator(iframeXpath(frameName));

        //Open new Tab by waitForPopup
        return page.waitForPopup(() -> {
            frame.locator(seleniumLinkXpath()).click();
        });
    }
}