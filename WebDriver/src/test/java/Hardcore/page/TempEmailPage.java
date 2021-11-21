package Hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TempEmailPage extends AbstractPage {
    String TEMP_EMAIL_URL = "https://generator.email/email-generator";

    @FindBy(id = "email_ch_text")
    WebElement fieldTempEmail;

    @FindBy(xpath = "//h3[contains(text(), 'USD')]")
    WebElement priceAmount;

    public TempEmailPage(WebDriver driver) {
        super(driver);
    }

    public TempEmailPage openInNewTab() {
        openNewTab();
        switchToNextTab();
        driver.get(TEMP_EMAIL_URL);
        return this;
    }

    public String getTempEMail() {
        return waitForWebElementVisible(fieldTempEmail).getText();
    }

    public String getCostFromEmail() {
        return waitForWebElementVisible(priceAmount).getText();
    }
}
