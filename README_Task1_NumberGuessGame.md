# CODSOFT Java Development Internship — Task 1: Number Guessing Game

## About
A console-based Number Guessing Game built in core Java.

## Features
- Generates a random number between 1 and 100
- Accepts user guesses and gives "too high / too low / correct" feedback
- Limits the player to 7 attempts per round
- Supports multiple rounds — play again after each round
- Scores each round based on how few attempts were used
- Shows a final summary (rounds played, rounds won) at the end

## How to Run
```bash
javac NumberGuessGame.java
java NumberGuessGame
```

## Sample Output
```
===================================
      NUMBER GUESSING GAME
      CodSoft Java Internship
===================================

I'm thinking of a number between 1 and 100. You have 7 attempts.
Attempt 1/7 - Enter your guess: 50
Too high! Try a lower number.
Attempt 2/7 - Enter your guess: 25
Too low! Try a higher number.
Attempt 3/7 - Enter your guess: 37
Correct! You guessed it in 3 attempt(s).
Points earned this round: 50

Do you want to play another round? (yes/no): no

===================================
           GAME SUMMARY
===================================
Rounds played : 1
Rounds won    : 1
Thanks for playing! Goodbye.
```

## Author
CSE, JNTU Kakinada — CodSoft Java Development Intern
