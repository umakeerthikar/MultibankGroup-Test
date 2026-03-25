package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelReader;

import java.lang.reflect.Method;
import java.util.Map;

public class loginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(Method method) {
        return ExcelReader.getData("LoginData", method); // Excel sheet with email/password
    }

    @Test(dataProvider = "loginData")
    public void loginTest(Map<String, String> data) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(data.get("email"));
        loginPage.enterPassword(data.get("password"));

        // Optional: check if login button is enabled before clicking
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should be enabled");

        loginPage.clickLogin();

        // Assertions for valid vs invalid login
        if (data.get("valid").equalsIgnoreCase("yes")) {
            // For valid login, check landing page or URL
            String title = driver.getTitle();
            Assert.assertTrue(title.contains("Slide to complete the puzzle") || title.contains("puzzle"),
                    "User should be redirected to dashboard/home after valid login");
        } else {
            // For invalid login, check error message
            String error = loginPage.getErrorMessage();
            Assert.assertTrue(error.contains("Invalid") || error.contains("incorrect"),
                    "Error message should be displayed for invalid login");
        }
    }
}