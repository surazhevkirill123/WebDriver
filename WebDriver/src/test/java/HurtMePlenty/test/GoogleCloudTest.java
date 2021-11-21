package HurtMePlenty.test;

import Hardcore.page.TempEmailPage;
import HurtMePlenty.page.GoogleCloudMainPage;
import HurtMePlenty.page.GoogleCloudPricingCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudTest extends AbstractTest {
    GoogleCloudMainPage cloudMainPage;
    String SEARCH_TERM_MAIN_PAGE = "Google Cloud Platform Pricing Calculator";
    GoogleCloudPricingCalculatorPage cloudCalculatorPage;

    @Test(description = "Fill in estimation form")
    public void fillInEstimationForm() {
        cloudMainPage = new GoogleCloudMainPage(driver)
                .openPage()
                .searchTerm(SEARCH_TERM_MAIN_PAGE)
                .clickCalculatorPage();
        cloudCalculatorPage = new GoogleCloudPricingCalculatorPage(driver)
                .switchToCalculatorIFrame()
                .fillInEstimationForm()
                .clickAddToEstimateButton();
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted VMClass value matches initial value")
    public void checkVMClass() {
        String actualText = cloudCalculatorPage.getVMClass();

        Assert.assertEquals(actualText, EXPECTED_VMCLASS, "Submitted VMClass doesn't match initial value");
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted Instance type matches initial value")
    public void checkInstanceType() {
        String actualText = cloudCalculatorPage.getInstanceType();

        Assert.assertEquals(actualText, EXPECTED_INSTANCE_TYPE, "Submitted InstanceType doesn't match initial value");
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted Region matches initial value")
    public void checkRegion() {
        String actualText = cloudCalculatorPage.getRegion();

        Assert.assertEquals(actualText, EXPECTED_REGION, "Submitted Region doesn't match initial value");
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted Local SSD matches initial value")
    public void checkLocalSSD() {
        String actualText = cloudCalculatorPage.getLocalSSD();

        Assert.assertEquals(actualText, EXPECTED_LOCAL_SSD, "Submitted Local SSD doesn't match initial value");
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted CommitmentTerm matches initial value")
    public void checkCommitmentTerm() {
        String actualText = cloudCalculatorPage.getCommitmentTerm();

        Assert.assertEquals(actualText, EXPECTED_COMMITMENT_TERM, "Submitted CommitmentTerm doesn't match initial value");
    }

    @Test(dependsOnMethods = {"fillInEstimationForm"},
            description = "Check if submitted TotalCost matches initial value")
    public void checkTotalCost() {
        String actualText = cloudCalculatorPage.getTotalCost();

        Assert.assertEquals(actualText, EXPECTED_TOTAL_ESTIMATED_COST, "Submitted TotalCost doesn't match initial value");
    }





}
