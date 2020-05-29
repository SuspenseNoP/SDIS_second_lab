package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {
    private JButton createButton, searchButton, numberOfNotesButton;
    private JButton firstButton, previousButton, numberOfPageButton, nextButton, lastButton, saveButton;
    private MainWindowController controller;

    public MainWindow(MainWindowController controller) {
        this.controller = controller;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200, 500, 600);
        frame.setTitle("MAIN WINDOW ");


        JLabel number_of_notes = new JLabel();
        number_of_notes.setText("I found " + controller.getNumberOfAllNotes() + " notes");

        panel.add(number_of_notes);


        JLabel emptySpace = new JLabel();
        emptySpace.setText("                                ");


        createButton = new JButton("Create");

        searchButton = new JButton("Search and delete");

        Integer tempNum = controller.getNumOfNotes();
        numberOfNotesButton = new JButton(tempNum.toString());
        firstButton = new JButton("<<");
        previousButton = new JButton("<");
        Integer tempPage = controller.getNumOfPage();
        numberOfPageButton = new JButton(tempPage.toString());
        nextButton = new JButton(">");
        lastButton = new JButton(">>");
        saveButton = new JButton("Save");

        panel.add(createButton);

        panel.add(searchButton);

        panel.add(numberOfNotesButton);
        panel.add(emptySpace);
        panel.add(firstButton);
        panel.add(previousButton);
        panel.add(numberOfPageButton);
        panel.add(nextButton);
        panel.add(lastButton);
        panel.add(saveButton);

        JTable table = new JTable(controller.getData(), controller.getColumnNames());
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);


        createButton.addActionListener(e -> {
            frame.dispose();
            NewNote newNote = new NewNote(controller);
            newNote.init();
        });


        searchButton.addActionListener(e -> {

            SearchPattern searchPattern = new SearchPattern(controller);
            searchPattern.init();
            frame.dispose();
        });


        numberOfNotesButton.addActionListener(e -> {

            frame.dispose();
            NumberOfNotes numberOfNotes = new NumberOfNotes(controller);
            numberOfNotes.init();
        });

        firstButton.addActionListener(e -> {
            controller.firstPage();
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        previousButton.addActionListener(e -> {
            controller.previousPage();
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        numberOfPageButton.addActionListener(e -> {
            frame.dispose();
            NumberOfPage numberOfPage = new NumberOfPage(controller);
            numberOfPage.init();
        });

        nextButton.addActionListener(e -> {
            controller.nextPage();
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        lastButton.addActionListener(e -> {
            controller.lastPage();
            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        saveButton.addActionListener(e -> {
            controller.saving(controller.getFiles(), controller.getStudent());
        });


        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
}
