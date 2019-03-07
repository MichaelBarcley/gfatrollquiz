package com.evilcorp.trollquiz.controllers;

import com.evilcorp.trollquiz.services.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class GameRestController {

  private GameServiceImpl gameService;

  @Autowired
  public GameRestController(GameServiceImpl gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/game")
  public ResponseEntity getGame() {
    return ResponseEntity.ok().body(gameService.getGameQuestion());
  }
}
