package org.example.pages;

import com.microsoft.playwright.Page;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkPage {
    private final Page page;

    private static final String brokenLinksArea = "//h4[text()='Broken Links']/following-sibling::a";

    public BrokenLinkPage(Page page) {
        this.page = page;
    }

    public List<String> getAllBrokenLinksUrl() {
        page.waitForSelector(brokenLinksArea);
        return (List<String>) page.locator(brokenLinksArea).evaluateAll("elements => elements.map(el => el.href)");
    }

    public boolean isLinkBroken(String linkUrl) {
        if (linkUrl == null || linkUrl.isEmpty() || linkUrl.startsWith("javascript")) {
            return false;
        }
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();

            //If response code >= 400 -> broken link
            return httpURLConnection.getResponseCode() >= 400;
        } catch (Exception e) {
            return true;
        }
    }
}