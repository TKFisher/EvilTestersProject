package com.javafortesters.methodsforexercises;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Methods {



    public static void submitButtonClick(WebDriver driver) {

        WebElement submitButtonBasicHTMLPage;
        submitButtonBasicHTMLPage = driver.findElement(By.cssSelector("input[name='submitbutton'][value='submit']"));
        submitButtonBasicHTMLPage.click();

    }
}
