# LinguaFlow: Language Learning App

Console application for learning foreign words with spaced repetition.
Final project for the Design Patterns course (Java).

## Features
- Lessons with words and several kinds of exercises (translation, reverse translation, scramble)
- Spaced repetition with three study modes: easy / normal / hard
- Progress bar, achievements and review reminders after every answer
- "Skip 1 day" option to demonstrate repetition without waiting

## Design patterns

| Pattern | Type | Role in the project | Author |
|---|---|---|---|
| Strategy | Behavioral | Spaced repetition algorithms for each study mode | Member 1 |
| Facade | Structural | `LinguaFlowFacade`: single entry point for the console UI | Member 1 |
| Observer | Behavioral | `ProgressTracker` notifies progress, achievement and reminder listeners | Member 2 |
| Factory Method | Creational | Creates exercises of different types (`ExerciseFactoryProvider`) | Member 2 |
| Builder | Creational | Assembles lesson modules | Member 3 |
| Decorator | Structural | Adds extra features to lessons/exercises | Member 3 |

## How the patterns work together
`Main` -> **Facade** -> **Factory** creates an exercise -> the user answers ->
**Strategy** calculates the next review time -> **Observer** notifies the listeners.
Lessons are assembled by the **Builder** and extended by the **Decorator**.

## Project structure
```
src/com/linguaflow/
├── Main.java
├── facade/      Facade
├── strategy/    Strategy
├── observer/    Observer (event, subject, listener)
├── factory/     Factory Method (product, creator)
├── builder/     Builder
├── decorator/   Decorator
├── model/       Word, Lesson, WordProgress
└── data/        SampleData
```

## How to run
1. Open the project in IntelliJ IDEA (JDK 17+).
2. Run `com.linguaflow.Main`.
3. Use the menu:
   - `1` take a lesson (type `/exit` to leave it)
   - `2` review due words
   - `3` change mode
   - `4` show progress
   - `5` skip one day (demo)
   - `0` exit

## Team
- Akerke: Strategy + Facade
- Dariya: Observer + Factory
- Assiya: Builder + Decorator