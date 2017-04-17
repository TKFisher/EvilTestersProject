package com.javafortesters.htmlunitdriver;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class startWebDriver {

    
    @Test
    public void headlessDriver (){

         WebDriver driver = new HtmlUnitDriver();
         driver.navigate().to("http://www.compendiumdev.co.uk/selenium/");

    }

}
