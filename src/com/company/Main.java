package com.company;

import com.company.controller.MainWindowController;
import com.company.model.GenerateFile;
import com.company.model.Model;
import com.company.view.HiWindow;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        GenerateFile generateFile = new GenerateFile();
        generateFile.init();

        Model model = new Model();
        MainWindowController controller = new MainWindowController(model);
        HiWindow hiWindow= new HiWindow(controller);

            hiWindow.init();



    }
}
