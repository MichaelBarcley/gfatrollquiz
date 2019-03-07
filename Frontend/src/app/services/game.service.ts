import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Answer } from '../models/answer.model';
import { QuizQuestion } from '../models/quiz-question.model';

@Injectable({
  providedIn: 'root'
})
export class GameService {
  readonly rootUrl = 'http://localhost:8080';

  //Temp mocks
  answer1 : Answer = {
    option: "1",
    isCorrect: false
  };
  answer2 : Answer = {
    option: "2",
    isCorrect: false
  };
  answer3 : Answer = {
    option: "3",
    isCorrect: false
  };
  answer4 : Answer = {
    option: "4",
    isCorrect: true
  };
  question1: QuizQuestion = {
    question: "What is 2+2?",
    answers: [this.answer1, this.answer2, this.answer3, this.answer4]
  };

  constructor(private http: HttpClient) { }

  getRandomQuestion(): QuizQuestion {
    return this.question1;
  }
}
