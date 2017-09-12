package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;

public class Submesh implements Serializable {
    @XmlElementWrapper(name = "faces")
    @XmlElement(name = "face")
    private List<Face> faces;

    public Submesh() {
    }

    public Submesh(List<Face> faces) {
        this.faces = faces;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }
}
