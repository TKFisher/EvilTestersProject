package com.javafortesters.htmlunitdriver;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class startWebDriver {

    WebDriver driver ;

    @Test
    public void headlessDriver (){

         driver = new HtmlUnitDriver();
         driver.navigate().to("http://www.compendiumdev.co.uk/selenium/");

         assertTrue("The title starts as expected.", driver.getTitle().startsWith("Selenium Simplified"));

        driver.close();
        driver.quit();
    }

    @Test
    public void browserDriverTest(){

        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/");

        assertTrue("This title contains expected text.", driver.getTitle().contains("Automated Web Testing with Java"));

        driver.close();
        driver.quit();
    }

}
