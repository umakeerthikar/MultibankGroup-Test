package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SignupPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    //*[@id="__next"]/div/div/div/div[1]/div/div/form/div[3]/span/a
    By signUpBtn = By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/div/form/div[3]/span/a");

    By email = By.xpath("//*[@id=\":r2:\"]");
    By password = By.xpath("://*[@id=\":r3:\"]");
    By certifyCheckbox = By.xpath("//*[@id=\"headlessui-switch-:r4:\"]/div/svg");
    By nextButton = By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div[1]/div/form/button");

    // Actions
    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickcertifyCheckbox() {
        driver.findElement(certifyCheckbox).click();
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }
}