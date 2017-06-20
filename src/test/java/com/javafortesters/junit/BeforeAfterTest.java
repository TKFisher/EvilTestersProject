package com.javafortesters.junit;


import org.junit.*;

public class BeforeAfterTest {


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Runs before a class.");
    }

    @Before
    public void beforeEachTest(){
        System.out.println("Run before each test.");
    }

    @After
    public void afterEachTest(){
        System.out.println("Runs after each test.  ");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Runs after a class. ");
    }


    @Test
    public void myTest() {
        System.out.println("myTest");
    }

    @Test
    public void mySecondTest() {
        System.out.println("mySecondTest");
    }


}
