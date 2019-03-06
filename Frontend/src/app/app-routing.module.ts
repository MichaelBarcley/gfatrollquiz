import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { GameComponent } from './components/game/game.component';
import { LandingComponent } from './components/landing/landing.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { AdminComponent } from './components/admin/admin.component';
import { NewQuestionComponent } from './components/new-question/new-question.component';

const routes: Routes = [
  { path: '', component: LandingComponent},
  { path: 'game', component: GameComponent},
  { path: 'leaderboard', component: LeaderboardComponent},
  { path: 'newquestion', component: NewQuestionComponent},
  { path: 'admin', component: AdminComponent},
  { path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
