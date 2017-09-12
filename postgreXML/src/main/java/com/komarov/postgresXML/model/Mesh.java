package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "mesh")
@XmlAccessorType(XmlAccessType.NONE)
public class Mesh implements Serializable {

    private List<Submesh> submeshes;
    private List<Node> nodes;

    public Mesh() {
    }

    public Mesh(List<Submesh> submeshes, List<Node> nodes) {
        this.submeshes = submeshes;
        this.nodes = nodes;
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
}
