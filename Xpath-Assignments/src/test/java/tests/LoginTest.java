package tests;

import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private final String loginUrl = "https://practice.expandtesting.com/login";

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(page);
        page.navigate(loginUrl);
    }

    @Test
    public void TC01_SuccessfulLogin() {
        loginPage.login("practice", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.getCurrentUrl().contains("/secure"), "Not redirected to secure page!");
        Assert.assertTrue(loginPage.isAlertVisible("You logged into a secure area!"), "Success message isn't visible!");
        Assert.assertTrue(loginPage.isLogoutButtonVisible(), "Logout button isn't displayed!");
    }

    @Test
    public void TC02_InvalidUsername() {
        loginPage.login("wrongUser", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.isAlertVisible("Your username is invalid!"), "Error message for invalid username isn't displayed!");
        Assert.assertEquals(loginPage.getCurrentUrl(), loginUrl, "Remain on the login page");
    }

    @Test
    public void TC03_InvalidPassword() {
        loginPage.login("practice", "WrongPassword");

        Assert.assertTrue(loginPage.isAlertVisible("Your password is invalid!"), "Error message for invalid password isn't displayed!");
        Assert.assertEquals(loginPage.getCurrentUrl(), loginUrl, "Remain on the login page");
    }

    @Test
    public void TC04_LoginWithoutUsernamePassword() {
        loginPage.login("", "");

        Assert.assertTrue(loginPage.isAlertVisible("Your username is invalid!"),
                "Error message for empty username and password isn't displayed!");

        Assert.assertEquals(loginPage.getCurrentUrl(), loginUrl, "Remain on the login page");
    }

    @Test
    public void TC05_LoginWithUsernameOnly(){
        loginPage.login("practice", "");

        Assert.assertTrue(loginPage.isAlertVisible("Your password is invalid!"),
                "Error message for empty password isn't displayed!");

        Assert.assertEquals(loginPage.getCurrentUrl(), loginUrl, "Remain on the login page");
    }

    @Test
    public void TC06_LoginWithPasswordOnly(){
        loginPage.login("", "SuperSecretPassword!");

        Assert.assertTrue(loginPage.isAlertVisible("Your username is invalid!"),
                "Error message for empty username isn't displayed!");

        Assert.assertEquals(loginPage.getCurrentUrl(), loginUrl, "Remain on the login page");
    }
}