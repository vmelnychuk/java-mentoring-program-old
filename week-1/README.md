## Topics to cover
* Java Basics
* Build tools
    * Gradle
* Code quality tools
    * Checkstyle
* Testing
    * JUnit
    * Mockito
* Design pattern
    * Strategy

## Materials
* Test for Java Basics [OCA / OCP Practice Tests](http://www.allitebooks.com/oca-ocp-practice-tests/), Chapter 1
* Head First Design Patterns, Chapter 1

## Practical task
Use strategy pattern implement sorting of integers with different sorting algorithms (e.g. bubble, insertion, etc. sort).

Example 1 of interaction
```shell
$ java - jar sorter.jar 1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8
time elapsed: 0.01s
```

Example 2 of interaction
```shell
$ java - jar sorter.jar 1 2 3 4 5 6 7 8
Select algorithm of sorting:
1) Bubble sort
2) Insert sort
3) Java Arrays.sort()
Your choice: 2
1 2 3 4 5 6 7 8
time elapsed: 0.01s
```
