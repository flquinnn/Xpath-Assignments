package tests;

import org.example.base.BaseTest;
import org.example.pages.BrokenLinkPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class BrokenLinkTest extends BaseTest {
    private BrokenLinkPage brokenLinkPage;

    @BeforeMethod
    public void setupTest() {
        brokenLinkPage = new BrokenLinkPage(page);
        page.navigate("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void TC09_VerifyBrokenLinks() {
        List<String> urls = brokenLinkPage.getAllBrokenLinksUrl();

        for (String link : urls) {
            if (brokenLinkPage.isLinkBroken(link)) {
                System.out.println("BROKEN LINK: " + link);
            }
        }
    }
}