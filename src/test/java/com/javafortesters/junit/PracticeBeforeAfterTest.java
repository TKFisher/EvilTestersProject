package com.javafortesters.junit;

import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class PracticeBeforeAfterTest {

    private String myName = "Tracy";
    private String nickname = "Twacy";
    private int nameSize = 5;

    @BeforeClass
    public static void beginTestMessage() {
        System.out.println("Begin tests here. Good luck. ");
    }

    @Before
    public void runBeforeEachTest() {
         myName = nickname;
    }

    @Test
    public void checkBeginningOfNicName() {
        assertTrue("Beginning of nic name is not correct.", myName.contains("Tw"));
    }

    @Test
    public void checkEndingOfName() {
        assertFalse("name ends as expected", myName.endsWith("ey"));
    }

    @Test()
    public void checkFullSpellingOfName() {
        myName = "Tracy";
        assertEquals("Tracy", myName);
    }

    @Test
    public void checkNumberOfCharactersOfName() {
        assertThat(nameSize, is(5));
    }

    @Test
    public void checkNicName(){
        assertThat(myName, is(not("Tracy")));
    }

    @AfterClass
    public static void endTestMessage() {
        System.out.println("End of tests. How you do? ");
    }

}
