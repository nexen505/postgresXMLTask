package com.komarov.postgresXML.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "objects")
public class ObjectInfo implements Serializable {

    @Id
    @Column(name = "id_file")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "X1")
    private float x;

    @Column(name = "Y1")
    private float y;

    @Column(name = "Z1")
    private float z;

    @Column(name = "X2")
    private float qw;

    @Column(name = "Y2")
    private float qx;

    @Column(name = "Z2")
    private float qy;

    @Column(name = "X3")
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

}
