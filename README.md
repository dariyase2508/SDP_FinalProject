# LinguaFlow: Language Learning App

Console application for learning foreign words with spaced repetition.
Final project for the Design Patterns course (Java).

## Features
- Lessons with words, built step by step and optionally extended with hints, examples and bonus words
- Several kinds of exercises: translation, reverse translation, scramble
- Spaced repetition with three study modes: easy / normal / hard (switchable at runtime)
- Progress bar, achievements and review reminders after every answer
- "Skip 1 day" option to demonstrate repetition without waiting

## Design patterns

| Pattern | Type | Role in the project | Package | Author |
|---|---|---|---|---|
| Strategy | Behavioral | Spaced repetition algorithms for each study mode | `strategy` | Akerke |
| Facade | Structural | `LinguaFlowFacade`: single entry point for the console UI | `facade` | Akerke |
| Observer | Behavioral | `ProgressTracker` notifies progress, achievement and reminder listeners | `observer` | Dariya |
| Factory Method | Creational | Creates exercises of different types (`ExerciseFactoryProvider`) | `factory` | Dariya |
| Builder | Creational | `LessonBuilder` assembles a lesson step by step | `builder` | Assiya |
| Decorator | Structural | Adds hints, examples and bonus words to a lesson | `decorator` | Assiya |

## How the patterns work together
`Main` -> **Facade** -> **Factory** creates an exercise -> the user answers ->
**Strategy** calculates the next review time -> **Observer** notifies the listeners.
Lessons are assembled by the **Builder** and extended by the **Decorator**
(see `SampleData`).

## Project structure
```
src/com/linguaflow/
├── Main.java                console UI, talks only to the Facade
├── facade/                  Facade
├── strategy/                Strategy
├── observer/                Observer
│   ├── event/               ProgressEvent
│   ├── subject/             ProgressSubject, ProgressTracker
│   └── listener/            ProgressListener + concrete listeners
├── factory/                 Factory Method
│   ├── product/             Exercise + concrete exercises
│   └── creator/             ExerciseFactory + concrete factories
├── builder/                 LessonBuilder
├── decorator/               LessonDecorator + concrete decorators
├── model/                   shared domain classes: Word, Lesson, WordProgress
└── data/                    SampleData (demo lessons)
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