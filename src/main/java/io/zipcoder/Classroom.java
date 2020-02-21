package io.zipcoder;

import java.util.ArrayList;
import java.util.Map;

public class Classroom
{
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
        Student[] result = new Student[pupils.size()];

        for(Integer i = 0; i < pupils.size(); i++)
        {
            result[i] = pupils.get(i);
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
        for(Integer i = 0; i < pupils.size(); i++)
        {
            if(pupils.get(i).getFirstName() == firstName && pupils.get(i).getLastName() == lastName)
            {
                pupils.remove(i);
            }
        }
    }

    public Student[] getStudentsByScore()
    {

        return null;
    }

    public Map<Student, Character> getGradeBook()
    {

        return null;
    }
}
