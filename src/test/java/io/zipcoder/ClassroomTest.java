package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class ClassroomTest {
    Classroom testClass;
    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());

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
        Student[] expected = new Student[0];

        // WHEN

        testClass.removeStudent("Josh", "Smartipants");
        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void removeStudent()
    {
        // GIVEN

        Double[] scoresA = { 100.0, 80.0, 85.0 };
        Student testStudentA = new Student("Nerdy", "Nerdson", scoresA);
        Double[] scoresB = { 75.0, 92.0, 45.0 };
        Student testStudentB = new Student("Average", "McAverage", scoresB);
        Double[] scoresC = { 55.0, 0.0, 0.0 };
        Student testStudentC = new Student("Skips", "Alot", scoresC);

        Student[] expected = { testStudentA, testStudentB };

        Student[] testStudents = { testStudentA, testStudentB, testStudentC };
        testClass = new Classroom(testStudents);

        // WHEN

        testClass.removeStudent("Skips", "Alot");
        Student[] actual = testClass.getStudents();

        // THEN

        assertEquals(expected, actual);
    }

    @Test
    public void sortedStudents()
    {
        // GIVEN

        Double[] scoresA = { 80.5, 75.0, 85.0 };
        Student testStudentA = new Student("Second", "Beta", scoresA);
        Double[] scoresB = { 90.0, 92.0, 100.0 };
        Student testStudentB = new Student("Firsty", "Alpha", scoresB);
        Double[] scoresC = { 55.0, 0.0, 0.0 };
        Student testStudentC = new Student("Third", "McThirdy", scoresC);
        Student[] pupils = { testStudentA, testStudentB, testStudentC };
        testClass = new Classroom(pupils);
        Student[] unsortedExpected = { testStudentA, testStudentB, testStudentC};
        Student[] sortedExpected = { testStudentB, testStudentA, testStudentC };

        // WHEN

        Student[] unsortedActual = testClass.getStudents();
        Student[] sortedActual = testClass.getStudentsByScore();

        // THEN

        assertEquals(unsortedExpected, unsortedActual);
        assertEquals(sortedExpected, sortedActual);
    }

    @Test
    public void sortedStudentsTieBreaker()
    {
        // GIVEN

        Double[] scoresA = { 100.0 };
        Student testStudentA = new Student("Three", "Charlie", scoresA);
        Double[] scoresB = { 100.0 };
        Student testStudentB = new Student("First", "Alpha", scoresB);
        Double[] scoresC = { 100.0 };
        Student testStudentC = new Student("Second", "Beta", scoresC);
        Student[] pupils = { testStudentA, testStudentB, testStudentC };
        testClass = new Classroom(pupils);
        Student[] unsortedExpected = { testStudentA, testStudentB, testStudentC};
        Student[] sortedExpected = { testStudentB, testStudentC, testStudentA };

        // WHEN

        Student[] unsortedActual = testClass.getStudents();
        Student[] sortedActual = testClass.getStudentsByScore();

        // THEN

        assertEquals(unsortedExpected, unsortedActual);
        assertEquals(sortedExpected, sortedActual);
    }

    @Test
    public void getGrades()
    {
        // GIVEN

        Double[] scoresA = { 100.0 };
        Student testStudentA = new Student("Paul", "Atredes", scoresA);
        Double[] scoresB = { 97.0 };
        Student testStudentB = new Student("Bilbo", "Baggins", scoresB);
        Double[] scoresC = { 95.0 };
        Student testStudentC = new Student("Moses", "Poses", scoresC);
        Double[] scoresD = { 91.0 };
        Student testStudentD = new Student("Timmy", "Grundersun", scoresD);
        Double[] scoresE = { 94.0 };
        Student testStudentE = new Student("Rudolph", "Raindeer", scoresE);
        Double[] scoresF = { 87.2 };
        Student testStudentF = new Student("Donald", "Duck", scoresF);
        Double[] scoresG = { 88.0 };
        Student testStudentG = new Student("Bugs", "Bunny", scoresG);
        Double[] scoresH = { 94.2 };
        Student testStudentH = new Student("Stevie", "Wonder", scoresH);
        Double[] scoresI = { 81.5 };
        Student testStudentI = new Student("Mark", "Milken", scoresI);
        Double[] scoresJ = { 83.5 };
        Student testStudentJ = new Student("Kobe", "Bryant", scoresJ);
        Student[] pupils = { testStudentA, testStudentB, testStudentC, testStudentD, testStudentE,
            testStudentF, testStudentG, testStudentH, testStudentI, testStudentJ };
        testClass = new Classroom(pupils);

        // WHEN

        LOGGER.log(Level.INFO, "My Map: " + testClass.getGradeBook());

        // THEN

        assertEquals(1, 2);
    }
}
