package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.NONE)
public class Position implements Serializable {
    private float x;
    private float y;
    private float z;

    public Position() {
    }

    public Position(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @XmlAttribute
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    @XmlAttribute
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @XmlAttribute
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
