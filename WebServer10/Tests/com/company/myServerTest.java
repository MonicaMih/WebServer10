package com.company;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class myServerTest {
    myServer server=new myServer();
    @Test
    public void setClientSocket() {
    }

    @Test
    public void setPort() {
        int port=0;
        server.setPort(port);
        assertEquals(false,server.acceptServerPort());
    }

    @Test
    public void setStateServer() {
        server.setStateServer(1);
        assertEquals(1,server.getStateServer());
    }

    @Test
    public void acceptServerPort() {
        server.acceptServerPort();
        assertEquals(1,server.acceptServerPort());
    }

    @Test
    public void setConnectionOK() {
        server.setConnectionOK(1);
        assertTrue(true);

    }

    @Test
    public void listenForClients() {
        server.setPort(8081);
        server.acceptServerPort();
        int myVar=server.conectionClient;
        assertEquals(0,myVar);
    }

    @Test
    public void readFileData() throws IOException {
        File root= new  File("www");
        File fileHTML= new File(root,"maintenance.html");
        int fileLength =(int)fileHTML.length();


    }

    @Test
    public void fileNotFound() {
    }

    @Test
    public void writeFileData() {
    }
}