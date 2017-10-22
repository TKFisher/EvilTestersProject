package com.javafortesters.userinteractions;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.javafortesters.methodsforexercises.Methods.submitButtonClick;
import static org.junit.Assert.assertEquals;


public class Exercises {

    WebDriver driver = new ChromeDriver();

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void keyboardActions(){

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        Action clickCheckBox1 = new Actions(driver).click(driver.findElement(By.cssSelector("input[value='cb1']"))).build();

        clickCheckBox1.perform();
        clickCheckBox1.perform();
        clickCheckBox1.perform();

        submitButtonClick(driver);

       // assertEquals("cb1", driver.findElement(By.id("_valuecheckboxes0")).getText());

    }
}
