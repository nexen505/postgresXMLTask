package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "mesh")
@XmlAccessorType(XmlAccessType.NONE)
public class Mesh implements Serializable {

    private List<Submesh> submeshes;
    private List<Node> nodes;
    private Geometry geometry;

    public Mesh() {
    }

    public Mesh(List<Submesh> submeshes, List<Node> nodes, Geometry geometry) {
        this.submeshes = submeshes;
        this.nodes = nodes;
        this.geometry = geometry;
    }

    @XmlElementWrapper(name = "submeshes")
    @XmlElement(name = "submesh")
    public List<Submesh> getSubmeshes() {
        return submeshes;
    }

    public void setSubmeshes(List<Submesh> submeshes) {
        this.submeshes = submeshes;
    }

    @XmlElementWrapper(name = "nodes")
    @XmlElement(name = "node")
    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
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
