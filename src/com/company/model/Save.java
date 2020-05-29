package com.company.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Save {

    public void save(String nameOfFile, ArrayList<Student> profs, int length) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element root = document.createElement("students");
        document.appendChild(root);
        for (int i = 0; i < length; i++) {

            Element student = document.createElement("student");

            student.setAttribute("name", profs.get(i).getName());
            student.setAttribute("group", Integer.toString(profs.get(i).getGroup()));
            student.setAttribute("illnesses", Integer.toString(profs.get(i).getIllnesses()));
            student.setAttribute("reasons", Integer.toString(profs.get(i).getReasons()));
            student.setAttribute("noReasons", Integer.toString(profs.get(i).getNoReasons()));
            student.setAttribute("all", Integer.toString(profs.get(i).getAll()));


            root.appendChild(student);


        }
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(nameOfFile)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
