package ru.aklementev.springzaebalapp;

import org.apache.catalina.startup.Tomcat;
import ru.aklementev.springzaebalapp.db.ZaebatorJDBC;
import ru.aklementev.springzaebalapp.repository.TableCreator;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final int PORT = 8080;


    public static void main(String[] args) throws Exception {

        ZaebatorJDBC.connect();
        TableCreator tableCreator = new TableCreator();
        tableCreator.createTable("CREATE TABLE ZAEBATORS" +
                        "(id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "zaebator_name VARCHAR(255) NOT NULL," +
                        "zaeb_count INTEGER NOT NULL DEFAULT 0)",
                "Table created");

        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getServer().await();
    }

    // based on AbstractEmbeddedServletContainerFactory
    private static String createTempDir() {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException ex) {
            throw new RuntimeException(
                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
                    ex
            );
        }
    }
}
