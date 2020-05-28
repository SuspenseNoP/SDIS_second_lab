package com.company.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom {
    public  ArrayList<Student> download(int file) {

        ArrayList<Student> students = new ArrayList<>();

        try {
            String path = "test.xml";
            switch (file) {
                case 1: {
                    path = "test1.xml";
                    break;
                }
                case 2: {
                    path = "test2.xml";
                    break;
                }
                case 3: {
                    path = "test3.xml";
                    break;
                }

            }
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);


            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");

            System.out.println("----------------------------");



            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    Student student = new Student(eElement.getAttribute("name"),
                    Integer.parseInt(eElement.getAttribute("group")),
                    Integer.parseInt(eElement.getAttribute("illnesses")),
                            Integer.parseInt(eElement.getAttribute("reasons")),
                            Integer.parseInt(eElement.getAttribute("noReasons")),
                            Integer.parseInt(eElement.getAttribute("all"))
                    );

                    students.add(student);



                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return  students;
    }
}
