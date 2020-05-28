package com.company.view;

import com.company.controller.MainWindowController;
import javax.swing.*;
import java.awt.*;

public class HiWindow extends JFrame{






        private JButton HiButton;


        private MainWindowController controller;

        public HiWindow(MainWindowController controller){
            this.controller=controller;
        }

        public void init(){



            JFrame frame = new JFrame();
            JPanel panel = new JPanel();
            panel.setLayout(null);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            frame.setBounds(dimension.width/2-100,dimension.height/2-100,200,200);
            frame.setTitle("Hi!");

            panel.setBackground(Color.black);

            HiButton = new JButton("Hi");
            HiButton.setLocation(40, 50);
            HiButton.setSize(100,50);





            panel.add(HiButton);



            HiButton.addActionListener(e -> {

                frame.dispose();
                DownloadWindow createOrDownloadWindow = new DownloadWindow(controller);
                createOrDownloadWindow.init();

            });




            frame.setVisible(true);
            frame.setContentPane(panel);
        }
    }




