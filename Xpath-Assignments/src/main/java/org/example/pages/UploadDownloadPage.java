package org.example.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadPage {
    private final Page page;

    private static final String downloadButton = "//a[normalize-space()='Download']";
    private static final String uploadInput = "//input[@id='uploadFile']";

    public UploadDownloadPage(Page page) {
        this.page = page;
    }

    public void navigateToUploadSection() {
        page.click("//h2[normalize-space(.)='Elements']");
        page.click("//a[normalize-space(.)='Upload and Download']");
    }

    public void uploadFile(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            System.err.println("ERROR: File does not exist " + absolutePath);
            return;
        }
        page.setInputFiles(uploadInput, Paths.get(absolutePath));
    }

    public Download downloadFile(String buttonText) {
        String xpath = String.format(downloadButton, buttonText);

        return page.waitForDownload(new Page.WaitForDownloadOptions().setTimeout(60000), () -> {
            page.click(xpath);
        });
    }

    public String getUploadedFilePath() {
        return page.innerText("//p[@id='uploadedFilePath']");
    }
}