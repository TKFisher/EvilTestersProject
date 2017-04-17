package com.javafortesters.htmlunitdriver;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class startWebDriver {

    WebDriver ffDriver = new FirefoxDriver();

    @Test
    public void headlessDriver (){

         WebDriver driver = new HtmlUnitDriver();
         driver.navigate().to("http://www.compendiumdev.co.uk/selenium/");

         assertTrue("The title starts as expected.", driver.getTitle().startsWith("Selenium Simplified"));

        driver.close();
        driver.quit();
    }

    @Test
    public void browserDriverTest(){

        ffDriver.get("http://www.compendiumdev.co.uk/selenium/");

        assertTrue("This title contains expected text.", ffDriver.getTitle().contains("Automated Web Testing with Java"));

        ffDriver.close();
        ffDriver.quit();
    }

}
