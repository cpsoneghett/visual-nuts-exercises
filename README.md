## Visual Nuts - Java Exercises

### The Project
The project is built with Maven using Java 11.
To build and run this project, run the commands bellow:

1. Building:

`mvn clean install`

2. Running:

`java -cp target\java-exercises-1.0-SNAPSHOT.jar com.visualnuts.exercises.App`



### Project Details
####  1. First Exercise:

For the first exercise, it's a simple loop with some conditions to check and print some values.  
Initially, it was requested to run a loop from 1 to 100 to compare a number and if it's divisible for some numbers and, based on this, to print a value.  
However, to make this code more "flexible" for any other input, the method was parametrized to pass a parameter *n*, and then it can obtain all the values until *n*.

```java
public void printNumber(int n){
    // Implemented logic
}
```
#### 2. Second Exercise:

The second exercise asked to implement some more features, that are presented in the class *Exercise2*.  
For testing purposes, I have adapted the original input:  
- I created a json file containing the input;
- The file is structured in the main/java/resources folder;
- I added some more countries and information for testing purposes, without changing the original structure.

#### 3. Tests:

- The tests are structured in the test/java folder. They are divided by exercises;  
- All tests considered are unit tests only. Integration tests were not created;  
- For the Exercise 2, for each item requested was created, a test method was created;  
- In each method of *Exercise2Test* class, some Test Cases were explored and implemented, with the corresponding comment.
