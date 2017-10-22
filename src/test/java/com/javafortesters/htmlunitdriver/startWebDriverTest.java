package com.javafortesters.htmlunitdriver;


import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


import static org.junit.Assert.assertTrue;

public class startWebDriverTest {

    // HtmlUnitDriver driver;   could have used this but it would not allow me to use various browsers.
    WebDriver driver;

    @Test
    public void headlessDriver() {

        driver = new HtmlUnitDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/");
        assertTrue("The title starts as expected.", driver.getTitle().startsWith("Selenium Simplified"));
        driver.close();
        driver.quit();
    }

    @Test
    public void browserDriverTest() {

        driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/");
        assertTrue("This title contains expected text.", driver.getTitle().contains("Automated Web Testing with Java"));
        driver.close();
        driver.quit();
    }

    @Ignore
    @Test
    public void browserFFTest(){
        driver = new FirefoxDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/");
        assertTrue("This title contains expected text.", driver.getTitle().contains("Automated Web Testing with Java"));
        driver.close();
        driver.quit();
    }

}
