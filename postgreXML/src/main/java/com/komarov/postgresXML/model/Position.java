package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Position implements Serializable {
    @XmlElement
    private float x;
    @XmlElement
    private float y;
    @XmlElement
    private float z;

    public Position() {
    }

    public Position(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
