package com.youle.ws;

import com.youle.utils.Constant;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by modprobe on 2015/11/12.
 */
public class SystemWebSocketHandler implements WebSocketHandler {


    static List<WebSocketSession> socketSessionList;

    static {
        socketSessionList = new ArrayList<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        socketSessionList.add(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        //  sendMessageToUsers(message);
        sendMessageToUser("yyy", message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        socketSessionList.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        socketSessionList.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(WebSocketMessage message) {
        socketSessionList.stream().filter(WebSocketSession::isOpen).forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, WebSocketMessage message) {
        socketSessionList.stream().filter(webSocketSession ->
                        webSocketSession.isOpen() && webSocketSession.getAttributes().get(Constant.NICK_NAME_KEY).equals(userName)
        ).forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}