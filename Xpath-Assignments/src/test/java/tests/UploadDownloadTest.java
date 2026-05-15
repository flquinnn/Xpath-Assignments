package tests;

import com.microsoft.playwright.Download;
import org.example.base.BaseTest;
import org.example.pages.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    private UploadDownloadPage upDownPage;

    @BeforeMethod
    public void setupTest() {
        upDownPage = new UploadDownloadPage(page);
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        upDownPage.navigateToUploadSection();
    }

    @Test
    public void TC01_HandleUploadFile() {
        String fileName = "test_upload.txt";
        String absoluteFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "resources/testdata" + File.separator + fileName;
        upDownPage.uploadFile(absoluteFilePath);

        //Check File Name
        String resultText = upDownPage.getUploadedFilePath();
        Assert.assertTrue(resultText.contains(fileName), "Upload fails!");

    }

    @Test
    public void TC02_HandleDownloadFile() {
        String downloadedPath = upDownPage.downloadFile("Download");
    }
}