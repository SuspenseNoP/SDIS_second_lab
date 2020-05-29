package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class SearchPattern {

    private MainWindowController controller;

    public SearchPattern(MainWindowController controller) {
        this.controller = controller;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 100, 250, 200);
        frame.setTitle("Search");


        String[] columnNames = controller.getColumnNames();
        String[] choose = {columnNames[0], columnNames[1], columnNames[2], columnNames[3], columnNames[4], "Тип пропуска"};

        JComboBox searchList = new JComboBox(choose);
        searchList.setLocation(10, 20);
        searchList.setSize(200, 30);
        panel.add(searchList);

        JButton submitButton = new JButton("Submit");
        submitButton.setSize(100, 30);
        submitButton.setLocation(20, 120);
        panel.add(submitButton);

        submitButton.addActionListener(e -> {
            int tempIndex = searchList.getSelectedIndex();
            if (tempIndex == 0 || tempIndex == 1) {
                SearchWindow searchWindow = new SearchWindow(controller, tempIndex);
                searchWindow.init();
            } else {
                SearchWindowInt searchWindowInt = new SearchWindowInt(controller, tempIndex);
                searchWindowInt.init();
            }

            frame.dispose();


        });


        frame.setVisible(true);
        frame.setContentPane(panel);
    }
}
