package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;

public class Geometry implements Serializable {
    @XmlAttribute(name = "vertexcount")
    private int vertexCount;

    @XmlElementWrapper(name = "vertexbuffer")
    @XmlElement(name = "vertex")
    private List<Vertex> vertexBuffer;

    public Geometry() {
    }

    public Geometry(int vertexCount, List<Vertex> vertexBuffer) {
        this.vertexCount = vertexCount;
        this.vertexBuffer = vertexBuffer;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public List<Vertex> getVertexBuffer() {
        return vertexBuffer;
    }

    public void setVertexBuffer(List<Vertex> vertexBuffer) {
        this.vertexBuffer = vertexBuffer;
    }
}
