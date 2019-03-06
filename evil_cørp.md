# Project Outline
- Repo + Springboot starter
- MySQL, Spring, Thymeleaf, Bootstrap, Hybernate
- Jenkins pipeline, Bootjar & Test,

# Ha működik:
- Docker, AWS Deploy: EC2 + RDS

# Structure:

*Models:*
- User
- QuizQuestion
- Answer

*Pages:*
- Login
- Addquestion
- Profil
- QuizQuestion
- Leaderboard
- QuestionList(Admin Only)

*Answer:*
>    - long id
>    - string text/content
>    - boolean isCorrect
>    - (quizquestion question)
>    - (User user)


*QuizQuestion:*
>    - long id
>    - string question
>    - List<Answer> answers
>    - (User user)
>    - boolean isVerified

*User:*
>    - long id
>    - string role
>    - string username
>    - string pwd
>    - string token
>    - int points
>    - int coints
>    - List<QuizQuestion> submitted questions
>    -List<Answer> submitted answers

## © Evil Cørp
