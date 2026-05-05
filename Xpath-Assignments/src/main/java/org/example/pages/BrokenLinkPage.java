package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkPage {
    private final Page page;

    private static final String brokenLinksArea = "//h4[text()='Broken Links']/following-sibling::a";

    public BrokenLinkPage(Page page) {
        this.page = page;
    }

    public List<String> getAllBrokenLinksUrl() {
        List<String> urls = new ArrayList<>();
        List<Locator> links = page.locator(brokenLinksArea).all();
        for (Locator link : links) {
            urls.add(link.getAttribute("href"));
        }
        return urls;
    }

    public boolean isLinkBroken(String linkUrl) {
        try{
            int responeCode = page.request().head(linkUrl).status();
            return responeCode >=400;
        } catch (Exception e) {
            return true;
        }
    }
}