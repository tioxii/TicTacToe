package com.tioxii.multiplayer;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class MessageDecoder implements Decoder.Text<Message> {

    private static Gson gson = new Gson();

    @Override
    public void destroy() {}

    @Override
    public void init(EndpointConfig arg0) {}

    @Override
    public Message decode(String str) throws DecodeException {
        return gson.fromJson(str, Message.class);
    }

    @Override
    public boolean willDecode(String str) {
        return (str != null);
    }
}
