package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignupPage;
import utils.ExcelReader;

import java.lang.reflect.Method;
import java.util.Map;

public class invalidSignupTest extends BaseTest {

    @DataProvider(name = "signupData")
    public Object[][] getSignupData(Method method) {
        return ExcelReader.getData("TestData", method);
    }

    @Test(dataProvider = "signupData")
    public void invalidSignupTest(Map<String, String> data) {

        SignupPage signupPg = new SignupPage(driver);

        signupPg.clickSignUp();
        signupPg.enterEmail(data.get("email"));
        signupPg.enterPassword(data.get("password"));
        signupPg.clickcertifyCheckbox();
        signupPg.clickcertifyCheckbox();

        boolean isNextEnabled = signupPg.isnextButtonEnabled();

        Assert.assertFalse(isNextEnabled, "Next button should remain disabled for invalid signup data");

    }
}

