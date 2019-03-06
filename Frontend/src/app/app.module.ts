import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { GameComponent } from './components/game/game.component';
import { LandingComponent } from './components/landing/landing.component';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { NewQuestionComponent } from './components/new-question/new-question.component';
import { AdminComponent } from './components/admin/admin.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    GameComponent,
    LandingComponent,
    LeaderboardComponent,
    NewQuestionComponent,
    AdminComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
