package com.sk;

import io.vertx.core.Vertx;

public class ServerMain {
   public static void main(String[] args) {
      System.out.println("hello world");
      Vertx vertx = Vertx.vertx();
      vertx.deployVerticle(new WebSocketServer());
   }
}
