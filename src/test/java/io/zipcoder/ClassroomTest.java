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

    @Test void addStudent()
    {

    }

}
