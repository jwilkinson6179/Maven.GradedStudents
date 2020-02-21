package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {
    Classroom testClass;

    @Test
    public void classroomConstructorAndGet()
    {
        // GIVEN
        Double[] scoresA = { 100.0, 80.0, 85.0 };
        Student testStudentA = new Student("James", "Wilkinson", scoresA);
        Double[] scoresB = { 75.0, 92.0, 45.0 };
        Student testStudentB = new Student("Doug", "Funny", scoresB);
        Double[] scoresC = { 55.0, 0.0, 0.0 };
        Student testStudentC = new Student("Nelson", "Muntz", scoresC);

        Student[] testStudents = { testStudentA, testStudentB, testStudentC };
        testClass = new Classroom(testStudents);
        Student[] expected = testStudents;

        // WHEN

        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void addStudent()
    {
        // GIVEN
        Double[] scoresA = { 100.0, 80.0, 85.0 };
        Student testStudentA = new Student("Nerdy", "Nerdson", scoresA);
        Double[] scoresB = { 75.0, 92.0, 45.0 };
        Student testStudentB = new Student("Average", "McAverage", scoresB);
        Double[] scoresC = { 55.0, 0.0, 0.0 };
        Student testStudentC = new Student("Skips", "Alot", scoresC);

        Student[] expected = { testStudentA, testStudentB, testStudentC };

        Student[] testStudents = { testStudentA, testStudentB };
        testClass = new Classroom(testStudents);

        // WHEN

        testClass.addStudent(testStudentC);
        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void addStudentToEmptyClass()
    {
        // GIVEN
        Double[] scoresA = { 100.0, 80.0, 85.0 };
        Student testStudentA = new Student("Nerdy", "Nerdson", scoresA);
        testClass = new Classroom();
        Student[] expected = { testStudentA };

        // WHEN

        testClass.addStudent(testStudentA);
        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void removeStudentFromClassOfOne()
    {
        // GIVEN
        Double[] scoresA = { 100.0, 80.0, 85.0 };
        Student testStudentA = new Student("Josh", "Smartipants", scoresA);
        Student[] testStudents = { testStudentA };
        testClass = new Classroom(testStudents);
        Student[] expected = new Student[1];

        // WHEN

        testClass.removeStudent("Josh", "Smartipants");
        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }
}
