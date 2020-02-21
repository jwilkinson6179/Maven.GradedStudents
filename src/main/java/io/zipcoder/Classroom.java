package io.zipcoder;

import java.util.*;
import java.util.logging.Logger;

public class Classroom
{
    private static final Logger LOGGER = Logger.getLogger(Classroom.class.getName());
    ArrayList<Student> pupils;

    public Classroom()
    {
        pupils = new ArrayList<>(30);
    }

    public Classroom(Integer classSize)
    {
        pupils = new ArrayList<>(classSize);
    }

    public Classroom(Student[] initialPupils)
    {
        pupils = new ArrayList<>(initialPupils.length);

        for(Integer i = 0; i < initialPupils.length; i++)
        {
            pupils.add(i, initialPupils[i]);
        }
    }

    public Student[] getStudents()
    {
        Student[] result;
        if (pupils.size() == 0)
        {
            result = new Student[0];
        }
        else
            {

                result = new Student[pupils.size()];

                for (Integer i = 0; i < pupils.size(); i++)
                {
                    result[i] = pupils.get(i);
                }
        }

        return result;
    }


    public Double getAverageExamScore()
    {
        Double sum = 0.0;

        for(Student pupil : pupils)
        {
            sum += getAverageExamScore();
        }

        return sum / pupils.size();
    }

    // TODO: Duplicate prevention?
    public void addStudent(Student newStudent)
    {
        pupils.add(newStudent);
    }

    public void removeStudent(String firstName, String lastName)
    {
        for(int i = 0; i < pupils.size(); i++)
        {
            if(     (pupils.get(i).getFirstName().equals(firstName)) &&
                    (pupils.get(i).getLastName().equals(lastName)))
            {
                pupils.remove(i);
            }
        }
    }

    public Student[] getStudentsByScore()
    {
        ArrayList<Student> pupilsByScore = new ArrayList<>();
        Student[] result = new Student[pupils.size()];
        pupilsByScore.addAll(pupils);
        Collections.sort(pupilsByScore, Collections.reverseOrder());

        for(Integer i = 0; i < pupilsByScore.size(); i++)
        {
            result[i] = pupilsByScore.get(i);
        }

        return result;
    }

    public Map<Student, Character> getGradeBook()
    {
        Map<Student, Character> grades = new HashMap<>();
        Student[] studentsByScores = this.getStudentsByScore();
        Integer totalStudents = studentsByScores.length;

        Integer As = totalStudents / 10; // Top 10%
        Integer Bs = totalStudents / 30; // 11% to 29%
        Integer Cs = totalStudents / 50; // 30% to 50%
        Integer Ds = totalStudents / 90; // 51% to 89%

        for(Integer i = 0; i < As; i++)
        {
            grades.put(studentsByScores[i], 'A');
        }
        for(Integer i = As; i < Bs; i++)
        {
            grades.put(studentsByScores[i], 'B');
        }
        for(Integer i = Bs; i < Cs; i++)
        {
            grades.put(studentsByScores[i], 'C');
        }
        for(Integer i = Ds; i < Ds; i++)
        {
            grades.put(studentsByScores[i], 'D');
        }
        for(Integer i = Ds; i < totalStudents; i++)
        {
            grades.put(studentsByScores[i], 'F');
        }

        return grades;
    }
}