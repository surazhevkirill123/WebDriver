package HurtMePlenty.test;

import Properties.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AbstractTest {
    protected WebDriver driver;
    protected static final String EXPECTED_VMCLASS = "VM class: regular";
    protected static final String EXPECTED_INSTANCE_TYPE = "Instance type: n1-standard-8\n" +
            "Committed Use Discount applied\n" +
            "USD 899.76";
    protected static final String EXPECTED_REGION = "Region: Frankfurt";
    protected static final String EXPECTED_LOCAL_SSD = "Local SSD: 2x375 GiB\n" +
            "Committed Use Discount applied\n" +
            "USD 183.01";
    protected static final String EXPECTED_COMMITMENT_TERM = "Commitment term: 1 Year";
    protected static final String EXPECTED_TOTAL_ESTIMATED_COST = "Total Estimated Cost: USD 1,084.69 per 1 month";

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void browserExit() {
        driver.quit();
        driver = null;
    }
}
