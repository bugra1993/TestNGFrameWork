package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleGmailTest extends TestBaseFinal {

    @Test
    public void gmailTest() throws InterruptedException {
        extentTest = extentReports.createTest("gmail test", "go to gmail by with google page");

        extentTest.info("go to google.com");
        Driver.getDriver().get(ConfigurationReader.getProperty("google_url"));
        extentTest.info("create object from google page");
        GooglePage googlePage = new GooglePage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        extentTest.info("click gmail link");
        wait.until(ExpectedConditions.visibilityOf(googlePage.gmail)).click();
        extentTest.info("wait 3 seconds");
        Thread.sleep(3000);
        extentTest.info("assert transaction");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Gmail"));
        extentTest.pass("Test PASSED!");

    }

}
