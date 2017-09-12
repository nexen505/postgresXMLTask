package com.komarov.postgresXML.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "faces")
public class FaceInfo implements Serializable {

    @Id
    @Column(name = "id_file")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "X1")
    private float x1;

    @Column(name = "Y1")
    private float y1;

    @Column(name = "Z1")
    private float z1;

    @Column(name = "X2")
    private float x2;

    @Column(name = "Y2")
    private float y2;

    @Column(name = "Z2")
    private float z2;

    @Column(name = "X3")
    private float x3;

    @Column(name = "Y3")
    private float y3;

    @Column(name = "Z3")
    private float z3;

    @Column(name = "id_mat")
    private String material;

    public FaceInfo() {
    }

    public FaceInfo(int id, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, String material) {
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.x3 = x3;
        this.y3 = y3;
        this.z3 = z3;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getZ1() {
        return z1;
    }

    public void setZ1(float z1) {
        this.z1 = z1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public float getZ2() {
        return z2;
    }

    public void setZ2(float z2) {
        this.z2 = z2;
    }

    public float getX3() {
        return x3;
    }

    public void setX3(float x3) {
        this.x3 = x3;
    }

    public float getY3() {
        return y3;
    }

    public void setY3(float y3) {
        this.y3 = y3;
    }

    public float getZ3() {
        return z3;
    }

    public void setZ3(float z3) {
        this.z3 = z3;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
