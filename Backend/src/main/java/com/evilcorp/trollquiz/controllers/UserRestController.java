package com.evilcorp.trollquiz.controllers;

import com.evilcorp.trollquiz.models.QuizQuestion;
import com.evilcorp.trollquiz.services.UserModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
public class UserRestController {

  private UserModelServiceImpl userModelService;

  @Autowired
  public UserRestController(UserModelServiceImpl userModelService) {
    this.userModelService = userModelService;
  }

  @GetMapping("/add-question")
  public ResponseEntity addQuestion(QuizQuestion quizQuestion) {
    return ResponseEntity.ok().body(userModelService.addQuestion(quizQuestion));
  }

  @PostMapping("/update-question")
  public ResponseEntity updateQuestion(QuizQuestion quizQuestion) {
    return ResponseEntity.ok().body(userModelService.updateQuestion(quizQuestion));
  }

  @DeleteMapping("/delete-question/{id}")
  public ResponseEntity deleteQuestion(@PathVariable("id") long id) {
    return ResponseEntity.ok().body(userModelService.deleteQuestion(id));
  }
}
