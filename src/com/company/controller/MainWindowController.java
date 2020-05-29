package com.company.controller;

import com.company.model.Dom;
import com.company.model.Model;
import com.company.model.Student;
import com.company.model.Save;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainWindowController {
    private Model model;

    private int numOfNotes = 5;
    private int lastNote = 0;
    private int numOfPage = 1;
    private int files;

    public MainWindowController(Model model) {
        this.model = model;
    }

    public String[][] convertData(ArrayList<Student> students) {
        String[][] data = new String[students.size()][6];

        for (int i = 0; i < students.size(); i++) {
            data[i][0] = students.get(i).getName();
            data[i][1] = Integer.toString(students.get(i).getGroup());
            data[i][2] = Integer.toString(students.get(i).getIllnesses());
            data[i][3] = Integer.toString(students.get(i).getReasons());
            data[i][4] = Integer.toString(students.get(i).getNoReasons());
            data[i][5] = Integer.toString(students.get(i).getAll());
        }
        return data;
    }

    public void setStudent(String[][] data) {
        ArrayList<Student> students = new ArrayList<>();
        for (String[] datum : data) {

            Student student = new Student(datum[0], Integer.parseInt(datum[1]), Integer.parseInt(datum[2]), Integer.parseInt(datum[3]), Integer.parseInt(datum[4]), Integer.parseInt(datum[5]));
            students.add(student);
        }
        model.setStudents(students);
    }

    public ArrayList<Student> getStudent() {
        return model.getStudents();
    }

    public void fileChose(int file) {
        files = file;
        switch (file) {
            case 1: {
                Dom dom = new Dom();
                model.setStudents(dom.download(1));
                break;
            }
            case 2: {
                Dom dom = new Dom();
                model.setStudents(dom.download(2));
                break;
            }
            case 3: {
                Dom dom = new Dom();
                model.setStudents(dom.download(3));
                break;
            }
        }

    }

    public int getNumOfNotes() {
        return numOfNotes;
    }

    public void setNumOfNotes(int numOfNotes) {
        this.numOfNotes = numOfNotes;
        lastNote = 0;
        numOfPage = 1;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public String[][] getData() {
        String[][] data = convertData(model.getStudents());
        String[][] tempArray = new String[numOfNotes][6];
        int temp = 0;
        for (int i = lastNote; i < numOfNotes + lastNote; i++) {
            System.arraycopy(data[i], 0, tempArray[temp], 0, 6);
            temp++;
        }

        return tempArray;
    }

    public String[] getColumnNames() {
        return model.getColumnNames();
    }

    public Integer getNumberOfAllNotes() {
        String[][] data = convertData(model.getStudents());


        return data.length;
    }

    public void setNewNote(String[] newNote) {
        String[][] data = convertData(model.getStudents());
        String[][] tempArray = Arrays.copyOf(data, data.length + 1);
        tempArray[tempArray.length - 1] = newNote;
        setStudent(tempArray);
    }

    public void nextPage() {
        if (lastNote + numOfNotes + numOfNotes <= getNumberOfAllNotes()) {
            lastNote = lastNote + numOfNotes;
        } else {
            lastNote = getNumberOfAllNotes() - numOfNotes;
        }
        numOfPage++;
    }

    public void previousPage() {
        if (lastNote - numOfNotes + numOfNotes >= numOfNotes) {
            lastNote = lastNote - numOfNotes;
        } else {
            lastNote = 0;
        }
        numOfPage--;
    }

    public void numOfPage(int numOfPage) {
        lastNote = 0;
        numOfPage = 1;
        for (int i = 0; i < numOfPage; i++) {
            nextPage();
        }
        this.numOfPage = numOfPage;
    }

    public void firstPage() {
        lastNote = 0;
        numOfPage = 1;
    }

    public void lastPage() {
        lastNote = getNumberOfAllNotes() - numOfNotes;
        int tempPage = getNumberOfAllNotes() / numOfNotes;
        if (tempPage * numOfNotes == getNumberOfAllNotes()) {
            numOfPage = getNumberOfAllNotes() / numOfNotes;
        } else {
            numOfPage = getNumberOfAllNotes() / numOfNotes + 1;
        }

    }

    public String[] chose(int numOfColumn) {
        String[][] allData = convertData(model.getStudents());
        String[] exclusiveData = new String[allData.length];
        int length = 0;

        for (String[] allDatum : allData) {
            boolean[] check = new boolean[allData.length];
            //если есть совпадение то тру
            for (int j = 0; j < allData.length; j++) {

                check[j] = Objects.equals(allDatum[numOfColumn], exclusiveData[j]);
            }

            boolean lastCheck = false;

            for (int k = 0; k < allData.length; k++) {
                if (check[k]) { //если нашли совпадение то флаг становится тру и выходим из цикла
                    lastCheck = true;
                    break;
                }
            }

            if (!lastCheck) {//если флаг остался фолс то записываем новую запись
                exclusiveData[length] = allDatum[numOfColumn];
                length++;
            }
        }

        String[] returnData = new String[length];

        System.arraycopy(exclusiveData, 0, returnData, 0, length);
        return returnData;
    }

    public String[][] getSearchedData(String string, int column) {
        String[][] data = convertData(model.getStudents());
        String[][] tempData = new String[data.length][6];
        int length = 0;

        for (String[] datum : data) {
            if (Objects.equals(datum[column], string)) {
                tempData[length] = datum;
                length++;
            }

        }

        String[][] lastData = new String[length][6];
        System.arraycopy(tempData, 0, lastData, 0, length);
        return lastData;

    }

    public String[][] getSearchedNullData(int column) {
        String[][] data = convertData(model.getStudents());
        String[][] tempData = new String[data.length][6];
        int length = 0;

        for (String[] datum : data) {
            if (!Objects.equals(datum[column], "0")) {
                tempData[length] = datum;
                length++;
            }

        }

        String[][] lastData = new String[length][6];
        System.arraycopy(tempData, 0, lastData, 0, length);
        return lastData;

    }

    public String[][] getSearchedFromToData(int from, int to, int column) {
        String[][] data = convertData(model.getStudents());
        String[][] tempData = new String[data.length][6];
        int length = 0;
        for (int k = from; k < to; k++) {
            String string;
            string = Integer.toString(k);

            for (String[] datum : data) {
                if (Objects.equals(datum[column], string)) {
                    tempData[length] = datum;
                    length++;
                }

            }
        }

        String[][] lastData = new String[length][6];
        System.arraycopy(tempData, 0, lastData, 0, length);
        return lastData;

    }

    public void deleteData(String string, int column) {
        String[][] data = convertData(model.getStudents());
        String[][] tempData = new String[data.length][6];
        int length = 0;

        for (String[] datum : data) {
            if (!Objects.equals(datum[column], string)) {
                tempData[length] = datum;
                length++;
            }
        }
        String[][] lastData = new String[length][6];
        System.arraycopy(tempData, 0, lastData, 0, length);
        setStudent(lastData);


    }

    public void deleteNullData(int column) {
        String[][] data = convertData(model.getStudents());
        String[][] tempData = new String[data.length][6];
        int length = 0;

        for (String[] datum : data) {
            if (Objects.equals(datum[column], "0")) {
                tempData[length] = datum;
                length++;
            }
        }
        String[][] lastData = new String[length][6];
        System.arraycopy(tempData, 0, lastData, 0, length);
        setStudent(lastData);


    }

    public void saving(int file, ArrayList<Student> prof) {
        Save save = new Save();
        String name = "test1.xml";
        switch (file) {
            case 1: {
                name = "test1.xml";
                break;
            }
            case 2: {
                name = "test2.xml";
                break;
            }
            case 3: {
                name = "test3.xml";
                break;
            }
        }
        save.save(name, prof, getNumberOfAllNotes());
    }

    public int getFiles() {
        return files;
    }
}
