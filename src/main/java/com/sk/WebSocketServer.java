package com.sk;

import io.vertx.core.AbstractVerticle;

public class WebSocketServer extends AbstractVerticle {
   @Override
   public void start() throws Exception {
      vertx.createHttpServer()
         .websocketHandler(ws -> {
            System.out.println(ws.toString());
//            ws.handler(ws::writeBinaryMessage);
            ws.handler(str -> {
               ws.writeFinalTextFrame(str.toString());
            });
         })
         .requestHandler(req -> {
         if (req.uri().equals("/"))
            req.response().sendFile("www/ws.html");
      }).listen(8080);
   }
}
