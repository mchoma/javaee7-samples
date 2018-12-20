package org.javaee7.websocket.endpoint.security;

import java.security.Principal;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket")
@Stateless
public class MyEndpoint {

    @SuppressWarnings("EjbEnvironmentInspection") @Resource
    SessionContext sessionContext;

    @OnMessage

    public String echoText(Session session, String text) {
        Principal sessionP = session.getUserPrincipal();
        System.out.println(sessionP.toString());
        Principal p = sessionContext.getCallerPrincipal();
        System.out.println(p.toString());
        return text;
    }

}
