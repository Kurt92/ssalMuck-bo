package com.jt.framework.util.WebSocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
@ServerEndpoint("/chat")
public class webSocket {

    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session){

        Map<String, List<String>> res = session.getRequestParameterMap();
        if(!clients.contains(session)){
            clients.add(session);
            log.info("session open : {" + session + "}");
        } else {
            log.info("already connected");
        }

    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("receive data : " + message);
        for(Session s : clients){

            log.info("send data : " + message);
            s.getBasicRemote().sendText(message);
        }


    }

    @OnClose
    public void onClose(Session session){

        log.info("session close!!");
        clients.remove(session);

    }

}
