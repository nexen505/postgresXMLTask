package com.komarov.postgresXML.app;

import com.komarov.postgresXML.model.Mesh;

import javax.xml.bind.JAXBContext;
import java.io.FileInputStream;

public class XMLSaver {

    public static void main(String[] args) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Mesh.class);
            final String path = "D:\\Универ\\git repo\\postgresXMLTask\\Attachments_eminaev@gmail.com_2017-09-12_11-55-54\\result1.xml";
            final FileInputStream fs = new FileInputStream(path);
            Mesh mesh = (Mesh) ctx.createUnmarshaller().unmarshal(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
