import { Component, OnInit } from '@angular/core';
import { GameService } from 'src/app/services/game.service';
import { QuizQuestion } from 'src/app/models/quiz-question.model';
import { Answer } from 'src/app/models/answer.model';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  currentQuestion : QuizQuestion = this.gameService.getRandomQuestion();
  currentQuestion1 : QuizQuestion = this.gameService.getNextQuestion();
  userAnswer : boolean = null; 

  constructor(private gameService : GameService) { }

  ngOnInit() {
    this.currentQuestion;
  }

  onClick(answer : Answer) {
    if (this.gameService.checkAnswer(answer)) {
      this.userAnswer = true; 
    } else {
      this.userAnswer = false; 
    }
  }

  getNextQuestion() {
    this.currentQuestion = this.currentQuestion1;
  }

}
