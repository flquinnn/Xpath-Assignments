package org.example.pages.;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Map;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(Page page) {
        super(page);
    }

        private String getFieldContainer(String label) {
        return String.format("//label[text()='%s']/following-sibling::div", label);
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void fillStudentRegistrationForm(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String label = entry.getKey();
            String value = entry.getValue();

            Locator container = page.locator(getFieldContainer(label));

            // Logic nhận diện loại field
            if (container.locator("select").count() > 0) {
                container.locator("select").selectOption(value);
            }
            else if (container.locator("textarea").count() > 0) {
                container.locator("textarea").fill(value);
            }
            else if (container.locator(String.format(".//label[text()='%s']", value)).count() > 0) {
                // Lưu ý: Dùng .//label để tìm bên trong container
                container.locator(String.format(".//label[text()='%s']", value)).click();
            }
            else if (container.locator("input").count() > 0) {
                if (label.equalsIgnoreCase("Date of Birth")) {
                    page.locator("#dob").fill(value);
                } else {
                    container.locator("input").fill(value);
                }
            }
        }
    }

    //Method Upload Picture
    public void uploadPicture(String relativePath) {
        uploadFile("//input[@id='picture']", relativePath);
    }

    public void submit() {
        click("//input[@type='submit' and @value='Login']");
    }
}