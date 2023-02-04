package com.tioxii.multiplayer;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    
    Socket clientSocket = null;

    public Connection(Socket clientSocket) {
        this.clientSocket = clientSocket;
        
    }

    public void send(String data) {
        //send chessboard data to client
    }

    public void receive() {
        //handle incoming http push requests
    }

    public void disconnect() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
