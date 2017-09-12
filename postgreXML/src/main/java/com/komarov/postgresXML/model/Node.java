package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Node implements Serializable {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private Long id;

    @XmlElement
    private Position position;

    @XmlElement
    private Rotation rotation;

    public Node() {
    }

    public Node(String name, Long id, Position position, Rotation rotation) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.rotation = rotation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public void setRotation(Rotation rotation) {
        this.rotation = rotation;
    }
}
