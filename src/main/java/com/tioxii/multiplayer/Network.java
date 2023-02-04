package com.tioxii.multiplayer;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

public class Network {    
    ArrayList<Connection> connections = new ArrayList<>();;

    @ServerEndpoint("/chess")
    public class Connection {
        private Session session = null;
        
        @OnOpen
        public void onOpen(Session session) throws IOException {
            this.session = session;
            connections.add(this);
        }

        @OnMessage
        public void onMessage(Session session, String message) throws IOException {

        }

        @OnClose
        public void onClose(Session session) throws IOException {
            connections.remove(this);
        }

        @OnError
        public void onError(Session session, Throwable throwable) {
            // Do error handling here
        }
    }

    public void broadcast(String message) throws IOException {
        for (Connection connection : connections) {
            try {
                connection.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
