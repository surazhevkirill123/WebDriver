package BringItOn.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinMainPage extends AbstractPage {
    private final String BASE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    WebElement textAreaNewPaste;

    @FindBy(id = "select2-postform-format-container")
    WebElement syntaxDropdown;
    @FindBy(xpath = "//li[text()='Bash']")
    WebElement syntaxBash;

    @FindBy(id = "select2-postform-expiration-container")
    WebElement expirationDropdown;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement expiration10M;

    @FindBy(id = "postform-name")
    WebElement inputTitle;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonNewPaste;

    public PastebinMainPage(WebDriver driver) {
        super(driver);
    }

    public PastebinMainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public PastebinMainPage typeInNewPasteText(String newPasteText) {
        waitForWebElementVisible(textAreaNewPaste).sendKeys(newPasteText);
        return this;
    }

    public PastebinMainPage openSyntaxDropdown() {
        syntaxDropdown.click();
        return this;
    }

    public PastebinMainPage selectSyntaxBash() {
        syntaxBash.click();
        return this;
    }

    public PastebinMainPage openExpirationDropdown() {
        expirationDropdown.click();
        return this;
    }

    public PastebinMainPage selectExpiration10M() {
        expiration10M.click();
        return this;
    }

    public PastebinMainPage typeInNewPasteTitle(String newPasteTitle) {
        inputTitle.sendKeys(newPasteTitle);
        return this;
    }

    public PastebinMainPage submitNewPaste() {
        buttonNewPaste.click();
        return this;
    }
}
