package com.company.view;

import com.company.controller.MainWindowController;


import javax.swing.*;
import java.awt.*;


public class DownloadWindow extends JFrame{



        private JButton downloadButton;


        private MainWindowController controller;

        public DownloadWindow(MainWindowController controller){
            this.controller=controller;
        }

        public void init(){
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            panel.setLayout(null);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            frame.setBounds(dimension.width/2-100,dimension.height/2-100,280,110);
            frame.setTitle("download?");

            panel.setBackground(Color.black);



            downloadButton = new JButton("download");
            downloadButton.setLocation(20, 10);
            downloadButton.setSize(200, 50);



            panel.add(downloadButton);





            downloadButton.addActionListener(e -> {
                frame.dispose();
                DownloadChoose downloadChoose = new DownloadChoose(controller);
                downloadChoose.init();

            });


            frame.setVisible(true);
            frame.setContentPane(panel);
        }
    }


