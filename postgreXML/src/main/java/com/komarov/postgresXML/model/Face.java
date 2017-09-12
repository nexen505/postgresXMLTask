package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Face implements Serializable {
    private float v1;
    private float v2;
    private float v3;

    public Face() {
    }

    public Face(float v1, float v2, float v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @XmlAttribute
    public float getV1() {
        return v1;
    }

    public void setV1(float v1) {
        this.v1 = v1;
    }

    @XmlAttribute
    public float getV2() {
        return v2;
    }

    public void setV2(float v2) {
        this.v2 = v2;
    }

    @XmlAttribute
    public float getV3() {
        return v3;
    }

    public void setV3(float v3) {
        this.v3 = v3;
    }
}
