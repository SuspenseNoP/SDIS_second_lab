package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class SearchNotesInt {
    private MainWindowController controller;
    private String string, tostring;
    private int column;

    public SearchNotesInt(MainWindowController controller, String string, String tostring, int column) {
        this.controller = controller;
        this.string = string;
        this.tostring = tostring;
        this.column = column;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200, 500, 600);
        frame.setTitle("MAIN WINDOW ");


        JButton deleteButton = new JButton("Delete");
        panel.add(deleteButton);

        JButton MainWindowButton = new JButton("To main window");
        panel.add(MainWindowButton);

        int from = Integer.parseInt(string);
        int to = Integer.parseInt(tostring);


        JTable table = new JTable(controller.getSearchedFromToData(from, to, column), controller.getColumnNames());
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);


        deleteButton.addActionListener(e -> {
            for (int i = from; i < to; i++) {
                String tempString = Integer.toString(i);
                controller.deleteData(tempString, column);
            }

            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        MainWindowButton.addActionListener(e -> {

            frame.dispose();
            MainWindow mainWindow = new MainWindow(controller);
            mainWindow.init();
        });

        frame.setVisible(true);
        frame.setContentPane(panel);
    }

}
