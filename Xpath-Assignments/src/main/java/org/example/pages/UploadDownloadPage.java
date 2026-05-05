package org.example.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import org.testng.Assert;

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
            throw new RuntimeException("ERROR: File does not exist " + absolutePath);
        }
        page.setInputFiles(uploadInput, Paths.get(absolutePath));
    }

    public String downloadFile(String buttonText) {
        String xpath = String.format(downloadButton, buttonText);

        Download download = page.waitForDownload(new Page.WaitForDownloadOptions().setTimeout(60000), () -> {
            page.click(xpath);
        });

        String downloadDir = System.getProperty("user.dir") + File.separator + "Downloads";
        String finalPath = downloadDir + File.separator + download.suggestedFilename();

        //Save file
        download.saveAs(Paths.get(finalPath));

        //Check file
        File file = new File(finalPath);
        if (!file.exists()) {
            throw new RuntimeException("FAILED: File could not be saved to " + finalPath);
        }

        return finalPath;
    }

    public String getUploadedFilePath() {
        return page.innerText("//p[@id='uploadedFilePath']");
    }
}