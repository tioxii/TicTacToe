package com.tioxii.multiplayer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.tioxii.tictactoe.Event;
import com.tioxii.tictactoe.PlayerController;
import com.tioxii.tictactoe.TicTacToeGame;

@ServerEndpoint(value = "/websocket", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class Channel {
    
    private static Set<Channel> channels = new CopyOnWriteArraySet<>();
    private static TicTacToeGame game = TicTacToeGame.getInstance();
    private static HashMap<Session, PlayerController> players = new HashMap<>();


    private Session session = null;

    @OnOpen
    public void onOpen(Session session) {  
        this.session = session;
        channels.add(this);
        PlayerController playerController = new PlayerController(this, game);
        players.put(session, playerController);
        game.joinGame(playerController);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        PlayerController playerController = players.get(session);
        playerController.takeTurn(message.getData());
    }

    @OnClose
    public void onClose(Session session) {
        channels.remove(this);
        PlayerController playerController = players.get(session);
        game.leaveGame(playerController);
        players.remove(session);

    }

    @OnError
    public void onError(Throwable error) {
        
    }

    public Session getSession() {
        return session;
    }

    public static void broadcast(Message message) {
        for (Channel channel : channels) {
            try {
                channel.getSession().getBasicRemote().sendObject(message);;
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        }
    }
}
