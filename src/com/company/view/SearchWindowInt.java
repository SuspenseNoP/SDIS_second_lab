package com.company.view;

import com.company.controller.MainWindowController;


import javax.swing.*;
import java.awt.*;

public class SearchWindowInt {
    private MainWindowController controller;
    private int numOfCase;

    public SearchWindowInt(MainWindowController controller, int numOfCase) {
        this.controller = controller;
        this.numOfCase = numOfCase;
    }


    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 320, 200);
        frame.setTitle("Search");

        panel.setBackground(Color.black);

        switch (numOfCase) {
            case 2: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select number of pass cause of illness ");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(290, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                JTextField smallField;
                smallField = new JTextField(15);
                smallField.setLocation(20, 50);
                smallField.setSize(50, 20);
                //smallField.setToolTipText("Короткое поле");
                smallField.addActionListener(e -> {
                    // Отображение введенного текста
                    smallField.getText();
                });
                panel.add(smallField);

                JTextField small2Field;
                small2Field = new JTextField(15);
                small2Field.setLocation(90, 50);
                small2Field.setSize(50, 20);

                panel.add(small2Field);


                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String from = smallField.getText();
                    String to = small2Field.getText();

                    SearchNotesInt searchNotesInt = new SearchNotesInt(controller, from, to, 2);
                    searchNotesInt.init();

                    frame.dispose();
                });
                break;
            }

            case 3: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select number of pass cause of reasons");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(290, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                JTextField smallField;
                smallField = new JTextField(15);
                smallField.setLocation(20, 50);
                smallField.setSize(50, 20);
                //smallField.setToolTipText("Короткое поле");
                smallField.addActionListener(e -> {
                    // Отображение введенного текста
                    smallField.getText();
                });
                panel.add(smallField);

                JTextField small2Field;
                small2Field = new JTextField(15);
                small2Field.setLocation(90, 50);
                small2Field.setSize(50, 20);

                panel.add(small2Field);


                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String from = smallField.getText();
                    String to = small2Field.getText();

                    SearchNotesInt searchNotesInt = new SearchNotesInt(controller, from, to, 3);
                    searchNotesInt.init();

                    frame.dispose();
                });
                break;
            }
            case 4: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select number of pass cause of nothing ");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(290, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                JTextField smallField;
                smallField = new JTextField(15);
                smallField.setLocation(20, 50);
                smallField.setSize(50, 20);
                //smallField.setToolTipText("Короткое поле");
                smallField.addActionListener(e -> {
                    // Отображение введенного текста
                    smallField.getText();
                });
                panel.add(smallField);

                JTextField small2Field;
                small2Field = new JTextField(15);
                small2Field.setLocation(90, 50);
                small2Field.setSize(50, 20);

                panel.add(small2Field);


                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String from = smallField.getText();
                    String to = small2Field.getText();

                    SearchNotesInt searchNotesInt = new SearchNotesInt(controller, from, to, 4);
                    searchNotesInt.init();

                    frame.dispose();
                });
                break;
            }
            case 5: {

                String[] columnNames = controller.getColumnNames();
                String[] choose = {columnNames[2], columnNames[3], columnNames[4]};

                JComboBox searchList = new JComboBox(choose);
                searchList.setLocation(10, 20);
                searchList.setSize(200, 30);
                panel.add(searchList);


                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {

                    int column = searchList.getSelectedIndex() + 2;


                    SearchNullNotes searchNullNotes = new SearchNullNotes(controller, column);
                    searchNullNotes.init();

                    frame.dispose();
                });
                break;
            }
        }


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}


