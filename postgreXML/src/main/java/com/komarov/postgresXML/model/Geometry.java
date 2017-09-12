package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class Geometry implements Serializable {
    private int vertexCount;

    private List<Vertex> vertexBuffer;

    public Geometry() {
    }

    public Geometry(int vertexCount, List<Vertex> vertexBuffer) {
        this.vertexCount = vertexCount;
        this.vertexBuffer = vertexBuffer;
    }

    @XmlAttribute(name = "vertexcount")
    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @XmlElementWrapper(name = "vertexbuffer")
    @XmlElement(name = "vertex")
    public List<Vertex> getVertexBuffer() {
        return vertexBuffer;
    }

    public void setVertexBuffer(List<Vertex> vertexBuffer) {
        this.vertexBuffer = vertexBuffer;
    }
}
