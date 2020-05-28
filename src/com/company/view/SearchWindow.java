package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class SearchWindow {
    private MainWindowController controller;
    private int numOfCase;

    public SearchWindow(MainWindowController controller, int numOfCase) {
        this.controller = controller;
       this.numOfCase = numOfCase;
    }

    public int getNumOfCase() {
        return numOfCase;
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


        switch (getNumOfCase()) {
            case 0: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select Name");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(100, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                String[] tempChoose = controller.chose(0);
                JComboBox searchList = new JComboBox(tempChoose);
                searchList.setLocation(20, 50);
                searchList.setSize(200, 30);
                panel.add(searchList);

                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String tempString = (searchList.getSelectedItem()).toString();

                    SearchNotes searchNotes = new SearchNotes(controller, tempString, 0);
                    searchNotes.init();

                    frame.dispose();
                });
                break;
            }
            case 1: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select Group");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(150, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                String[] tempChoose = controller.chose(1);
                JComboBox searchList = new JComboBox(tempChoose);
                searchList.setLocation(20, 50);
                searchList.setSize(200, 30);
                panel.add(searchList);

                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String tempString = (searchList.getSelectedItem()).toString();

                    SearchNotes searchNotes = new SearchNotes(controller, tempString, 1);
                    searchNotes.init();


                    frame.dispose();


                });

                break;
            }
           /* case 2: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select Faculty");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(100, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                String[] tempChoose = controller.chose(0);
                JComboBox searchList = new JComboBox(tempChoose);
                searchList.setLocation(20, 50);
                searchList.setSize(120, 30);
                panel.add(searchList);

                JLabel SecondLabel = new JLabel();
                SecondLabel.setText("Select Academic rank");
                SecondLabel.setForeground(Color.WHITE);
                SecondLabel.setSize(150, 20);
                SecondLabel.setLocation(140, 20);
                panel.add(SecondLabel);

                String[] tempChooseNew = controller.chose(3);
                JComboBox searchListNew = new JComboBox(tempChooseNew);
                searchListNew.setLocation(140, 50);
                searchListNew.setSize(150, 30);
                panel.add(searchListNew);

                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String tempString = (searchList.getSelectedItem()).toString();
                    String tempStringNew = (searchListNew.getSelectedItem()).toString();

                    SearchNotesfor2 searchNotesfor2 = new SearchNotesfor2(controller, tempString, 0, tempStringNew, 3);
                    searchNotesfor2.init();

                    frame.dispose();


                });

                break;
            }
            case 3: {
                JLabel FirstLabel = new JLabel();
                FirstLabel.setText("Select Experience");
                FirstLabel.setForeground(Color.WHITE);
                FirstLabel.setSize(150, 20);
                FirstLabel.setLocation(20, 20);
                panel.add(FirstLabel);

                String[] tempChoose = controller.chose(5);
                JComboBox searchList = new JComboBox(tempChoose);
                searchList.setLocation(20, 50);
                searchList.setSize(200, 30);
                panel.add(searchList);

                JButton submitButton = new JButton("Submit");
                submitButton.setSize(100, 30);
                submitButton.setLocation(20, 100);
                panel.add(submitButton);

                submitButton.addActionListener(e -> {
                    String tempString = (searchList.getSelectedItem()).toString();

                    SearchNotes searchNotes = new SearchNotes(controller, tempString, 5);
                    searchNotes.init();


                    frame.dispose();


                });

                break;
            }
*/
        }

        frame.setVisible(true);
        frame.setContentPane(panel);
    }

}

