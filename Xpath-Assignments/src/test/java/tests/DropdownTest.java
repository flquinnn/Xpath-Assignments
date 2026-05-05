package tests;

import org.example.base.BaseTest;
import org.example.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setupTest() {
        dropdownPage = new DropdownPage(page);
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        dropdownPage.navigateToSelectMenu();
    }

    @Test
    public void TC01_HandleMultiselectDropdown() {
        List<String> options = Arrays.asList("Books", "Movies, Music & Games");
        dropdownPage.selectMultipleOptions("Multiselect drop down", options);
    }

    @Test
    public void TC02_HandleSelectSingleDropdown() {
        dropdownPage.selectSingleOption("Select One", "Proof.");
    }
}