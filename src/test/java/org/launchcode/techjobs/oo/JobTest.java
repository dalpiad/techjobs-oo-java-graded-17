package org.launchcode.techjobs.oo;

import org.junit.Test;
//

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1, testJob2);
    }

//    Job testJob1;
//    @BeforeEach
//    public void createJobObject() {
//        testJob1 = new Job(
//                "Product tester",
//                new Employer("ACME"),
//                new Location("Desert"),
//                new PositionType("Quality control"),
//                new CoreCompetency("Persistence")
//        );
//    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertTrue(testJob1.getName() instanceof String);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue(), "ACME");
        assertEquals(testJob1.getLocation().getValue(), "Desert");
        assertEquals(testJob1.getPositionType().getValue(), "Quality control");
        assertEquals(testJob1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job testJob2 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertEquals(testJob1.equals(testJob2), false);
    }

    //writing code for Task 5.

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

// Initially used search for first char, however would only return '\r' instead of '\r\n' because of windows.
//        int firstLineBreak = testJob1.toString().indexOf(lineSeparator());
//        int lastLineBreak = testJob1.toString().lastIndexOf(lineSeparator());;
//        assertEquals(firstLineBreak, 0);
//        assertEquals(lastLineBreak, testJob1.toString().length()-2);
//
//        String firstChar = String.valueOf(testJob1.toString().charAt(0));
//        String lastChar = String.valueOf(testJob1.toString().charAt(testJob1.toString().length()-1));
//        assertEquals(firstChar, lineSeparator());
//        assertEquals(lastChar, lineSeparator());
        assertTrue(testJob1.toString().startsWith(lineSeparator()));
        assertTrue(testJob1.toString().endsWith(lineSeparator()));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        String testJobOutput = String.format(lineSeparator() + "ID: %d", testJob1.getId())  +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" + lineSeparator();

        assertEquals(testJobOutput, testJob1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob1 = new Job(
                "",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency("")
        );


        String testJobOutput = String.format(lineSeparator() + "ID: %d", testJob1.getId()) +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" + lineSeparator();

        assertEquals(testJobOutput, testJob1.toString());
    }
}
