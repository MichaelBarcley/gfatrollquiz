package com.evilcorp.trollquiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "text")
  private String text;

  @Column(name = "correct")
  private boolean isCorrect;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JsonIgnore
  private QuizQuestion quizQuestion;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JsonIgnore
  private UserModel userModel;

  public Answer() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }

  public QuizQuestion getQuizQuestion() {
    return quizQuestion;
  }

  public void setQuizQuestion(QuizQuestion quizQuestion) {
    this.quizQuestion = quizQuestion;
  }

  public UserModel getUserModel() {
    return userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }
}
