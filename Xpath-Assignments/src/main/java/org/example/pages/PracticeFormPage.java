package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class PracticeFormPage {
    private final Page page;

    public PracticeFormPage(Page page) {
        this.page = page;
    }

    private String getFieldContainer(String label) {
        return String.format("//label[text()='%s']/following-sibling::div", label);
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    //Type field to fill data
    public void fillStudentRegistrationForm(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String label = entry.getKey();
            String value = entry.getValue();

            Locator container = page.locator(getFieldContainer(label));

            //Dropdown
            if (container.locator("select").count() > 0) {
                container.locator("select").selectOption(value);
            }
            //TextArea
            else if (container.locator("textarea").count() > 0) {
                container.locator("textarea").fill(value);
            }
            //Radio or Checkbox
            else if (container.locator(String.format("//label[text()='%s']", value)).count() > 0) {
                container.locator(String.format("//label[text()='%s']", value)).click();
            }
            //Input Text
            else if (container.locator("input").count() > 0) {
                //If ID is dob
                if (label.equalsIgnoreCase("Date of Birth")) {
                    page.locator("#dob").fill(value);
                } else {
                    container.locator("input").fill(value);
                }
            }
        }
    }

    public void uploadPicture(String relativePath) {
        Path filePath = Paths.get(relativePath);
        if (Files.exists(filePath)) {
            page.setInputFiles("//input[@id='picture']", filePath);
        } else {
            throw new RuntimeException("Exception: File does not exist at this path " + filePath.toAbsolutePath());
        }
    }

    public void submit() {
        page.locator("//input[@type='submit' and @value='Login']").click();
    }
}