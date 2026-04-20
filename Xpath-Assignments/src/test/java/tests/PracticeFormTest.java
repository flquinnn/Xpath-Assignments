package tests;

import base.BaseTest;
import org.example.pages.PracticeFormPage;
import org.testng.annotations.Test; // Import của TestNG
import java.util.LinkedHashMap;
import java.util.Map;

public class PracticeFormTest extends BaseTest {

    @Test
    public void TC01_fillStudentRegistrationForm() {
        PracticeFormPage formPage = new PracticeFormPage(page);

        formPage.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        //LinkedHashMap
        Map<String, String> data = new LinkedHashMap<>();
        data.put("First Name", "Phong");
        data.put("Last Name", "Vu");
        data.put("Email", "phongvu@example.com");
        data.put("Gender", "Male");
        data.put("Mobile", "0947569765");
        data.put("Date of Birth", "2004-10-11");
        data.put("Subjects", "Information Technology");
        data.put("Hobbies", "Reading");
        data.put("Address", "Gia Lai, Viet Nam");
        data.put("State", "NCR");
        data.put("City", "Delhi");

        //Fill form
        formPage.fillStudentRegistrationForm(data);

        //Upload picture and exception
        try {
            formPage.uploadPicture("src/test/resources/avatar.png");
        } catch (Exception e) {
            System.err.println("Error Upload: " + e.getMessage());
        }

        formPage.submit();

        System.out.println("TC01: Success!");
    }
}