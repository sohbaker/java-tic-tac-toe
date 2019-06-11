# Java Tic Tac Toe

## Tasks
- [X] Create a Human vs Human Tic Tac Toe game in Java, to run on the command line.
- [X] Create a Human vs Computer Tic Tac Toe game in Java, to run on the command line.
- [X] Create a feature which allows the user to save and reload a game.

## Language
This application is written in [Java](https://openjdk.java.net/) version 12.0.1.

## Testing
This application uses [Gradle](https://docs.gradle.org/current/userguide/what_is_gradle.html) for build automation and [JUnit](https://junit.org/junit5/) for testing.
- Tests can be run using the command `gradle test` or `./gradlew test` (depending on whether you are using gradle wrapper).
- You can view the test report by opening the HTML output file, located at `./build/reports/tests/test/index.html`.

## Running the application
1. Type `gradle clean build` or `./gradlew clean build` to compile.
2. Type `gradle --console plain run` or `./gradlew --console plain run` to start a new game.
3. To reload a saved game, add the filename as an argument when running the game, e.g.`./gradlew --console plain run --args='saved_game.txt'`.