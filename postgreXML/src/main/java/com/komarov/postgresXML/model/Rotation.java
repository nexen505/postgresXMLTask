package com.komarov.postgresXML.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.NONE)
public class Rotation implements Serializable {

    private float qw;
    private float qx;
    private float qy;
    private float qz;

    public Rotation() {
    }

    public Rotation(float qw, float qx, float qy, float qz) {
        this.qw = qw;
        this.qx = qx;
        this.qy = qy;
        this.qz = qz;
    }

    @XmlAttribute
    public float getQw() {
        return qw;
    }

    public void setQw(float qw) {
        this.qw = qw;
    }

    @XmlAttribute
    public float getQx() {
        return qx;
    }

    public void setQx(float qx) {
        this.qx = qx;
    }

    @XmlAttribute
    public float getQy() {
        return qy;
    }

    public void setQy(float qy) {
        this.qy = qy;
    }

    @XmlAttribute
    public float getQz() {
        return qz;
    }

    public void setQz(float qz) {
        this.qz = qz;
    }
}
