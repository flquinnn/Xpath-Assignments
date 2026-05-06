package org.example.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    private static final String usenameInput = "//label[text()='Username']/following-sibling::input";
    private static final String passwordInput = "//label[text()='Password']/following-sibling::input";
    private static final String loginButton = "//button[text()='Login']";

    private static final String alertMessage = "//div[@id='flash']";
    private static final String logoutButton = "//a[normalize-space(.)='Logout']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.fill(usenameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public boolean isAlertVisible(String message) {
        String xpath = String.format(alertMessage, message);
        return page.locator(xpath).isVisible();
    }

    public boolean isLogoutButtonVisible() {
        return page.locator(logoutButton).isVisible();
    }

    public String getCurrentUrl() {
        return page.url();
    }
}