package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Rotation implements Serializable {

    @XmlAttribute
    private float qw;
    @XmlAttribute
    private float qx;
    @XmlAttribute
    private float qy;
    @XmlAttribute
    private float qz;

    public Rotation() {
    }

    public Rotation(float qw, float qx, float qy, float qz) {
        this.qw = qw;
        this.qx = qx;
        this.qy = qy;
        this.qz = qz;
    }

    public float getQw() {
        return qw;
    }

    public void setQw(float qw) {
        this.qw = qw;
    }

    public float getQx() {
        return qx;
    }

    public void setQx(float qx) {
        this.qx = qx;
    }

    public float getQy() {
        return qy;
    }

    public void setQy(float qy) {
        this.qy = qy;
    }

    public float getQz() {
        return qz;
    }

    public void setQz(float qz) {
        this.qz = qz;
    }
}
