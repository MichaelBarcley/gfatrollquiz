import { Answer } from './answer.model';

export interface QuizQuestion {
    question: string;
    answers: [Answer, Answer, Answer, Answer];
}
