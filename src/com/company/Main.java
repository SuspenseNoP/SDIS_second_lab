package com.company;

import com.company.controller.MainWindowController;
import com.company.model.Model;
import com.company.view.DownloadChoose;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {



    public static void main(String[] args) {

        Model model = new Model();
        MainWindowController controller = new MainWindowController(model);

        DownloadChoose downloadChoose = new DownloadChoose(controller);
        downloadChoose.init();

    }
}
