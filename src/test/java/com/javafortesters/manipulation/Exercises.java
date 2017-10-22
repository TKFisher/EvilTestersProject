package com.javafortesters.manipulation;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class Exercises {

    WebDriver driver = new ChromeDriver();

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void goToWebPage() {
        driver.navigate().to("https://www.google.com/");
        assertTrue(driver.getTitle().startsWith("Google"));
        assertEquals("Page Title is not correct.", "Google", driver.getTitle());
        assertThat("Page Title is not correct.", driver.getTitle(), is("Google"));
    }

    @Test
    public void clickSignIn() {

        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.cssSelector("#gb_70")).click();
        //driver.findElement(By.id("gb_70"));
        assertEquals("Sign in - Google Accounts", driver.getTitle());
    }

    @Test
    public void clickButton() {
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");

        //Find first element select it:  <option value="3">Server</option>
        driver.findElement(By.cssSelector("#combo1 option[value='3']")).click();

        //Find second element and select it:   <option value="23">Java</option>
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("#combo2 option[value='23']"))).click();
        // driver.findElement(By.cssSelector("#combo2 option[value='23']")).click();

        driver.findElement(By.cssSelector("input[name='submitbutton']")).click();

        // assert:  <li id="_valuelanguage_id">23</li>
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#_valuelanguage_id")));
        assertThat("Incorrect value. ", driver.findElement(By.cssSelector("#_valuelanguage_id")).getText(), is("23"));
    }

    @Test
    public void enterTextSubmit() {

        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");

        // find text box element and enter some text
        driver.findElement(By.cssSelector("#lteq30")).sendKeys("java");

        // find submit element and click it
        driver.findElement(By.cssSelector("input[name='submitbutton']")).click();
    }

    @Test
    public void submitButton() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        submitButtonClick();
        assertEquals("Processed Form Details", driver.getTitle());

    }

    @Test
    public void submitByUsingFormElement() {
        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        driver.findElement(By.id("HTMLFormElements")).submit();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("_hiddenField")));
        assertThat(driver.findElement(By.name("_hiddenField")).getText(), is("hiddenField"));

    }

    @Test
    public void clearAddComments() {
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement submitButton;
        WebElement commentTextArea;

        String myTextComments = "my test comments.";

        submitButton = driver.findElement(By.cssSelector("input[name='submitbutton'][value='submit']"));
        submitButton.click();

        assertEquals("Expect default comments.", driver.findElement(By.id("_valuecomments")).getText(), "Comments...");

        driver.findElement(By.cssSelector("[id='back_to_form']")).click();

        //find the comment field and clear it.
        //commentTextArea = driver.findElement(By.cssSelector("textarea[name='comments']"));
        commentTextArea = driver.findElement(By.name("comments"));
        commentTextArea.clear();

        // enter comments
        commentTextArea.sendKeys(myTextComments);

        submitButton = driver.findElement(By.cssSelector("input[name='submitbutton'][value='submit']"));
        submitButton.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id='_valuecomments']")));
        assertThat("Expected updated comments.", driver.findElement(By.cssSelector("[id='_valuecomments']")).getText(), is("my test comments."));
    }

    @Test
    public void selectRadioButton() {
        WebElement formElement;
        String textResult;

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
        driver.findElement(By.cssSelector("[name][value='rd2']")).click();

        formElement = driver.findElement(By.name("HTMLFormElements"));
        formElement.submit();

        //textResult = driver.findElement(By.id("_valueradioval")).getText();
        textResult = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated
                (By.id("_valueradioval"))).getText();

        assertEquals(textResult, "rd2");

    }

    @Test
    public void checkBoxes() {

        WebElement checkBoxResult1;
        WebElement checkBoxResult2;

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[name='checkboxes[]']"));
        for (WebElement checkBox : allCheckBoxes) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            } else if (checkBox.isDisplayed()) {
                checkBox.click();
            }
        }

        submitButtonClick();

        checkBoxResult1 = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("_valuecheckboxes0")));
        //checkBoxResult1.getText();

        checkBoxResult2 = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("_valuecheckboxes1")));
        //checkBoxResult2.getText();

        assertEquals("cb1", checkBoxResult1.getText());
        assertEquals("cb2", checkBoxResult2.getText());
    }

    @Test
    public void checkDropDown5() {

        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement dropdown = driver.findElement(By.cssSelector("[name='dropdown']"));
        WebElement dropdownChoice5 = dropdown.findElement(By.cssSelector("option[value='dd5']"));

        dropdownChoice5.click();

        submitButtonClick();

        assertEquals("dd5", driver.findElement(By.id("_valuedropdown")).getText());

    }

    @Test
    public void multiSelect() {


        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement multiSelectTextBox;

        multiSelectTextBox = driver.findElement(By.cssSelector("[multiple='multiple']"));

        List<WebElement> dropDownMultiSelectOptions = multiSelectTextBox.findElements(By.tagName("option"));

        dropDownMultiSelectOptions.get(0).click();

        if (!dropDownMultiSelectOptions.get(1).isSelected()) {
            dropDownMultiSelectOptions.get(1).click();
        }

        if (!dropDownMultiSelectOptions.get(2).isSelected()) {
            dropDownMultiSelectOptions.get(2).click();
        }


        if (dropDownMultiSelectOptions.get(3).isSelected()) {
            dropDownMultiSelectOptions.get(3).click();
        }

        submitButtonClick();


        assertEquals("ms1", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect0']")).getText());
        assertEquals("ms2", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect1']")).getText());
        assertEquals("ms3", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect2']")).getText());
        assertTrue("Expect that ms4 is not present.", driver.findElements(By.id
                ("_valuemultipleselect3")).isEmpty());

    }

    @Test
    public void submitFormWithFile() {


        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement file;
        file = driver.findElement(By.cssSelector("input[name='filename']"));
        file.sendKeys("/Users/tracyfisher/Documents/My Documents/Documents/Test.txt");

        submitButtonClick();

        WebElement filename = driver.findElement(By.id("_valuefilename"));

        assertEquals("Test.txt", filename.getText());

    }

    @Test
    public void checkIfClearingCheckBoxesWorks() {

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement checkBox3;
        checkBox3 = driver.findElement(By.cssSelector("input[value='cb3']"));

        try {
            checkBox3.clear();
            fail("Expected not to be able to clear a checkbox.");
        } catch (WebDriverException e) {
            // Current Selenium does not allow you to clear a checkbox or multi select box.
            // If this test fails it means that new functionality has been added to allow for this.
        }
    }

    @Test
    public void multiSelectWithSelectClass() {

        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement multiSelectBox;

        multiSelectBox = driver.findElement(By.cssSelector("[multiple='multiple']"));

        Select multiSelect = new Select(multiSelectBox);
        assertTrue("Expected to find multiple select field.", multiSelect.isMultiple());

        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        assertEquals(1, selectedOptions.size());

        multiSelect.deselectAll();

        selectedOptions = multiSelect.getAllSelectedOptions();
        assertEquals(0, selectedOptions.size());

        multiSelect.selectByValue("ms1");
        multiSelect.selectByIndex(1);
        multiSelect.selectByVisibleText("Selection Item 3");

        selectedOptions = multiSelect.getAllSelectedOptions();
        assertEquals(3, selectedOptions.size());

        submitButtonClick();

        assertEquals("ms1", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect0']")).getText());
        assertEquals("ms2", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect1']")).getText());
        assertEquals("ms3", driver.findElement(By.cssSelector
                ("[id='_valuemultipleselect2']")).getText());
        assertTrue("Expect that ms4 is not present.", driver.findElements(By.id
                ("_valuemultipleselect3")).isEmpty());

    }

    @Test
    public void chooseFileAndSelectToOpen() {

        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement browseButton;
        browseButton = driver.findElement(By.name("filename"));

        browseButton.sendKeys("/Users/tracyfisher/GIT_Projects/Training/testfile");

        submitButtonClick();

        assertEquals("testfile", driver.findElement(By.id("_valuefilename")).getText());

    }

    @Test
    public void openFileFromrResources() throws URISyntaxException {

        driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");

        WebElement filenameInput;
        filenameInput = driver.findElement(By.name("filename"));

        File testFile = new File(this.getClass().getResource("/testFile.txt").toURI());

        filenameInput.sendKeys(testFile.getAbsolutePath());

        submitButtonClick();

        assertEquals("testFile.txt", driver.findElement(By.id("_valuefilename")).getText());
    }

    private void submitButtonClick() {

        WebElement submitButton;
        submitButton = driver.findElement(By.cssSelector("input[name='submitbutton'][value='submit']"));
        submitButton.click();
    }





}
