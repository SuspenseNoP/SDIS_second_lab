package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class NewNote {

    private MainWindowController mainWindowController;

    public NewNote(MainWindowController mainWindowController) {

        this.mainWindowController = mainWindowController;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 150, dimension.height / 2 - 50, 240, 200);
        frame.setTitle("New note create");


        String[] columnNames = mainWindowController.getColumnNames();

        JLabel labelName = new JLabel();
        JLabel labelGroup = new JLabel();
        JLabel labelIllnesses = new JLabel();
        JLabel labelReasons = new JLabel();
        JLabel labelNoReasons = new JLabel();


        labelName.setLocation(0, 0);
        labelGroup.setLocation(0, 20);
        labelIllnesses.setLocation(0, 40);
        labelReasons.setLocation(0, 60);
        labelNoReasons.setLocation(0, 80);


        labelName.setSize(120, 20);
        labelGroup.setSize(120, 20);
        labelIllnesses.setSize(120, 20);
        labelReasons.setSize(120, 20);
        labelNoReasons.setSize(120, 20);


        labelName.setText(columnNames[0]);
        labelGroup.setText(columnNames[1]);
        labelIllnesses.setText(columnNames[2]);
        labelReasons.setText(columnNames[3]);
        labelNoReasons.setText(columnNames[4]);


        panel.add(labelName);
        panel.add(labelGroup);
        panel.add(labelIllnesses);
        panel.add(labelReasons);
        panel.add(labelNoReasons);


        JTextField textName = new JTextField();
        JTextField textGroup = new JTextField();
        JTextField textIllnesses = new JTextField();
        JTextField textReasons = new JTextField();
        JTextField textNoReasons = new JTextField();

        textName.setLocation(120, 0);
        textGroup.setLocation(120, 20);
        textIllnesses.setLocation(120, 40);
        textReasons.setLocation(120, 60);
        textNoReasons.setLocation(120, 80);


        textName.setSize(120, 20);
        textGroup.setSize(120, 20);
        textIllnesses.setSize(120, 20);
        textReasons.setSize(120, 20);
        textNoReasons.setSize(120, 20);


        panel.add(textName);
        panel.add(textGroup);
        panel.add(textIllnesses);
        panel.add(textReasons);
        panel.add(textNoReasons);


        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100, 30);
        submitButton.setLocation(70, 130);
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            String nameText = textName.getText();
            String groupText = textGroup.getText();
            String illnessesText = textIllnesses.getText();
            String reasonsText = textReasons.getText();
            String noReasonsDegreeText = textNoReasons.getText();
            int AllText = Integer.parseInt(textIllnesses.getText()) + Integer.parseInt(textReasons.getText()) + Integer.parseInt(textNoReasons.getText());

            String[] newNote = {nameText, groupText, illnessesText, reasonsText, noReasonsDegreeText, Integer.toString(AllText)};
            mainWindowController.setNewNote(newNote);

            frame.dispose();

            MainWindow mainWindow = new MainWindow(mainWindowController);
            mainWindow.init();
        });

        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}
