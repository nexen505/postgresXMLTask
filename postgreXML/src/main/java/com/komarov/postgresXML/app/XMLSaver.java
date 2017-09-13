package com.komarov.postgresXML.app;

import com.komarov.postgresXML.dao.BasicDAO;
import com.komarov.postgresXML.dao.FaceInfo;
import com.komarov.postgresXML.dao.ObjectInfo;
import com.komarov.postgresXML.model.*;

import javax.xml.bind.JAXBContext;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class XMLSaver {

    public static void main(String[] args) {
        Properties properties = new Properties();
        BasicDAO<ObjectInfo> objectInfoBasicDAO = null;
        BasicDAO<FaceInfo> dao = null;
//        final String propsPath = "D:\\Универ\\git repo\\postgresXMLTask\\postgreXML\\src\\main\\resources\\props.file";
//        final String path = "D:\\Универ\\git repo\\postgresXMLTask\\Attachments_eminaev@gmail.com_2017-09-12_11-55-54\\result2.xml";
        final String propsPath = args[0];
        final String path = args[1];
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(propsPath), "UTF-8");
             FileInputStream fs = new FileInputStream(path)) {
            System.out.println("Loading properties from " + propsPath);
            properties.load(in);
            System.out.println("Parsing XML from " + path);
            final Mesh mesh = (Mesh) JAXBContext.newInstance(Mesh.class).createUnmarshaller().unmarshal(fs);
            List<Submesh> submeshes = mesh.getSubmeshes();
            if (submeshes != null && !submeshes.isEmpty()) {
                List<FaceInfo> faceInfos = new ArrayList<>();
                submeshes.forEach((Submesh submesh) -> {
                    if (submesh != null) {
                        Geometry geometry = submesh.getGeometry();
                        if (geometry == null) {
                            geometry = mesh.getGeometry();
                        }
                        if (geometry != null && geometry.getVertexBuffer() != null && !geometry.getVertexBuffer().isEmpty()) {
                            List<Face> faces = submesh.getFaces();
                            List<Vertex> vertices = geometry.getVertexBuffer();
                            for (Face face : faces) {
                                try {
                                    if (face != null) {
                                        FaceInfo faceInfo = new FaceInfo();
                                        faceInfo.setMaterial(submesh.getMaterial());
                                        int v1 = face.getV1(), v2 = face.getV2(), v3 = face.getV3();
                                        Vertex vertex1 = vertices.get(v1), vertex2 = vertices.get(v2), vertex3 = vertices.get(v3);
                                        if (vertex1 != null && vertex1.getPosition() != null) {
                                            faceInfo.setX1(vertex1.getPosition().getX());
                                            faceInfo.setY1(vertex1.getPosition().getY());
                                            faceInfo.setZ1(vertex1.getPosition().getZ());
                                        }
                                        if (vertex2 != null && vertex2.getPosition() != null) {
                                            faceInfo.setX2(vertex2.getPosition().getX());
                                            faceInfo.setY2(vertex2.getPosition().getY());
                                            faceInfo.setZ2(vertex2.getPosition().getZ());
                                        }
                                        if (vertex3 != null && vertex3.getPosition() != null) {
                                            faceInfo.setX3(vertex3.getPosition().getX());
                                            faceInfo.setY3(vertex3.getPosition().getY());
                                            faceInfo.setZ3(vertex3.getPosition().getZ());
                                        }
                                        faceInfos.add(faceInfo);
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }
                });
                dao = new BasicDAO<>(properties);
                dao.saveEntities(faceInfos);
                dao.shutdown();
            }

            List<Node> nodes = mesh.getNodes();
            if (nodes != null && !nodes.isEmpty()) {
                List<ObjectInfo> objectInfos = new ArrayList<>();
                nodes.forEach((Node node) -> {
                    if (node != null) {
                        ObjectInfo objectInfo = new ObjectInfo();
                        objectInfo.setObjectName(node.getName());
                        Position position = node.getPosition();
                        Rotation rotation = node.getRotation();
                        if (position != null) {
                            objectInfo.setX(position.getX());
                            objectInfo.setY(position.getY());
                            objectInfo.setZ(position.getZ());
                        }
                        if (rotation != null) {
                            objectInfo.setQw(rotation.getQw());
                            objectInfo.setQx(rotation.getQx());
                            objectInfo.setQy(rotation.getQy());
                            objectInfo.setQz(rotation.getQz());
                        }
                        objectInfos.add(objectInfo);
                    }
                });
                objectInfoBasicDAO = new BasicDAO<>(properties);
                objectInfoBasicDAO.saveEntities(objectInfos);
                objectInfoBasicDAO.shutdown();
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dao != null) {
                dao.shutdown();
            }
            if (objectInfoBasicDAO != null) {
                objectInfoBasicDAO.shutdown();
            }
        }
    }
}
