package com.komarov.postgresXML.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "objects")
public class ObjectInfo implements Serializable {

    @Id
    @Column(name = "id_file")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "objectinfo_seq")
    @SequenceGenerator(name = "objectinfo_seq", sequenceName = "objectinfo_seq", allocationSize = 1)
    private int id;

    @Column(name = "X")
    private float x;

    @Column(name = "Y")
    private float y;

    @Column(name = "Z")
    private float z;

    @Column(name = "QW")
    private float qw;

    @Column(name = "QX")
    private float qx;

    @Column(name = "QY")
    private float qy;

    @Column(name = "QZ")
    private float qz;

    @Column(name = "id_obj")
    private String objectName;

    public ObjectInfo() {
    }

    public ObjectInfo(float x, float y, float z, float qw, float qx, float qy, float qz, String objectName) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.qw = qw;
        this.qx = qx;
        this.qy = qy;
        this.qz = qz;
        this.objectName = objectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", qw=" + qw +
                ", qx=" + qx +
                ", qy=" + qy +
                ", qz=" + qz +
                ", objectName='" + objectName + '\'' +
                '}';
    }
}
