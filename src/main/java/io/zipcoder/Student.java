package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>
{
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String initFirstName, String initLastName, Double[] initExamScores)
    {
        firstName = initFirstName;
        lastName = initLastName;
        examScores = new ArrayList<>();
        examScores.addAll(Arrays.asList(initExamScores));
    }

    public void setFirstName(String newName)
    {
        firstName = newName;
    }

    public void setLastName(String newName)
    {
        lastName = newName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Integer getNumberOfExamsTaken()
    {
        return examScores.size();
    }

    public String getExamScores()
    {
        StringBuilder output = new StringBuilder();

        output.append("Exam Scores:\n");
        for(Integer i = 0; i < examScores.size(); i++)
        {
            output.append(String.format("\tExam %d -> %.0f\n", i + 1, examScores.get(i)));
        }

        return output.toString();
    }

    public void addExamScore(Double examScore)
    {
        examScores.add(examScore);
    }

    public void setExamScore(Integer examNumber, Double updatedScore)
    {
        examScores.set(examNumber - 1, updatedScore);
    }

    public Double getAverageExamScore()
    {
        Double sum = 0.0;

        for(Integer i = 0; i < examScores.size(); i++)
        {
            sum += examScores.get(i);
        }

        return sum / examScores.size();
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Student Name: %s %s\n", firstName, lastName));
        output.append(String.format("Average Score: %.0f\n", getAverageExamScore()));
        output.append(getExamScores());
        return output.toString();
    }

    @Override
    public int compareTo(Student otherStudent)
    {
        // TODO: Lexigraphical ordering

        if(this.getAverageExamScore().equals(otherStudent.getAverageExamScore()))
        {
            if(this.getLastName().equals(otherStudent.getLastName()))
            {
                return -1 * this.getFirstName().compareTo(otherStudent.getFirstName());
            }
            else
            {
                return -1 * this.getLastName().compareTo(otherStudent.getLastName());
            }
        }
        else
        {
            return (int)(this.getAverageExamScore() - otherStudent.getAverageExamScore());
        }
    }
}