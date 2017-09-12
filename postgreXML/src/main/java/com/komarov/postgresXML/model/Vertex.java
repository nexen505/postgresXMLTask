package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Vertex implements Serializable {
    @XmlElement
    private Position position;

    public Vertex() {
    }

    public Vertex(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
