package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends TestBaseFinal {

    @Test
    public void amazonTest() throws InterruptedException {
        extentTest = extentReports.createTest("amazon website", "amazon search box");
        extentTest.info("go to amazon page");
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon_url"));
        extentTest.info("create object from amazonPage class");

        AmazonPage amazonPage = new AmazonPage();
        extentTest.info("click don't change");
        amazonPage.shipOption.click();
        extentTest.info("write 'camera' in the search box ");
        amazonPage.searchBox.sendKeys(ConfigurationReader.getProperty("search_word") + Keys.ENTER);
        Thread.sleep(3000);
        extentTest.info("get result stats text");
        String resultStats = (amazonPage.resultStats).getText();
        extentTest.info("do assert transaction ");
        Assert.assertTrue(resultStats.contains("camera"));
        extentTest.pass("PASSED!!");

    }
}
