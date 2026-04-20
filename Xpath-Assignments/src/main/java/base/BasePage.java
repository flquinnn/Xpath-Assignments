package base;

import com.microsoft.playwright.Page;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    // Hàm tạo XPath động dùng Axis
    protected String getInputElementByLabel(String label) {
        return String.format("//label[contains(text(),'%s')]/following-sibling::div/input", label);
    }

    protected String getTextAreaElementByLabel(String label) {
        return String.format("//label[contains(text(),'%s')]/following-sibling::div/textarea", label);
    }

    protected String getSelectionElementByLabel(String label, String value) {
        return String.format("//label[contains(text(),'%s')]/following-sibling::div//label[contains(text(),'%s')]", label, value);
    }

    // Hàm upload file có check tồn tại
    public void uploadFile(String selector, String relativePath) {
        Path filePath = Paths.get(relativePath);
        if (Files.exists(filePath)) {
            page.setInputFiles(selector, filePath);
        } else {
            throw new RuntimeException("CRITICAL: File không tồn tại tại: " + filePath.toAbsolutePath());
        }
    }
}