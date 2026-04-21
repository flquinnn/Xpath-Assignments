package pages;

import com.microsoft.playwright.Page;
import org.example.base.BasePage;

import java.nio.file.Paths;
import java.util.Map;
import java.io.File;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(Page page) {
        super(page);
    }

    //Type Field
    private String textField(String label) {
        return String.format("//label[normalize-space(.)='%s:']/following-sibling::div/*[self::input or self::textarea]", label);
    }

    private String radioOrCheckbox(String label, String value) {
        return String.format("//label[normalize-space(text())='%s:']/following-sibling::div//label[text()='%s']/preceding-sibling::input", label, value);
    }

    private String dropdown(String id) {
        return String.format("//select[@id='%s']", id);
    }

    //Method Upload Picture
    private String fileUploadField(String label) {
        return String.format("//label[normalize-space(text())='%s:']/following-sibling::div//input[@type='file']", label);
    }

    public void uploadFile(String label, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("EXCEPTION: File does not exits " + filePath);
        }
        page.setInputFiles(fileUploadField(label), Paths.get(filePath));
    }

    public void navigate(String url) {
        page.navigate(url);
    }

    public void fillStudentRegistrationForm(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {

            String label = entry.getKey();
            String value = entry.getValue();

            if (page.locator(radioOrCheckbox(label,value)).isVisible()) {
                page.locator(radioOrCheckbox(label,value)).check();
            } else if (page.locator(textField(label)).isVisible()) {
                fill(textField(label),value);
            } else if (page.locator(dropdown(label)).isVisible()) {
                page.selectOption(dropdown(label),value);
            } else if (page.locator(fileUploadField(label)).isVisible()) {
                uploadFile(label, value);
            }
        }
    }

    public void submit() {
        click("//input[@type='submit' and @value='Login']");
    }
}