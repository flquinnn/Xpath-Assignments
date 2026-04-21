package tests;

import org.example.base.BaseTest;
import pages.PracticeFormPage;
import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class PracticeFormTest extends BaseTest {

    String path = System.getProperty("user.dir");
    String imagePath = path + File.separator + "src/test/resources/avatar.png";

    @Test
    public void TC01_fillStudentRegistrationForm() {
        PracticeFormPage formPage = new PracticeFormPage(page);

        formPage.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        //LinkedHashMap
        Map<String, String> data = new LinkedHashMap<>();
        data.put("Name", "Phong");
        data.put("Email", "phongvu@example.com");
        data.put("Gender", "Male");
        data.put("Mobile(10 Digits)", "0947569765");
        data.put("Date of Birth", "2004-10-11");
        data.put("Subjects", "Information Technology");
        data.put("Hobbies", "Reading");
        data.put("Picture", imagePath);
        data.put("Current Address", "Gia Lai, Viet Nam");
        data.put("State and City", "NCR, Delhi");

        //Fill form
        formPage.fillStudentRegistrationForm(data);
        formPage.submit();

        System.out.println("TC01: Success!");
    }
}