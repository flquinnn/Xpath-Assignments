package tests;

import org.example.base.BaseTest;
import org.example.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    @Test
    public void TC01_BasicAuthSuccess() {
        String user = "admin";
        String pass = "admin";

        String authUrl = String.format("https://%s:%s@practice.expandtesting.com/basic-auth", user, pass);

        page.navigate(authUrl);
        BasicAuthPage authPage = new BasicAuthPage(page);

        boolean isVisible = authPage.isSuccessMessageVisible("Congratulations! You must have the proper credentials.");
        Assert.assertTrue(isVisible, "Success message isn't displayed after login!");
    }
}