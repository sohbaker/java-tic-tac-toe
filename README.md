# Java Tic Tac Toe

## Tasks

### Task 1
- [X] Create a Human vs Human Tic Tac Toe game in Java, to run on the command line.

## Language
This application is written in [Java](https://openjdk.java.net/) version 12.

## Testing
This application uses [Gradle](https://docs.gradle.org/current/userguide/what_is_gradle.html) for build automation and [JUnit](https://junit.org/junit5/) for testing.
- Tests can be run using the command `gradle test` or `./gradlew test` (depending on whether you are using gradle wrapper).
- You can view the test report by opening the HTML output file, located at `./build/reports/tests/test/index.html`.

## Running the application
1. Type `gradle clean build` or `./gradlew clean build` to compile.
2. Type `gradle --console plain run --args='saved_game.txt'` or `./gradlew --console plain run --args='saved_game.txt'` to start the game.