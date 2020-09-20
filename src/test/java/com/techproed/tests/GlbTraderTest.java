package com.techproed.tests;

import com.techproed.pages.GlbTraderPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbTraderTest extends TestBaseFinal {

    @Test
    public void test1() throws InterruptedException {
        extentTest = extentReports.createTest("glb trader test", "link test");

        extentTest.info("go to glb trade url");
        Driver.getDriver().get(ConfigurationReader.getProperty("glbtrader_url"));

        extentTest.info("create object from glb trade page class");
        GlbTraderPage glbtraderPage = new GlbTraderPage();

        extentTest.info("create object from select class");
        Select select = new Select(glbtraderPage.categoriesDropDown);

        extentTest.info("choose title from dropdown");
        select.selectByVisibleText("Consumer Electronics");
        extentTest.info("search" + ConfigurationReader.getProperty("search_word") + "word");

        Thread.sleep(3000);
        glbtraderPage.searchBox.sendKeys(ConfigurationReader.getProperty("search_word") + Keys.ENTER);

        Thread.sleep(3000);
        extentTest.info("get title after search page");
        String titleSearch = Driver.getDriver().getTitle();

        extentTest.info("click second element");
        glbtraderPage.links.get(1).click();
        Thread.sleep(3000);

        extentTest.info("get title after click first index element");
        String titleAfterSearch = Driver.getDriver().getTitle();

        extentTest.info("do assert transaction");
        Assert.assertEquals(titleSearch, titleAfterSearch);

        extentTest.pass("PASSED!");

    }
}
