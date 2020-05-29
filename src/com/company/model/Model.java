package com.company.model;

import java.util.ArrayList;

public class Model {


    private ArrayList<Student> students;


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    private String[] columnNames = {"ФИО", "группа", "пропуск по болезни", "пропуск по другим причинам", "пропуск без причины", "итого"};

    public String[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

}
