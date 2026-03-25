package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.ExcelReader;

import java.lang.reflect.Method;
import java.util.Map;

public class validSignupTest extends BaseTest {

    @DataProvider(name = "signupData")
    public Object[][] getSignupData(Method method) {
        return ExcelReader.getData("TestData", method);
    }

    @Test(dataProvider = "signupData")
    public void validSignupTest (Map<String, String> data) {

        SignupPage signupPage = new SignupPage(driver);

        signupPage.clickSignUp();
        signupPage.enterEmail(data.get("email"));
        signupPage.enterPassword(data.get("password"));
        signupPage.clickcertifyCheckbox();
        signupPage.clickNext();
        String stringVisible = driver.getTitle();
        Assert.assertEquals("Slide to complete the puzzle",stringVisible);

    }
}