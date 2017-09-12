package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.NONE)
public class Vertex implements Serializable {
    private Position position;

    public Vertex() {
    }

    public Vertex(Position position) {
        this.position = position;
    }

    @XmlElement
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
