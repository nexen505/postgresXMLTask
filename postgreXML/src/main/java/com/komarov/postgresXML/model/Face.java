package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Face implements Serializable {
    private int v1;
    private int v2;
    private int v3;

    public Face() {
    }

    public Face(int v1, int v2, int v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @XmlAttribute
    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    @XmlAttribute
    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    @XmlAttribute
    public int getV3() {
        return v3;
    }

    public void setV3(int v3) {
        this.v3 = v3;
    }
}
