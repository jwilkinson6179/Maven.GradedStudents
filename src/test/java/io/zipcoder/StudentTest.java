package io.zipcoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StudentTest
{

    @Test
    public void makeAStudentTest()
    {
        // GIVEN

        String expectedFirstName = "Yimmy";
        String expectedLastName = "Yava";
        Double[] scores = { 81.5, 79.0 };
        Student testStudent = new Student(expectedFirstName, expectedLastName, scores);

        // WHEN

        String actualFirstName = testStudent.getFirstName();
        String actualLastName = testStudent.getLastName();

        // THEN

        assertEquals(expectedFirstName, actualFirstName);
        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void NameChange()
    {
        // GIVEN

        String expectedName = "James";
        String unexpectedName = "Gary";
        Double[] scores = { 55.0 };
        Student testStudent = new Student(unexpectedName, "Wilkinson", scores);

        // WHEN

        testStudent.setFirstName(expectedName);
        String actualName = testStudent.getFirstName();

        // THEN
        assertEquals(expectedName, actualName);
        assertNotEquals(unexpectedName, actualName);
    }

    @Test
    public void LastNameChange()
    {
        // GIVEN

        String expectedName = "Jones";
        String unexpectedName = "Howard";
        Double[] scores = { 55.0 };
        Student testStudent = new Student("Tim", unexpectedName, scores);

        // WHEN

        testStudent.setLastName(expectedName);
        String actualName = testStudent.getLastName();

        // THEN
        assertEquals(expectedName, actualName);
        assertNotEquals(unexpectedName, actualName);
    }

    @Test
    public void numberOfExams()
    {
        // GIVEN

        Integer expected = 4;
        Integer notExpected = 0;
        Double[] scores = { 100.0, 50.0, 25.0, 0.0 };
        Student testStudent = new Student("Testy", "Testerson", scores);

        // WHEN

        Integer actual = testStudent.getNumberOfExamsTaken();

        // THEN

        assertEquals(expected, actual);
        assertNotEquals(notExpected, actual);
    }

    @Test
    public void printExamsOne()
    {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 95\n" +
                "\tExam 3 -> 123\n" +
                "\tExam 4 -> 96\n";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actual = student.getExamScores();

        // Then

        assertEquals(expected, actual);
        assertNotEquals(null, actual);
    }

    @Test
    public void addExamScore()
    {
        // : Given
        String expected = "Exam Scores:\n" +
            "\tExam 1 -> 100\n";
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String actual = student.getExamScores();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void changeGrade()
    {
        // GIVEN

        String firstName = "Leon";
        String lastName = "Hunter";
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 150\n";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        // When

        student.setExamScore(1, 150.0);
        String actual = student.getExamScores();

        // Then

        assertEquals(expected, actual);
    }

    @Test
    public void getAverage()
    {
        // GIVEN

        Double expected = 125.0;
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student testStudent = new Student(firstName, lastName, examScores);

        // WHEN

        Double actual = testStudent.getAverageExamScore();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void studentToString() {
        // GIVEN

        String expected = "Student Name: Leon Hunter\n" +
        "Average Score: 125\n" +
        "Exam Scores:\n" +
        "\tExam 1 -> 100\n" +
        "\tExam 2 -> 150\n" +
        "\tExam 3 -> 250\n" +
        "\tExam 4 -> 0\n";
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // WHEN

        String actual = student.toString();

        // THEN

        assertEquals(expected, actual);
    }
}