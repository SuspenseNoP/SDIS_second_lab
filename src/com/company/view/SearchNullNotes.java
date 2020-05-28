package com.company.view;

import com.company.controller.MainWindowController;

import javax.swing.*;
import java.awt.*;

public class SearchNullNotes {
    private MainWindowController controller;

    private int column;

    public SearchNullNotes(MainWindowController controller, int column) {
        this.controller = controller;

        this.column = column;
    }

    public void init() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200, 500, 600);
        frame.setTitle("MAIN WINDOW ");

        panel.setBackground(Color.black);

        JButton deleteButton = new JButton("Delete");
        panel.add(deleteButton);

        JButton MainWindowButton = new JButton("To main window");
        panel.add(MainWindowButton);

        JTable table = new JTable(controller.getSearchedNullData(column), controller.getColumnNames());
        table.setRowHeight(30);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane);


        deleteButton.addActionListener(e -> {
            controller.deleteNullData( column);
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
