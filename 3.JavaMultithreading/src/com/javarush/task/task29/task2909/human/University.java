package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University //extends Student
{
    private List<Student> students = new ArrayList<> ( );
    private int    age;
    private String name;

    public List<Student> getStudents()
        {
        return students;
        }

    public void setStudents(List<Student> students)
        {
        this.students = students;
        }

    public int getAge()
        {
        return age;
        }

    public String getName()
        {
        return name;
        }

    public void setAge(int age)
        {
        this.age = age;
        }

    public void setName(String name)
        {
        this.name = name;
        }

    public University(String name, int age)
        {
        //  super (name, age, 0);
        this.name = name;
        this.age = age;
        }

    public Student getStudentWithAverageGrade(double averageGrade)
        {
        //TODO:
        for (Student student : students)
            {
                if (student.getAverageGrade ( ) == averageGrade)
                    return student;
            }
        return null;
        }

    public Student getStudentWithMaxAverageGrade()
    {
    //TODO:
    double  max                        = 0;
    Student studentWithMaxAverageGrade = null;
    for (Student student : students)
        {
            if (student.getAverageGrade ( ) > max)
                {
                    max = student.getAverageGrade ( );
                    studentWithMaxAverageGrade = student;
                }
        }
    return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade()
        {
        //TODO:
        Student studentWithMinAverageGrade = null;
        double  min                        = students.get (0).getAverageGrade ( );
        for (Student student : students)
            {
                if (student.getAverageGrade ( ) < min)
                    {
                        min = student.getAverageGrade ( );
                        studentWithMinAverageGrade = student;
                    }
            }
        return studentWithMinAverageGrade;
        }

    public void expel(Student student)
        {
        if (students.contains (student))
            students.remove (student);
        }
}