package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "mesh")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mesh implements Serializable {

    @XmlElementWrapper(name = "submeshes")
    @XmlElement(name = "submesh")
    private List<Submesh> submeshes;

    public Mesh() {
    }

    public Mesh(List<Submesh> submeshes) {
        this.submeshes = submeshes;
    }

    public List<Submesh> getSubmeshes() {
        return submeshes;
    }

    public void setSubmeshes(List<Submesh> submeshes) {
        this.submeshes = submeshes;
    }
}
