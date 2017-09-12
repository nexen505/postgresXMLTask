package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class Submesh implements Serializable {
    private List<Face> faces;
    private Geometry geometry;

    public Submesh() {
    }

    public Submesh(List<Face> faces, Geometry geometry) {
        this.faces = faces;
        this.geometry = geometry;
    }

    @XmlElementWrapper(name = "faces")
    @XmlElement(name = "face")
    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }

    @XmlElements({
            @XmlElement(name = "geometry", type = Geometry.class),
            @XmlElement(name = "sharedgeometry", type = Geometry.class)
    })
    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
