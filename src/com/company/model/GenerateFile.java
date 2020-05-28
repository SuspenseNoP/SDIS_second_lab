package com.company.model;


import org.w3c.dom.Document;
        import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.ParserConfigurationException;
        import javax.xml.transform.*;
        import javax.xml.transform.dom.DOMSource;
        import javax.xml.transform.stream.StreamResult;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.util.Random;

public class GenerateFile {

    public void init() {
        String[] name = {"Евгений", "Ольга", "Владимир", "Андрей", "Аастасия", "Ирина"};
        String[] group = {"821701", "821702", "821703", "821704", "921701", "921702"};
        String[] illnesses = {"0", "5", "7", "10", "15", "20"};
        String[] reasons = {"0", "5", "7", "10", "15", "20"};
        String[] noReasons = {"0", "5", "7", "10", "15", "20"};



        String[] fileNames = {"test1.xml", "test2.xml", "test3.xml"};
        for (int j = 0; j < 3; j++) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;


            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }

            Document document = builder.newDocument();
            Element root = document.createElement("students");
            document.appendChild(root);

            for (int i = 0; i < 50; i++) {
                Element student = document.createElement("student");

                Random random = new Random();
                int[] index = new int[5];
                for (int k = 0; k < 5; k++)
                    index[k] = random.nextInt(5);


                student.setAttribute("name", name[index[0]]);
                student.setAttribute("group",group[index[1]]);
                student.setAttribute("illnesses", illnesses[index[2]]);
                student.setAttribute("reasons", reasons[index[3]]);
                student.setAttribute("noReasons", noReasons[index[4]]);
                int all = Integer.parseInt(illnesses[index[2]]) + Integer.parseInt(reasons[index[3]]) +  Integer.parseInt(noReasons[index[4]]);
                student.setAttribute("all", Integer.toString(all) );


                root.appendChild(student);
            }
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (
                    TransformerConfigurationException e) {
                e.printStackTrace();
            }
            assert transformer != null;
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            try {
                transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(fileNames[j])));
            } catch (
                    TransformerException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}